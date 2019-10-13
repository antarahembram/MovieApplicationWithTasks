package com.stackroute.exception;

public class MovieAlreadyExistsException extends  Exception {

    private String message;

    public MovieAlreadyExistsException() {
    }

    public MovieAlreadyExistsException(String message) {
       //message will be displayed when exception occurs
        super(message);
        this.message=message;
    }
}
