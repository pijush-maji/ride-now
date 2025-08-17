package com.ridenow.app.exception;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String msg){
        super(msg);
    }
}
