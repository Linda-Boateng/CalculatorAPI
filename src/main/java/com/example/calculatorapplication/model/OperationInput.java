package com.example.calculatorapplication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class OperationInput {
    private double operand1;
    private double operand2;
}
