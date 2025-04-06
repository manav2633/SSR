package com.example.app.demo.controller;

import com.example.app.demo.model.SelfStudyReport;
import com.example.app.demo.service.PdfGenerationService;
import com.example.app.demo.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import jakarta.servlet.http.HttpServletResponse;
import com.itextpdf.text.DocumentException;

import java.io.IOException;

@RestController
@RequestMapping("/api/ssr")
public class SelfStudyReportController {

    private static final Logger logger = LoggerFactory.getLogger(SelfStudyReportController.class);

    @Autowired
    private PdfGenerationService pdfGenerationService;

    @Autowired
    private StorageService storageService;

    @PostMapping("/generate")
    public void generatePdf(
            @RequestParam("curriculumDesc") String curriculumDesc,
            @RequestParam("revisionPercentage") String revisionPercentage,
            @RequestParam("revisedPrograms") String revisedPrograms,
            @RequestParam("totalPrograms") String totalPrograms,
            @RequestParam("curriculumFile") MultipartFile curriculumFile,
            @RequestParam("supportingDoc") MultipartFile supportingDoc,
            @RequestParam("institutionalData") MultipartFile institutionalData,
            HttpServletResponse response) throws IOException {
        
        try {
            // Validate required fields
            if (curriculumDesc == null || curriculumDesc.trim().isEmpty()) {
                throw new IllegalArgumentException("Curriculum description is required");
            }
            
            // Create report object
            SelfStudyReport report = new SelfStudyReport();
            report.setCurriculumDesc(curriculumDesc);
            report.setRevisionPercentage(revisionPercentage != null ? revisionPercentage : "N/A");
            report.setRevisedPrograms(revisedPrograms != null ? revisedPrograms : "N/A");
            report.setTotalPrograms(totalPrograms != null ? totalPrograms : "N/A");
            
            // Upload files and set paths
            report.setCurriculumFilePath(storageService.uploadFile(curriculumFile));
            report.setSupportingDocPath(storageService.uploadFile(supportingDoc));
            report.setInstitutionalDataPath(storageService.uploadFile(institutionalData));
            
            // Generate PDF
            pdfGenerationService.generatePdf(report, response);
            
        } catch (DocumentException e) {
            logger.error("PDF generation error", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error generating PDF");
        } catch (IllegalArgumentException e) {
            logger.error("Validation error", e);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unexpected error occurred");
        }
    }
}