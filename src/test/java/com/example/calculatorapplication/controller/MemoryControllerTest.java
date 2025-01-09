package com.example.calculatorapplication.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.calculatorapplication.service.memoryservice.MemoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("application-test.properties")

class MemoryControllerTest {
 @Autowired
 private TestRestTemplate restTemplate;

  @Autowired private  MemoryService memoryService;

  @BeforeEach
  public void setUp() {
    memoryService.clearMemory();
  }

  @Test
  void testAddToMemory() {

    ResponseEntity<Void> response =
        restTemplate.postForEntity("/api/v1/calculator/add?value=5.0", null, Void.class);

    assertEquals(HttpStatus.OK, response.getStatusCode());

    double memoryValue = memoryService.recallMemory();
    assertEquals(5.0, memoryValue);
  }

    @Test
    void testSubtractFromMemory() {
        memoryService.addToMemory(10.0);


        ResponseEntity<Void> response = restTemplate.postForEntity("/api/v1/calculator/subtract?value=3.0", null, Void.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        double memoryValue = memoryService.recallMemory();
        assertEquals(7.0, memoryValue);
    }

  @Test
  void testClearMemory() {

        memoryService.addToMemory(10.0);

        ResponseEntity<Void> response = restTemplate.postForEntity("/api/v1/calculator/clear", null, Void.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        double memoryValue = memoryService.recallMemory();
        assertEquals(0.0, memoryValue);
    }

  @Test
  void testRecallMemory() {
        memoryService.addToMemory(42.0);

        ResponseEntity<Double> response = restTemplate.getForEntity("/api/v1/calculator/recall", Double.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(42.0, response.getBody());
    }

    @Test
    void testRecallMemoryWhenMemoryIsEmpty() {
        ResponseEntity<Double> response = restTemplate.getForEntity("/api/v1/calculator/recall", Double.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(0.0, response.getBody());
    }
}
