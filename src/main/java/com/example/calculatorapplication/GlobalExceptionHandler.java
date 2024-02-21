package com.example.calculatorapplication;

import com.example.calculatorapplication.exception.InvalidInputException;
import com.example.calculatorapplication.model.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {InvalidInputException.class})
    ResponseEntity<ErrorResponse> handleBadRequest(
            InvalidInputException exception, HttpServletRequest httpServletRequest) {
        return new ResponseEntity<>(
                new ErrorResponse(httpServletRequest.getRequestURI(), exception.getMessage()),
                HttpStatus.BAD_REQUEST);
    }
}
