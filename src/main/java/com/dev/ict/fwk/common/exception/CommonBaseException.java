package com.dev.fwk.common.exception;

import org.springframework.core.NestedRuntimeException;

public abstract class CommonBaseException extends NestedRuntimeException  {
    private static final long serialVersionUID = 7084185941443795922L;

    private String errCd;
    private String errMsg;

    public CommonBaseException(String message) {
        this(null, message);
    }

    public CommonBaseException(Throwable cause) {
        this(cause != null ? cause.getMessage() : null, cause);
    }

    public CommonBaseException(String message, Throwable cause) {
        super(message);
        if (cause != null)
            super.initCause(cause);
    }

    public CommonBaseException(String errCd, String errMsg) {
        super(errMsg);
        this.errCd = errCd;
        this.errMsg = errMsg;
    }

    public CommonBaseException(String errCd, String errMsg, Throwable cause) {
        super(errMsg);
        this.errCd = errCd;
        this.errMsg = errMsg;
        if (cause != null)
            super.initCause(cause);
    }


    public String getErrCd() {
        return errCd;
    }

    public void setErrCd(String errCd) {
        this.errCd = errCd;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
