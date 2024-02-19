package com.example.calculatorapplication.service.historyservice;

import com.example.calculatorapplication.model.History;
import com.example.calculatorapplication.model.OperationInput;
import com.example.calculatorapplication.model.OperationResponse;
import com.example.calculatorapplication.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;

    @Override
    public void saveHistory(OperationInput request, OperationResponse response) {
        History history = new History();
        history.setOperand1(request.getOperand1());
        history.setOperand2(request.getOperand2());
        history.setOperator(request.getOperator());
        history.setResult(response.getResult());
        history.setOperationType(response.getOperationType());
        history.setTimestamp(response.getTimestamp());

        historyRepository.save(history);
    }

    public List<History> getAllHistory() {
        return historyRepository.findAll();
    }
}
