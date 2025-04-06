package com.example.app.demo.repository;


// import com.example.app.model.MetricDeviation;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.demo.model.MetricDeviation;

public interface MetricDeviationRepository extends JpaRepository<MetricDeviation, String> {
}
