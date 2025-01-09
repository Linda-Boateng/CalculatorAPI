package com.example.calculatorapplication.controller;

import com.example.calculatorapplication.model.ErrorResponse;
import com.example.calculatorapplication.service.memoryservice.MemoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
@RequiredArgsConstructor
@Tag(name = "Memory Operations")
public class MemoryController {
   private final MemoryService memoryService;

    /*
     The endpoint for saving value to memory
      */
    @Operation(
            responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            responseCode = "200",
                            description = "Added to memory successfully"),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)),
                            responseCode = "400",
                            description = "Invalid input"),
            },
            summary = "Adds to Memory",
            description = "Add current value to memory.")
    @PostMapping("/add")
    public ResponseEntity<Double> addToMemory(@RequestParam("value") double value) {
        memoryService.addToMemory(value);
        return ResponseEntity.ok().build();
    }

    /*
     The endpoint for subtracting from memory
      */
    @Operation(
            responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            responseCode = "200",
                            description = "Subtracted from memory successfully"),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)),
                            responseCode = "400",
                            description = "Invalid input"),
            },
            summary = "Subtract from Memory",
            description = "Subtract current value from memory.")
    @PostMapping("/subtract")
    public ResponseEntity<Object> subtractFromMemory(@RequestParam("value") double value) {
        memoryService.subtractFromMemory(value);
        return ResponseEntity.ok().build();
    }

    /*
     The endpoint for clearing memory
      */
    @Operation(
            responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            responseCode = "200",
                            description = "Cleared memory successfully"),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)),
                            responseCode = "400",
                            description = "Something went wrong."),
            },
            summary = "Clear Memory",
            description = "Clears memory value.")
    @PostMapping("/clear")
    public ResponseEntity<Object> clearMemory() {
        memoryService.clearMemory();
        return ResponseEntity.ok().build();
    }

    /*
     The endpoint for displaying value from memory
      */
    @Operation(
            responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            responseCode = "200",
                            description = "Recall successfully"),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)),
                            responseCode = "400",
                            description = "Something went wrong."),
            },
            summary = "Recall Memory",
            description = "Displays or get value in memory.")
    @GetMapping("/recall")
    public ResponseEntity<Double> recallMemory() {
        double memoryValue = memoryService.recallMemory();
        return ResponseEntity.ok(memoryValue);
    }
}
