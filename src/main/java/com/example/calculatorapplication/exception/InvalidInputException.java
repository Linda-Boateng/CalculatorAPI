package com.example.calculatorapplication.exception;

public class InvalidInputException extends RuntimeException{
    public InvalidInputException(String message){
        super(message);
    }
}
