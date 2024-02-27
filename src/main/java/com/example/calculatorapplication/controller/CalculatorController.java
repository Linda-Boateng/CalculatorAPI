package com.example.calculatorapplication.controller;

import com.example.calculatorapplication.model.History;
import com.example.calculatorapplication.model.OperationInput;
import com.example.calculatorapplication.service.historyservice.HistoryService;
import com.example.calculatorapplication.service.operationservice.OperationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculates")
@RequiredArgsConstructor
public class CalculatorController {
    private final OperationService calculator;
    private final HistoryService history;


    @PostMapping("/addition")
    public ResponseEntity<?> add(@RequestBody OperationInput request) {
        return new ResponseEntity<>(calculator.add(request.getOperand1(), request.getOperand2()),HttpStatus.OK);
    }

    @PostMapping("/subtraction")
    public ResponseEntity<Double> subtract(@RequestBody OperationInput request) {
        return new ResponseEntity<>(calculator.subtract(request.getOperand1(), request.getOperand2()),HttpStatus.OK);
    }
    @PostMapping("/division")
    public ResponseEntity<Double> divide(@RequestBody OperationInput request) {
        return new ResponseEntity<>(calculator.divide(request.getOperand1(), request.getOperand2()),HttpStatus.OK);
    }

    @PostMapping("/multiplication")
    public ResponseEntity<Double> multiply(@RequestBody OperationInput request) {
        return new ResponseEntity<>(calculator.multiply(request.getOperand1(), request.getOperand2()),HttpStatus.OK);
    }

    @GetMapping("/history")
    public ResponseEntity<List<History>> getHistory() {
        return new ResponseEntity<>(history.getAllHistory(),HttpStatus.OK);
    }
}
