package com.example.calculatorapplication.controller;

import com.example.calculatorapplication.model.History;
import com.example.calculatorapplication.model.OperationInput;
import com.example.calculatorapplication.service.historyservice.HistoryService;
import com.example.calculatorapplication.service.operationservice.OperationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculate")
@RequiredArgsConstructor
public class CalculatorController {
    private final OperationService calculator;
    private final HistoryService history;


    @PostMapping("/addition")
    public ResponseEntity<Double> add(@RequestBody OperationInput request) {
        //validateInput(request);
        double result = calculator.add(request.getOperand1(), request.getOperand2());
        history.saveCalculation(request.getOperand1(), request.getOperand2(), "add", result);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/subtraction")
    public ResponseEntity<Double> subtract(@RequestBody OperationInput request) {
        //validateInput(request);
        double result = calculator.subtract(request.getOperand1(), request.getOperand2());
        history.saveCalculation(request.getOperand1(), request.getOperand2(), "subtract", result);
        return ResponseEntity.ok(result);
    }
    @PostMapping("/division")
    public ResponseEntity<Double> divide(@RequestBody OperationInput request) {
       // validateInput(request);
        double result = calculator.divide(request.getOperand1(), request.getOperand2());
        history.saveCalculation(request.getOperand1(), request.getOperand2(), "divide", result);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/multiplication")
    public ResponseEntity<Double> multiply(@RequestBody OperationInput request) {
        //validateInput(request);
        double result = calculator.multiply(request.getOperand1(), request.getOperand2());
        history.saveCalculation(request.getOperand1(), request.getOperand2(), "multiply", result);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/history")
    public ResponseEntity<List<History>> getHistory() {
        return ResponseEntity.ok(history.getAllHistory());
    }

    // Validation method
    private void validateInput(OperationInput request) {
        
//        if (request.getOperand1() == 0 && "divide".equals(request.getOperator())) {
//            throw new IllegalArgumentException("Cannot divide by zero.");
//        }
}
}
