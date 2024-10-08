package com.dev.fwk.common.client;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CacheClient extends AbstractRedisClient{

	CacheClient(@Nullable RedisTemplate<String, Object> redisTemplate) {
		super(redisTemplate);
	}

	@Override
    public void setValue(String key, Object value) {
	    try {
	        valueOperations.set(key, value);
	    } catch(Exception e) {
            log.error("CacheClient.setValue Exception[{}]", e.getMessage());
            log.error("CacheClient.setValue Exception[{}]", e.toString());
	    }
	}

	@Override
    public void setValue(String key, Object value, int expireSeconds) {
        try {
            valueOperations.set(key, value);
            valueOperations.getOperations().expire(key, expireSeconds, TimeUnit.SECONDS);
        } catch(Exception e) {
            log.error("CacheClient.setValue Exception[{}]", e.getMessage());
            log.error("CacheClient.setValue Exception[{}]", e.toString());
        }
	}

	@Override
    @SuppressWarnings("unchecked")
	public <T> T getValue(String key) {
		T object = null;

        try {
            if(Boolean.TRUE.equals(valueOperations.getOperations().hasKey(key))) {
                object = (T) valueOperations.get(key);
            }
        } catch(Exception e) {
            log.error("CacheClient.getValue Exception[{}]", e.getMessage());
            log.error("CacheClient.getValue Exception[{}]", e.toString());
        }

		return object;
	}

	@Override
    public void deleteValue(String key) {
        try {
            valueOperations.getOperations().delete(key);
        } catch(Exception e) {
            log.error("CacheClient.deleteValue Exception[{}]", e.getMessage());
            log.error("CacheClient.deleteValue Exception[{}]", e.toString());
        }
	}

	@Override
    public ValueOperations<String, Object> getValueOperations(){
		return valueOperations;
	}

    @Override
    public Set<String> getKeys(String pattern) {
        try {
            return redisTemplate.keys(pattern);
        } catch(Exception e) {
            log.error("CacheClient.getKeys Exception[{}]", e.getMessage());
            log.error("CacheClient.getKeys Exception[{}]", e.toString());
        }

        return new HashSet<>();
    }
    
}
