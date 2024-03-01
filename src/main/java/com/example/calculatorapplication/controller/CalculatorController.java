package com.example.calculatorapplication.controller;

import com.example.calculatorapplication.model.ErrorResponse;
import com.example.calculatorapplication.model.History;
import com.example.calculatorapplication.model.OperationInput;
import com.example.calculatorapplication.service.historyservice.HistoryService;
import com.example.calculatorapplication.service.operationservice.OperationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
Controller class for handling arithmetic operations
 */
@RestController
@RequestMapping("/api/calculates")
@RequiredArgsConstructor
@Tag(name = "Calculator Operations")
public class CalculatorController {
    private final OperationService calculator;
    private final HistoryService history;

    /*
    The endpoint for performing additions
     */
    @Operation(
            responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            responseCode = "200",
                            description = "Operation done successfully"),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)),
                            responseCode = "400",
                            description = "Invalid input"),
            },
            summary = "Addition Operation",
            description = "Performs addition operation.")
    @PostMapping("/addition")
    public ResponseEntity<Double> add(@RequestBody OperationInput request) {
        return new ResponseEntity<>(calculator.add(request.getOperand1(), request.getOperand2()),HttpStatus.OK);
    }

    /*
    The endpoint for performing subtractions
     */
    @Operation(
            responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            responseCode = "200",
                            description = "Operation done successfully"),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)),
                            responseCode = "400",
                            description = "Invalid input"),
            },
            summary = "Subtraction Operation",
            description = "Performs subtraction operation.")
    @PostMapping("/subtraction")
    public ResponseEntity<Double> subtract(@RequestBody OperationInput request) {
        return new ResponseEntity<>(calculator.subtract(request.getOperand1(), request.getOperand2()),HttpStatus.OK);
    }

    /*
    The endpoint for performing division
     */
    @Operation(
            responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            responseCode = "200",
                            description = "Operation done successfully"),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)),
                            responseCode = "400",
                            description = "Invalid input"),
            },
            summary = "Division Operation",
            description = "Performs division operation.")
    @PostMapping("/division")
    public ResponseEntity<Double> divide(@RequestBody OperationInput request) {
        return new ResponseEntity<>(calculator.divide(request.getOperand1(), request.getOperand2()),HttpStatus.OK);
    }

    /*
    The endpoint for performing multiplication
     */
    @Operation(
            responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            responseCode = "200",
                            description = "Operation done successfully"),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)),
                            responseCode = "400",
                            description = "Invalid input"),
            },
            summary = "Multiplication Operation",
            description = "Performs multiplication operation.")
    @PostMapping("/multiplication")
    public ResponseEntity<Double> multiply(@RequestBody OperationInput request) {
        return new ResponseEntity<>(calculator.multiply(request.getOperand1(), request.getOperand2()),HttpStatus.OK);
    }

    /*
    The endpoint for saving operations to database
     */
    @Operation(
            responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            responseCode = "200",
                            description = "Operation saved to database successfully"),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)),
                            responseCode = "400",
                            description = "Bad Request"),
            },
            summary = "History",
            description = "Saves operation history to database.")
    @GetMapping("/history")
    public ResponseEntity<List<History>> getHistory() {
        return new ResponseEntity<>(history.getAllHistory(),HttpStatus.OK);
    }

    /*
    The endpoint for deleting saved operations from database
     */
    @Operation(
            responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            responseCode = "204",
                            description = "History deleted successfully"),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)),
                            responseCode = "400",
                            description = "Delete Operation failed"),
            },
            summary = "Delete History",
            description = "Deletes save history from database.")
    @DeleteMapping("/reset")
    public  ResponseEntity<Object> resetHistory(){
        history.reset();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
