package com.example.calculatorapplication.service.historyservice;

import com.example.calculatorapplication.model.History;
import com.example.calculatorapplication.model.OperationInput;
import com.example.calculatorapplication.model.OperationResponse;
import com.example.calculatorapplication.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;

    @Override
    public void saveCalculation(double operand1, double operand2, String operator, double result) {
        History history = new History();
        history.setOperand1(operand1);
        history.setOperand2(operand2);
        history.setOperator(operator);
        history.setResult(result);
        history.setTimestamp(LocalDateTime.now());

        historyRepository.save(history);
    }

    public List<History> getAllHistory() {
        return historyRepository.findAll();
    }
}
