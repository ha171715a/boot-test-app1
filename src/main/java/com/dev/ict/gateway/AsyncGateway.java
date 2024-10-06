package com.dev.ict.gateway;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.AsyncRestTemplate;

import com.dev.fwk.common.exception.BizException;
import com.dev.fwk.domain.BaseResVO;
import com.dev.fwk.domain.HeaderVO;
import com.dev.fwk.util.DateUtil;
import com.dev.ict.domain.SampleVO;

import lombok.extern.slf4j.Slf4j;


public class AsyncGateway {
    
}
