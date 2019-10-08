package com.stackroute.exception;

//Used in case of movie already exists
public class MovieAlreadyExistsException extends  Exception {

    private String message;

    public MovieAlreadyExistsException() {
    }

    public MovieAlreadyExistsException(String message) {
        super(message);
        this.message=message;
    }
}
