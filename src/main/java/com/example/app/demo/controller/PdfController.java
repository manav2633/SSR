package com.example.app.demo.controller;


import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.demo.model.MetricDeviation;
import com.example.app.demo.repository.MetricDeviationRepository;
import com.example.app.demo.service.AnnexureService;
import com.example.app.demo.service.PdfService;

@RestController
@RequestMapping("/api/pdf")
public class PdfController {

    @Autowired
    private PdfService pdfService;
    @Autowired
    private AnnexureService pdfGenerationService;
    @Autowired
    private MetricDeviationRepository repository;

    @PostMapping("/upload")
    public String uploadData(@RequestBody List<MetricDeviation> deviations) {
        repository.saveAll(deviations);
        return "Data saved successfully";
    }

    @GetMapping("/annexure")
    public ResponseEntity<InputStreamResource> generateAnnexure() {
        ByteArrayInputStream bis = pdfGenerationService.generatePdf();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @GetMapping("/generate")
    public ResponseEntity<byte[]> generatePdf() {
        byte[] pdfBytes = pdfService.generatePdf();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "NAAC_SSR.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfBytes);
    }
}
