package com.example.calculatorapplication.service.memoryservice;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MemoryServiceImpl implements  MemoryService {
    private double memory = 0.0;
    @Override
    public void addToMemory(double value) {
        memory += value;
    }

    @Override
    public void subtractFromMemory(double value) {
        memory -= value;
    }

    @Override
    public void clearMemory() {
        memory = 0.0;
    }

    @Override
    public double recallMemory() {
        return memory;
    }
}
