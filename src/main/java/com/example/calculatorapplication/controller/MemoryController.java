package com.example.calculatorapplication.controller;

import com.example.calculatorapplication.service.memoryservice.MemoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/memory")
@RequiredArgsConstructor
public class MemoryController {
   private final MemoryService memoryService;

    @PostMapping("/add")
    public ResponseEntity<Object> addToMemory(@RequestParam("value") double value) {
        memoryService.addToMemory(value);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/subtract")
    public ResponseEntity<Object> subtractFromMemory(@RequestParam("value") double value) {
        memoryService.subtractFromMemory(value);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/clear")
    public ResponseEntity<Object> clearMemory() {
        memoryService.clearMemory();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/recall")
    public ResponseEntity<Double> recallMemory() {
        double memoryValue = memoryService.recallMemory();
        return ResponseEntity.ok(memoryValue);
    }
}
