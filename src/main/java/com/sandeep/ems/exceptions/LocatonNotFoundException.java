package com.sandeep.ems.exceptions;

public class LocatonNotFoundException extends Exception {
    public LocatonNotFoundException() {
    }

    public LocatonNotFoundException(String message) {
        super(message);
    }

    public LocatonNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public LocatonNotFoundException(Throwable cause) {
        super(cause);
    }

    public LocatonNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
