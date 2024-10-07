package com.dev.fwk.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
public class ServiceException extends CommonBaseException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ServiceException(String message) {
        super(null, message);
    }

    public ServiceException(String errCd, String errMsg) {
        super(errCd, errMsg);
    }
    
    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    } 
}
