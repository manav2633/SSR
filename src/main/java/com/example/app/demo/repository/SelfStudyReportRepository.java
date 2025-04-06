package com.example.app.demo.repository;

import com.example.app.demo.model.SelfStudyReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SelfStudyReportRepository extends JpaRepository<SelfStudyReport, Long> {
    // Additional query methods can be added if needed
}
