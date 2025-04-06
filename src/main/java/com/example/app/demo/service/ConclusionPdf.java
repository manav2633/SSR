package com.example.app.demo.service;


import com.example.app.demo.model.ConclusionData;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
// import com.naac.model.ConclusionData;
// import com.naac.service.ConclusionService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/pdf")
public class ConclusionPdf {

    @Autowired
    private ConclusionService conclusionService;

    @GetMapping("/conclusion")
    public void generateConclusionPdf(HttpServletResponse response) throws IOException, DocumentException {
        // Set the content type and attachment header
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"Conclusion.pdf\"");

        // Create a new document
        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());

        // Open the document
        document.open();

        // Define fonts for headings and normal text
        Font headingFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 18, Font.BOLD | Font.UNDERLINE);
        Font subHeadingFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 16, Font.BOLD | Font.UNDERLINE);
        Font boldFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.BOLD);
        Font normalFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);

        // Add main heading
        Paragraph mainHeading = new Paragraph("5. CONCLUSION", headingFont);
        mainHeading.setAlignment(Element.ALIGN_CENTER);
        mainHeading.setSpacingAfter(20);
        document.add(mainHeading);

        // Add "Additional Information" heading
        Paragraph additionalInfoHeading = new Paragraph("Additional Information :", subHeadingFont);
        additionalInfoHeading.setSpacingAfter(10);
        document.add(additionalInfoHeading);

        // Fetch dynamic data from the database
        List<com.example.app.demo.model.ConclusionData> conclusionDataList = conclusionService.getAllConclusionData();

        // Add dynamic content to the PDF
        for (ConclusionData data : conclusionDataList) {
            Paragraph sectionHeading = new Paragraph(data.getSection(), boldFont);
            sectionHeading.setSpacingAfter(5);
            document.add(sectionHeading);

            Paragraph sectionContent = new Paragraph(data.getContent(), normalFont);
            sectionContent.setSpacingAfter(10);
            document.add(sectionContent);
        }

        // Add "Concluding Remarks" heading
        Paragraph concludingRemarksHeading = new Paragraph("Concluding Remarks :", subHeadingFont);
        concludingRemarksHeading.setSpacingAfter(10);
        document.add(concludingRemarksHeading);

        // Add static concluding remarks content
        Paragraph concludingRemarksContent = new Paragraph("DA-IICT is a university devoted to Information and Communication (ICT) education and research. Since its inception, the Institute strives hard to provide quality education affordable to its aspirants with the goal of making engineering with social responsibility. The Institute is equipped with the state-of-the-art infrastructure, unique curriculum, vibrant student community, experienced faculty with total autonomy in governance.", normalFont);
        concludingRemarksContent.setSpacingAfter(10);
        document.add(concludingRemarksContent);

        // Close the document
        document.close();
    }
}