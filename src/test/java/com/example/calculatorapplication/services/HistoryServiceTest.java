package com.example.calculatorapplication.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.example.calculatorapplication.repository.HistoryRepository;
import com.example.calculatorapplication.service.historyservice.HistoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class HistoryServiceTest {

  @InjectMocks
  HistoryServiceImpl historyService;
  @Mock
  private HistoryRepository historyRepository;

  @BeforeEach
  void setUp() {
    historyService = new HistoryServiceImpl(historyRepository);
  }

    @Test
    void testGetAllHistory() {
        historyService.getAllHistory();
        verify(historyRepository, times(1)).findAll();
    }
  @Test
  void testClearAllHistory() {
    historyService.reset();
    verify(historyRepository, times(1)).deleteAll();
  }
}
