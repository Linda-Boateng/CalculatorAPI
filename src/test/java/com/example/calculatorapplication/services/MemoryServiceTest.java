package com.example.calculatorapplication.services;

import com.example.calculatorapplication.service.memoryservice.MemoryService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class MemoryServiceTest {

    @Autowired
    MemoryService memoryService;

  @Test
  void testAddToMemory() {
        memoryService.addToMemory(5);
        assertEquals(5.0, memoryService.recallMemory());
    }

    @Test
    void testSubtractMemory() {
        memoryService.subtractFromMemory(3);
        assertEquals(2.0, memoryService.recallMemory());
    }

    @Test
  void testClearMemory() {
      memoryService.addToMemory(9);
      memoryService.clearMemory();
        assertEquals(0.0, memoryService.recallMemory());
    }

}
