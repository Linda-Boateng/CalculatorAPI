package com.example.calculatorapplication.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class OperationResponse {
    private double result;
    private String operationType;
    private LocalDateTime timestamp;
}
