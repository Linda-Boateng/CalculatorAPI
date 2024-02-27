package com.example.calculatorapplication.service.memoryservice;

import java.util.ArrayList;

public interface MemoryService {
    void addToMemory(double value);
    void subtractFromMemory(double value);
    void clearMemory();
    double recallMemory();
}
