package com.dev.ict.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.ict.domain.RedisVO;
import com.dev.ict.service.RedisTestService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Tag(name = "Cache")
@RestController
@RequestMapping("/api/cache")
public class RedisTestRestController {
    

    private final RedisTestService redisTestService;

    RedisTestRestController(RedisTestService redisTestService){
        this.redisTestService = redisTestService;
    }

    @PostMapping("/set-redis-val")
    public ResponseEntity<Void> setRedisVal(@RequestBody RedisVO input){
        return null;
    }

    @GetMapping("/get-redis-val/{key}")
    public ResponseEntity<String> getRedisVal(@PathVariable("key") String key){
        return null;
    }

    
}
