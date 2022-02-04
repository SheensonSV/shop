package com.someshop.controllers;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<BadRequest> noSuchElementException() {
        return new ResponseEntity<>(new BadRequest(), HttpStatus.NOT_FOUND);
    }

    @Data
    public class BadRequest {
        private String name = "bad #id";
    }
}
