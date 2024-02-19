package com.example.calculatorapplication.service.historyservice;

import com.example.calculatorapplication.model.History;
import com.example.calculatorapplication.model.OperationInput;
import com.example.calculatorapplication.model.OperationResponse;

import java.util.List;

public interface HistoryService {
    void saveHistory(OperationInput request, OperationResponse response);

    List<History> getAllHistory();
}
