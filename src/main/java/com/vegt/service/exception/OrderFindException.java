package com.vegt.service.exception;

public class OrderFindException extends ServiceException{
    public OrderFindException() {
    }

    public OrderFindException(String message) {
        super(message);
    }

    public OrderFindException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderFindException(Throwable cause) {
        super(cause);
    }

    public OrderFindException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
