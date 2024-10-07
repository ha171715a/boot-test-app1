package com.dev.fwk.common.interceptor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpClientInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        traceRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        traceResponse(request, response);
        return response;
    }

    private void traceRequest(HttpRequest request, byte[] body) throws IOException {
        if (log.isInfoEnabled()) {
            log.info("##################### traceRequest begin ##################");
            log.info("### URI : {}", request.getURI());
            log.info("### Method : {}", request.getMethod());
            log.info("### Headers : {}", request.getHeaders());
            log.info("### request body : {}", new String(body, StandardCharsets.UTF_8));
            log.info("##################### traceRequest end ##################");
        }
    }

    private void traceResponse(HttpRequest request, ClientHttpResponse response) throws IOException {
        if (log.isInfoEnabled()) {
            log.info("##################### traceResponse begin ##################");
            log.info("### URI / Method : {} / {}", request.getURI(), request.getMethod());
            log.info("### Headers : {} ", response.getHeaders());
            log.info("### statuscode : {} ", response.getStatusCode());
            log.info("### Response body : {} ", IOUtils.toString(response.getBody(), StandardCharsets.UTF_8));
            log.info("##################### traceResponse end ##################");
        }
    }   
}
