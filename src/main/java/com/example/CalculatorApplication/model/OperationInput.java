package com.example.CalculatorApplication.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class OperationInput {
    private double operand1;
    private double operand2;
    private  String operator;
}
