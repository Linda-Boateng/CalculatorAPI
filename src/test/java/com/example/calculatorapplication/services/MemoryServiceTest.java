package com.example.calculatorapplication.services;

import com.example.calculatorapplication.service.memoryservice.MemoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class MemoryServiceTest {

    @InjectMocks
    MemoryServiceImpl memoryService;

//    @BeforeEach void setUp() {
//        memoryService = new MemoryServiceImpl();
//    }
  @Test
  void testAddToMemory() {
        memoryService.addToMemory(5);
        assertEquals(5.0, memoryService.recallMemory());
    }

    @Test
    void testSubtractMemory() {
        memoryService.subtractFromMemory(3);
        assertEquals(-3, memoryService.recallMemory());
    }

    @Test
  void testClearMemory() {
      memoryService.addToMemory(9);
      memoryService.clearMemory();
        assertEquals(0.0, memoryService.recallMemory());
    }

}
