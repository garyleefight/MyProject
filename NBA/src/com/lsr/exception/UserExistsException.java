package com.lsr.exception;

/**
 * Created by lsr on 16/10/4.
 */
public class UserExistsException extends Exception {
    public UserExistsException(String message) {
        super(message);
    }

    public UserExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
