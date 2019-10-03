package com.stackroute.controller;

import com.stackroute.domain.Movie;
import com.stackroute.exception.MovieNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> conflict(Exception e)
    {
       ResponseEntity responseEntity=new ResponseEntity<String>("Global exception: "+e.getMessage(), HttpStatus.CONFLICT);
        return  responseEntity;
    }
}
