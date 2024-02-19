package com.example.calculatorapplication.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class OperationInput {
    private double operand1;
    private double operand2;
    private  String operator;

}
