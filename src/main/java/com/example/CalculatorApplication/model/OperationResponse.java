package com.example.CalculatorApplication.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
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
