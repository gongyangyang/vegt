package com.vegt.service.exception;

public class UserDuplicateException extends ServiceException{

    public UserDuplicateException() {
    }

    public UserDuplicateException(String message) {
        super(message);
    }

    public UserDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserDuplicateException(Throwable cause) {
        super(cause);
    }

    public UserDuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
