package com.example.calculatorapplication.service.operationservice;

import com.example.calculatorapplication.exception.InvalidInputException;
import com.example.calculatorapplication.model.History;
import com.example.calculatorapplication.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {
    private final HistoryRepository historyRepository;
    @Override
    public double add(double operand1, double operand2) {
        validateOperands(operand1,operand2);
        double result = operand1 + operand2;
        saveHistory(operand1 + " + " +operand2 +" = " + result);
        return result;
    }

    @Override
    public double subtract(double operand1, double operand2) {
        validateOperands(operand1,operand2);
        double result = operand1 - operand2;
        saveHistory(operand1 + " - " +operand2 +" = " + result);
        return result;
    }

    @Override
    public double divide(double operand1, double operand2) {
        validateOperands(operand1,operand2);
        if (operand2 == 0) {
      throw new InvalidInputException("Cannot divide by zero");
        }
        double result = operand1 / operand2;
        saveHistory(operand1 + " / " +operand2 +" = " + result);
        return result;
    }

    @Override
    public double multiply(double operand1, double operand2) {
        validateOperands(operand1,operand2);
        double result = operand1 * operand2;
        saveHistory(operand1 + " * " +operand2 +" = " + result);
        return result;
    }

    private void validateOperands(double operand1, double operand2) {
        if (Double.isInfinite(operand1) || Double.isInfinite(operand2) || Double.isNaN(operand1) || Double.isNaN(operand2)) {
      throw new InvalidInputException(" Please enter valid numeric values");
        }
    }

    private void saveHistory(String expression) {
        History history = new History();
        history.setExpression(expression);
        historyRepository.save(history);
    }
}
