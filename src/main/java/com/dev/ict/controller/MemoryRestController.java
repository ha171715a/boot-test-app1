package com.dev.ict.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import com.dev.ict.service.MemoryService;

@Slf4j
@RestController
@RequestMapping("/api/mem")
public class MemoryRestController {

    private final MemoryService memoryService;

    MemoryRestController(MemoryService memoryService){
        this.memoryService = memoryService;
    }

    @PostMapping("/set-thread-local")
    public void setThreadLocal(@RequestBody String vo) {
        
    }

    @PostMapping("/get-thread-local")
    public ResponseEntity<String> getThreadLocal(@RequestBody String vo) {
        
        return null;
    }

}
