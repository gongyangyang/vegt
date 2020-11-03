package com.vegt.service.exception;

public class VegtNotFoundException  extends ServiceException{
    public VegtNotFoundException() {
        super();
    }

    public VegtNotFoundException(String message) {
        super(message);
    }

    public VegtNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public VegtNotFoundException(Throwable cause) {
        super(cause);
    }

    protected VegtNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
