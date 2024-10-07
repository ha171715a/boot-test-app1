package com.dev.fwk.handler;

import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonCacheExceptionHandler implements CacheErrorHandler {
    @Override
    public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
        log.error("{}", exception.getMessage());
        log.error("{}", exception.toString());
    }

    /**
     * [메소드 한글명]
     *
     * <pre>
     * [메소드 개요]
     * </pre>
     *
     * @param exception
     * @param cache
     * @param key
     * @param value
     * @algorithm
     * <pre>
     * [처리로직 설명]
     * </pre>
     */
    @Override
    public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {
        log.error("{}", exception.getMessage());
        log.error("{}", exception.toString());
    }

    /**
     * [메소드 한글명]
     *
     * <pre>
     * [메소드 개요]
     * </pre>
     *
     * @param exception
     * @param cache
     * @param key
     * @algorithm
     * <pre>
     * [처리로직 설명]
     * </pre>
     */
    @Override
    public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
        log.error("{}", exception.getMessage());
        log.error("{}", exception.toString());
    }

    /**
     * [메소드 한글명]
     *
     * <pre>
     * [메소드 개요]
     * </pre>
     *
     * @param exception
     * @param cache
     * @algorithm
     * <pre>
     * [처리로직 설명]
     * </pre>
     */
    @Override
    public void handleCacheClearError(RuntimeException exception, Cache cache) {
        log.error("{}", exception.getMessage());
        log.error("{}", exception.toString());
    }
}
