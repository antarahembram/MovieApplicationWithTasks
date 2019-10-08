package com.stackroute.exception;

//used in case of movie is not there
public class MovieNotFoundException extends Exception{
    private String  message;

    public MovieNotFoundException() {
    }

    public MovieNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
