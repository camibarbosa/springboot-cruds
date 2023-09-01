package com.restcrudapi.restapidemo.rest;

public class StudentNotFoundException extends RuntimeException{

    //constructs
    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }
}
