package com.dev.ict.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.ict.service.SpanService;

@RestController
@RequestMapping("/api/span")
public class SpanRestController {
    private final SpanService spanService;

    public SpanRestController (SpanService spanService){
        this.spanService = spanService;
    }

    @PostMapping("/getSpanId")
    public ResponseEntity<String> getSpanId(){
        
        return null;
    }

}
