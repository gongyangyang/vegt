package com.vegt.service.exception;

public class VegtDuplicateException extends ServiceException{
    public VegtDuplicateException() {
        super();
    }

    public VegtDuplicateException(String message) {
        super(message);
    }

    public VegtDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public VegtDuplicateException(Throwable cause) {
        super(cause);
    }

    protected VegtDuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
