package com.dev.fwk.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RestClientException extends CommonBaseException {

    /**
    * 
    */
    private static final long serialVersionUID = 1L;

    public RestClientException(String message) {
        super(null, message);
    }

    public RestClientException(String errCd, String errMsg) {
        super(errCd, errMsg);
    }

    public RestClientException(Throwable cause) {
        super(cause);
    }

    public RestClientException(String message, Throwable cause) {
        super(message, cause);
    }
}