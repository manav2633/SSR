package com.example.app.demo.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.example.app.demo.model.SelfStudyReport;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Service
public class PdfGenerationService {

    private static final Logger logger = LoggerFactory.getLogger(PdfGenerationService.class);

    public void generatePdf(SelfStudyReport report, HttpServletResponse response) throws DocumentException, IOException {
        // Set response type and headers
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=SelfStudyReport.pdf");

        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
        
        try {
            document.open();
            
            // Enable PDF compression
            writer.setCompressionLevel(9);
            
            // Font definitions
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.DARK_GRAY);
            Font headingFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK);
            Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
            Font linkFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.UNDERLINE, BaseColor.BLUE);

            // Add title
            Paragraph title = new Paragraph("Self Study Report - Curricular Aspects", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(20);
            document.add(title);

            // Add curriculum section
            addCurriculumSection(document, report, headingFont, normalFont);
            
            // Add file links section with clickable links
            addFileLinksSection(document, writer, report, headingFont, normalFont, linkFont);
            
            // Add syllabus revision section
            addSyllabusRevisionSection(document, report, headingFont, normalFont);

        } finally {
            if (document.isOpen()) {
                document.close();
            }
        }
    }

    private void addCurriculumSection(Document document, SelfStudyReport report, Font headingFont, Font normalFont) 
            throws DocumentException {
        Paragraph sectionHeading = new Paragraph("1.1 Curriculum Design and Development", headingFont);
        sectionHeading.setSpacingAfter(10);
        document.add(sectionHeading);

        Paragraph content = new Paragraph(report.getCurriculumDesc(), normalFont);
        content.setSpacingAfter(20);
        document.add(content);
    }

    private void addFileLinksSection(Document document, PdfWriter writer, SelfStudyReport report, 
                                   Font headingFont, Font normalFont, Font linkFont) 
            throws DocumentException {
        Paragraph sectionHeading = new Paragraph("1.2 Supporting Documents", headingFont);
        sectionHeading.setSpacingAfter(10);
        document.add(sectionHeading);

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10);
        table.setSpacingAfter(20);
        
        // Table headers
        table.addCell(createCell("Document Type", headingFont));
        table.addCell(createCell("File Link", headingFont));
        
        // Add clickable file links
        addClickableFileLinkRow(table, writer, "Curriculum File", report.getCurriculumFilePath(), normalFont, linkFont);
        addClickableFileLinkRow(table, writer, "Supporting Document", report.getSupportingDocPath(), normalFont, linkFont);
        addClickableFileLinkRow(table, writer, "Institutional Data", report.getInstitutionalDataPath(), normalFont, linkFont);
        
        document.add(table);
    }

    private void addClickableFileLinkRow(PdfPTable table, PdfWriter writer, String label, 
                                       String url, Font labelFont, Font linkFont) {
        // Add document type cell
        table.addCell(createCell(label, labelFont));
        
        // Create cell for clickable link
        PdfPCell cell = new PdfPCell();
        cell.setPadding(5);
        
        if (url != null && !url.isEmpty()) {
            try {
                // Create clickable annotation
                PdfAction action = new PdfAction(new URI(url).toURL());
                Chunk chunk = new Chunk("View Document", linkFont);
                chunk.setAction(action);
                
                // Add to cell
                cell.addElement(new Paragraph(chunk));
            } catch (URISyntaxException | IOException e) {
                logger.error("Error creating clickable link for URL: " + url, e);
                cell.addElement(new Paragraph("View Document (invalid URL)", linkFont));
            }
        } else {
            cell.addElement(new Paragraph("No document available", labelFont));
        }
        
        table.addCell(cell);
    }

    private void addSyllabusRevisionSection(Document document, SelfStudyReport report, 
                                          Font headingFont, Font normalFont) 
            throws DocumentException {
        Paragraph sectionHeading = new Paragraph("1.3 Syllabus Revision Statistics", headingFont);
        sectionHeading.setSpacingAfter(10);
        document.add(sectionHeading);

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(60);
        table.setSpacingBefore(10);
        table.setSpacingAfter(20);
        
        addStatRow(table, "Revision Percentage:", report.getRevisionPercentage(), normalFont);
        addStatRow(table, "Revised Programs:", report.getRevisedPrograms(), normalFont);
        addStatRow(table, "Total Programs:", report.getTotalPrograms(), normalFont);
        
        document.add(table);
    }

    private PdfPCell createCell(String text, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setPadding(5);
        return cell;
    }

    private void addStatRow(PdfPTable table, String label, String value, Font font) {
        table.addCell(createCell(label, font));
        table.addCell(createCell(value != null ? value : "N/A", font));
    }
}