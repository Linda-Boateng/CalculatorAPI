package com.example.calculatorapplication.model;

import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ErrorResponse {
    private String path;
    private String message;
    private final OffsetDateTime timeStamp = OffsetDateTime.now();
}
