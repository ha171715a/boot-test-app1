package com.dev.ict.controller;

import javax.annotation.Nullable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.ict.domain.SampleVO;
import com.dev.ict.service.TraceTestService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "APM")
@RestController
@RequestMapping("/api/apm")
public class TraceTestRestController {
    private final TraceTestService traceTestService;

    public TraceTestRestController(TraceTestService traceTestService){
        this.traceTestService = traceTestService;
    }

    @PostMapping("/test-tracing")
    public ResponseEntity<String> testTracing(@RequestBody @Nullable SampleVO input ){

        return null;
    }

}
