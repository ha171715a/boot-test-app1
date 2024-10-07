package com.dev.fwk.handler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import com.dev.fwk.common.exception.BizException;
import com.dev.fwk.common.exception.ServiceException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler  {

	@Override
    public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
        return httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR ||  httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR ;
    }

    @Override
    public void handleError(ClientHttpResponse httpResponse) throws IOException {
    	
    	String errorStr = IOUtils.toString(httpResponse.getBody(), StandardCharsets.UTF_8);
        if(log.isDebugEnabled()){
            log.debug("handleError statusCode: {}", httpResponse.getStatusCode().value());
            log.debug("handleError errorStr: {}", errorStr);
        }
        if (httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {
        	throw new ServiceException(errorStr);
        	
        } else if (httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR) {
        	throwBadRequestException(httpResponse, errorStr);
        }
    }

	private void throwBadRequestException(ClientHttpResponse httpResponse, String errorStr) throws IOException {
		if (isBadRequestCode(httpResponse)) {
			throw new BizException(httpResponse.getStatusCode().toString(), errorStr);
		}
	}

	private boolean isBadRequestCode(ClientHttpResponse httpResponse)throws IOException {
		return httpResponse.getStatusCode().value() == HttpStatus.BAD_REQUEST.value();
	}
     
}
