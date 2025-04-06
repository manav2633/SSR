package com.example.app.demo.service;


import com.example.app.demo.model.Question;
import com.example.app.demo.repository.QuestionRepository;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
// import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.properties.TextAlignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PdfService {

    @Autowired
    private QuestionRepository questionRepository;

    public byte[] generatePdf() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfDocument pdf = new PdfDocument(new PdfWriter(out));
        Document document = new Document(pdf);

        // Add Title
        document.add(new Paragraph("Self Study Report of DHIRUBHAI AMBANI INSTITUTE OF INFORMATION AND COMMUNICATION TECHNOLOGY (DA-IICT)")
                .setBold()
                .setFontSize(14)
                .setTextAlignment(TextAlignment.CENTER));

        // Fetch Questions and Responses
        List<Question> questions = questionRepository.findAll();

        // Add Questions and Responses to PDF
        for (Question question : questions) {
            document.add(new Paragraph(question.getSection()).setBold());
            document.add(new Paragraph(question.getQuestionText()).setBold());
            document.add(new Paragraph(question.getResponse()));
            if (question.getDocumentUrl() != null) {
                document.add(new Paragraph("Document: " + question.getDocumentUrl()));
            }
            document.add(new Paragraph("\n")); // Add spacing
        }

        document.close();
        return out.toByteArray();
    }
}