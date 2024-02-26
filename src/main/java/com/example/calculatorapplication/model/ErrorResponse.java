package com.example.calculatorapplication.model;

import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponse {
    private String path;
    private String message;
    private final OffsetDateTime timeStamp = OffsetDateTime.now();
}
