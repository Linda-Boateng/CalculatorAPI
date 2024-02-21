package com.example.calculatorapplication.service.historyservice;

import com.example.calculatorapplication.model.History;
import com.example.calculatorapplication.repository.HistoryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;

    @Override
    public List<History> getAllHistory() {
        return historyRepository.findAll();
    }

}
