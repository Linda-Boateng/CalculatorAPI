package com.example.calculatorapplication.exception;

import com.example.calculatorapplication.model.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(value = {IllegalArgumentException.class})
  ResponseEntity<ErrorResponse> handleBadRequest(
      IllegalArgumentException exception, HttpServletRequest httpServletRequest) {
    return new ResponseEntity<>(
        new ErrorResponse(httpServletRequest.getRequestURI(), exception.getMessage()),
        HttpStatus.BAD_REQUEST);
  }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException exception, HttpServletRequest httpServletRequest) {
        return new ResponseEntity<>(
                new ErrorResponse(httpServletRequest.getRequestURI(), "Please enter valid numeric values"),
                HttpStatus.BAD_REQUEST);
    }
}
