package com.dev.ict.fwk.common.interceptor;

import org.apache.commons.io.IOUtils;

import io.grpc.ForwardingServerCall;
import io.grpc.ForwardingServerCallListener;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingInterceptor implements ServerInterceptor {

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers,
                                                                 ServerCallHandler<ReqT, RespT> next) {
        
        if (log.isInfoEnabled()) {
            log.info("##################### traceRequest begin ##################");
            log.info("### URI: {}" , call.getMethodDescriptor().getBareMethodName());
            log.info("### Headers: {}" , headers);
            log.info("### Method: {}" , call.getMethodDescriptor().getFullMethodName());
        }
        return new ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT>(next.startCall(new ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT>(call) {
            @Override
            public void sendMessage(RespT message) {
                log.info("##################### traceResponse begin ##################");
                log.info("### URI / Method : {} / {}", call.getMethodDescriptor().getBareMethodName(), call.getMethodDescriptor().getFullMethodName());
                log.info("### Headers : {} ", headers);
                log.info("### Response body : {} ", message);
                log.info("##################### traceResponse end ##################");

                super.sendMessage(message);
            }
        }, headers)) {
            @Override
            public void onMessage(ReqT message) {
                log.info("### request body: {}" , message);
                log.info("##################### traceRequest end ##################");
                super.onMessage(message);
            }
        };
    }
}