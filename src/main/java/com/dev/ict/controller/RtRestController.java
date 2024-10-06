package com.dev.ict.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.fwk.domain.BaseResVO;
import com.dev.ict.domain.SampleVO;
import com.dev.ict.service.RtService;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "sync & async")
@RestController
@RequestMapping("/api/trace")
public class RtRestController {
    private final RtService rtService;

    public RtRestController(RtService rtService){
        this.rtService = rtService;
    }


    @PostMapping("/send-now-time")
    public ResponseEntity<BaseResVO> sendNowTime(@RequestBody SampleVO vo){
        return null;
    }


}
