package com.example.calculatorapplication.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.calculatorapplication.model.OperationInput;
import com.example.calculatorapplication.service.historyservice.HistoryService;
import com.example.calculatorapplication.service.operationservice.OperationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("application-test.properties")
class CalculatorControllerTest {
  @Autowired private TestRestTemplate restTemplate;
  @Autowired private OperationService calculator;
  @Autowired private HistoryService history;

  @LocalServerPort
  private int port;
  private String baseUrl;

  @BeforeEach
  public void setUp() {
    baseUrl = "http://localhost:" + port + "/api/v1/calculator";
  }

  @Test
  void testAddition() {
    OperationInput input = new OperationInput(5.0, 3.0);
    ResponseEntity<Double> response =
        restTemplate.postForEntity(baseUrl + "/addition", input, Double.class);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(8.0, response.getBody());
  }

  @Test
  void testSubtraction() {
    OperationInput input = new OperationInput(10.0, 3.0);
    ResponseEntity<Double> response = restTemplate.postForEntity(baseUrl + "/subtraction", input, Double.class);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(7.0, response.getBody());
  }

    @Test
    void testMultiplication() {
        OperationInput input = new OperationInput(5.0, 3.0);
        ResponseEntity<Double> response = restTemplate.postForEntity(baseUrl + "/multiplication", input, Double.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(15.0, response.getBody());
    }

    @Test
    void testDivision() {
        OperationInput input = new OperationInput(10.0, 2.0);
        ResponseEntity<Double> response = restTemplate.postForEntity(baseUrl + "/division", input, Double.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(5.0, response.getBody());
    }

    @Test
    void testDivisionByZero() {
        OperationInput input = new OperationInput(10.0, 0.0);
        ResponseEntity<Exception> response = restTemplate.postForEntity(baseUrl + "/division", input, Exception.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

//  @Test
//  void testGetHistory() {
//    String [] expected = {"5.0 + 3.0 = 8.0", "10.0 - 3.0 = 7.0"};
//    restTemplate.postForEntity(baseUrl + "/addition", new OperationInput(5.0, 3.0), Double.class);
//    restTemplate.postForEntity(baseUrl + "/subtraction", new OperationInput(10.0, 3.0), Double.class);
//
//    ResponseEntity<String> response = restTemplate.getForEntity(baseUrl + "/history", String.class);
//
//    assertEquals(HttpStatus.OK, response.getStatusCode());
//    System.out.println(response.getBody());
//    assertEquals(Arrays.toString(expected), response.getBody());
//  }
}
