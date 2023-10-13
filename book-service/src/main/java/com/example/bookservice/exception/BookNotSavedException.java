package com.example.bookservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BookNotSavedException extends RuntimeException{
    public BookNotSavedException(String message) {
        super(message);
    }
}
