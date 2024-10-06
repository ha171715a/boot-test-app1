package com.dev.ict.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.ict.service.KafkaProducerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/kafka")
public class KafkaTestRestController {
    
    private final KafkaProducerService kafkaProducerService;

    @PostMapping("/produce-simple")
    public ResponseEntity<Void> produceSimple(@RequestBody Map<String, String> data){
        return null;
    }

}
