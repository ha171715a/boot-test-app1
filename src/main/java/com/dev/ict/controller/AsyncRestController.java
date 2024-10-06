package com.dev.ict.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.fwk.domain.BaseResVO;
import com.dev.ict.domain.SampleVO;
import com.dev.ict.service.AsyncService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "sync & async")
@RestController
@RequestMapping("/api/trace")
public class AsyncRestController {
    private final AsyncService asyncService;

    public AsyncRestController(AsyncService asyncService){
        this.asyncService = asyncService;
    }

    @PostMapping("/async-now-time")
    public ResponseEntity<BaseResVO> asyncNowTime(@RequestBody SampleVO vo) {


        return null;
    }
    

    @PostMapping("/cf-async-now-time")
    public ResponseEntity<BaseResVO> cfAsyncNowTime(@RequestBody SampleVO vo) {


        return null;
    }

    
}
