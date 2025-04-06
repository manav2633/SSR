package com.example.app.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.app.demo.model.ConclusionData;
import com.example.app.demo.model.ConclusionRequest;
import com.example.app.demo.service.ConclusionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/conclusion")
public class ConclusionController {

    @Autowired
    private ConclusionService conclusionService;

    @PostMapping
    public ResponseEntity<String> createConclusionData(@RequestBody ConclusionRequest request) {
        // Check for null request or sections
        if (request == null || request.getSections() == null) {
            throw new IllegalArgumentException("Request or sections cannot be null");
        }

        // Save sections
        List<ConclusionData> sections = request.getSections().stream()
                .map(section -> {
                    ConclusionData data = new ConclusionData();
                    data.setSection(section.getSection());
                    data.setContent(section.getContent());
                    return data;
                })
                .collect(Collectors.toList());
        conclusionService.saveAllConclusionData(sections);

        return ResponseEntity.ok("Data saved successfully!");
    }
}
