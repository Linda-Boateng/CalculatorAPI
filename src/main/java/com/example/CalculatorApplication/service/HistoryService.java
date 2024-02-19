package com.example.CalculatorApplication.service;

import com.example.CalculatorApplication.model.History;
import com.example.CalculatorApplication.model.OperationInput;
import com.example.CalculatorApplication.model.OperationResponse;

import java.util.List;

public interface HistoryService {
    void saveHistory(OperationInput request, OperationResponse response);

    List<History> getAllHistory();
}
