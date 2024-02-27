package com.example.calculatorapplication.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.example.calculatorapplication.repository.HistoryRepository;
import com.example.calculatorapplication.service.historyservice.HistoryService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class HistoryServiceTest {

  @Autowired
  HistoryService historyService;
  @MockBean
  private HistoryRepository historyRepository;

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
