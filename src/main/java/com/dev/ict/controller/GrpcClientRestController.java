package com.dev.ict.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.ict.service.GrpcClientService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/grpc")
public class GrpcClientRestController {
    
    private final GrpcClientService grpcClientService;

    public GrpcClientRestController(GrpcClientService grpcClientService){
        this.grpcClientService = grpcClientService;
    }

    @PostMapping("/say-hello")
    public ResponseEntity<String> sayHello(@RequestBody String name){
        return null;
    }

    @PostMapping("/get-message")
    public ResponseEntity<String> getMessage(@RequestBody String name){
        return null;
    }


}
