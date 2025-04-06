package com.example.app.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.demo.model.ConclusionData;
import com.example.app.demo.repository.ConclusionRepository;

import java.util.List;

@Service
public class ConclusionService {

    @Autowired
    private ConclusionRepository conclusionRepository;

    public void saveAllConclusionData(List<ConclusionData> conclusionDataList) {
        conclusionRepository.saveAll(conclusionDataList);
    }

    public List<ConclusionData> getAllConclusionData() {
        return conclusionRepository.findAll();
    }
}