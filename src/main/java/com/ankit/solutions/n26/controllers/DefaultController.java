package com.ankit.solutions.n26.controllers;

import static org.springframework.http.HttpStatus.NO_CONTENT;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ankit.solutions.n26.exceptions.InvalidTimestampException;


@ControllerAdvice
public class DefaultController {

    @ResponseStatus(NO_CONTENT)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public void handleMethodArgumentNotValidException() {
    }

    @ResponseStatus(NO_CONTENT)
    @ExceptionHandler(InvalidTimestampException.class)
    public void handleInvalidTimestampException() {
    }
}


