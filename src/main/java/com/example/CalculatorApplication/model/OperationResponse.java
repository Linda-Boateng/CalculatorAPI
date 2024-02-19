package com.example.CalculatorApplication.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class OperationResponse {
    private double result;
    private String operationType;
    private LocalDateTime timestamp;
}
