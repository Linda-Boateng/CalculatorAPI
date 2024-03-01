package com.example.calculatorapplication.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.calculatorapplication.service.operationservice.OperationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class OperationServiceTest {

  @Autowired
  private  OperationService operationService;

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
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      operationService.divide(10, 0);
    });
    assertEquals("Cannot divide by zero", exception.getMessage());
  }
}
