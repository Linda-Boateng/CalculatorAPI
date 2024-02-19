package com.example.CalculatorApplication.repository;

import com.example.CalculatorApplication.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History,Integer> {

}
