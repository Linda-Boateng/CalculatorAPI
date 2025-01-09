package com.example.calculatorapplication.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.calculatorapplication.repository.HistoryRepository;
import com.example.calculatorapplication.service.operationservice.OperationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OperationServiceTest {

  @InjectMocks
  OperationServiceImpl operationService;
  @Mock
  HistoryRepository historyRepository;

  @BeforeEach void setUp() {
    operationService = new OperationServiceImpl( historyRepository);
  }
    @Test
  void testAddition() {
    double result = operationService.add(2, 3);
    assertEquals(5.0, result);
  }

  @Test
  void testSubtraction() {
    double result = operationService.subtract(5, 3);
    assertEquals(2.0, result);
  }

  @Test
  void testMultiplication() {
    double result = operationService.multiply(2, 3);
    assertEquals(6.0, result);
  }

  @Test
  void testDivision() {
    double result = operationService.divide(6, 2);
    assertEquals(3.0, result);
  }

  @Test
  void testInvalidDivisionByZero() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> operationService.divide(10, 0));
    assertEquals("Cannot divide by zero", exception.getMessage());
  }
}
