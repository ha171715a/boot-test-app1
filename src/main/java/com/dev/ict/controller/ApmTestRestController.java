package com.dev.ict.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.fwk.domain.BaseResVO;
import com.dev.ict.service.ApmTestService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Tag(name = "APM")
@Profile("apm")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/apm")
public class ApmTestRestController {

    @Value("${spring.application.name}")
    private String appName;

    
    @Value("${apm.test.number}")
    private String apmTestNumber;

    private final ApmTestService apmTestService;

    @PostMapping("/make-exception-call")
    public ResponseEntity<BaseResVO> makeExceptionCall(@RequestBody Map<String, Object> input){

        return null;
    }

}
