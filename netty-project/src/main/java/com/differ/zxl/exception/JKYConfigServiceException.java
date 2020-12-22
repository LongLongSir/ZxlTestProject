package com.differ.zxl.exception;

public class JKYConfigServiceException extends RuntimeException {
    public JKYConfigServiceException(String msg) {
        super(msg);
    }

    public JKYConfigServiceException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public JKYConfigServiceException(Throwable cause) {
        super(cause);
    }
}
