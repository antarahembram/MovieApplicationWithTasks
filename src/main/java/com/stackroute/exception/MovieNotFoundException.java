package com.stackroute.exception;

public class MovieNotFoundException extends Exception{
    private String  message;

    public MovieNotFoundException() {
    }

    public MovieNotFoundException(String message) {
        //message will be displayed when exception occurs
        super(message);
        this.message = message;
    }
}
