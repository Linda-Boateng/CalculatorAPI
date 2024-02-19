package com.example.calculatorapplication.service.operationservice;

import org.springframework.stereotype.Service;

@Service
public class OperationServiceImpl implements OperationService {
    @Override
    public double add(double operand1, double operand2) {
        return operand1 + operand2;
    }

    @Override
    public double subtract(double operand1, double operand2) {
        return operand1 - operand2;
    }

    @Override
    public double divide(double operand1, double operand2) {
        return operand1 / operand2;
    }

    @Override
    public double multiply(double operand1, double operand2) {
        return operand1 * operand2;
    }
}
