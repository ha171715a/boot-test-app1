package com.dev.fwk.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BizException extends CommonBaseException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public BizException(String message) {
        super(null, message);
    }

    public BizException(String errCd, String errMsg) {
        super(errCd, errMsg);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }
}
