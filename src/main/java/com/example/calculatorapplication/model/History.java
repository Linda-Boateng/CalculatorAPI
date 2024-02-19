package com.example.calculatorapplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "history")
@Getter
@Setter
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "OPERAND1")
    private double operand1;

    @Column(name = "OPERAND2")
    private double operand2;

    @Column(name = "OPERATOR")
    private String operator;

    @Column(name = "RESULT")
    private double result;

    @Column(name = "OPERATION")
    private String operationType;

    @Column(name = "TIMESTAMP")
    private LocalDateTime timestamp;

}
