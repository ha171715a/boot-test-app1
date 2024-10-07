package com.dev.fwk.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends CommonBaseException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ValidationException(String message) {
        super(null, message);
    }

    public ValidationException(String errCd, String errMsg) {
        super(errCd, errMsg);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
