package com.example.app.demo.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/pdf")
public class AnnexureController {

    @GetMapping("/annexure")
    public ResponseEntity<byte[]> generatePdf() throws IOException, DocumentException {
        // Create a new PDF document
        Document document = new Document();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, byteArrayOutputStream);

        // Open the document
        document.open();

        // Set font and font size
        Font titleFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
        Font sectionFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        Font contentFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);

        // Add title
        Paragraph title = new Paragraph("6. ANNEXURE", titleFont);
        title.setSpacingAfter(20);
        document.add(title);

        // Add Metrics Level Deviations section
        Paragraph section = new Paragraph("1. Metrics Level Deviations", sectionFont);
        section.setSpacingAfter(10);
        document.add(section);

        // Add table for Metric ID 1.2.2
        PdfPTable table1 = new PdfPTable(1);
        table1.setWidthPercentage(100);
        table1.setSpacingBefore(10);
        table1.setSpacingAfter(10);

        addCell(table1, "Metric ID | Sub Questions and Answers before and after DVV Verification", contentFont);
        addCell(table1, "1.2.2 | Percentage of Programmes in which Choice Based Credit System (CBCS) / elective course system has been implemented", contentFont);
        addCell(table1, "Answer before DVV Verification : 9", contentFont);
        addCell(table1, "Answer after DVV Verification: 8", contentFont);
        addCell(table1, "Remark: Input edited as per supporting documents", contentFont);

        document.add(table1);

        // Add table for Metric ID 1.3.4
        PdfPTable table2 = new PdfPTable(1);
        table2.setWidthPercentage(100);
        table2.setSpacingBefore(10);
        table2.setSpacingAfter(10);

        addCell(table2, "1.3.4 | Percentage of students undertaking field projects / research projects / internships", contentFont);
        addCell(table2, "Answer before DVV Verification : 1386", contentFont);
        addCell(table2, "Answer after DVV Verification: 1050", contentFont);
        addCell(table2, "Remark: Input edited as per supporting documents", contentFont);

        document.add(table2);

        // Add table for Metric ID 2.1.1
        PdfPTable table3 = new PdfPTable(1);
        table3.setWidthPercentage(100);
        table3.setSpacingBefore(10);
        table3.setSpacingAfter(10);

        addCell(table3, "2.1.1 | Demand Ratio (Average of last five years)", contentFont);
        addCell(table3, "Answer before DVV Verification:", contentFont);
        addCell(table3, "2021-22: 760, 2020-21: 692, 2019-20: 602, 2018-19: 570, 2017-18: 554", contentFont);
        addCell(table3, "Answer after DVV Verification:", contentFont);
        addCell(table3, "2021-22: 740, 2020-21: 672, 2019-20: 582, 2018-19: 550, 2017-18: 534", contentFont);
        addCell(table3, "Remark: Input edited Excluding Ph. D. intake", contentFont);

        document.add(table3);

        // Add table for Metric ID 2.1.2
        PdfPTable table4 = new PdfPTable(1);
        table4.setWidthPercentage(100);
        table4.setSpacingBefore(10);
        table4.setSpacingAfter(10);

        addCell(table4, "2.1.2 | Average percentage of seats filled against reserved categories (SC, ST, OBC, Divyangjan, etc.)", contentFont);
        addCell(table4, "Answer before DVV Verification:", contentFont);
        addCell(table4, "2021-22: 132, 2020-21: 120, 2019-20: 123, 2018-19: 100, 2017-18: 97", contentFont);
        addCell(table4, "Answer after DVV Verification:", contentFont);
        addCell(table4, "2021-22: 125, 2020-21: 110, 2019-20: 123, 2018-19: 100, 2017-18: 97", contentFont);
        addCell(table4, "Remark: Input edited as Filled seats cannot exceed the earmarked ones", contentFont);

        document.add(table4);

        // Add table for Metric ID 2.4.3
        PdfPTable table5 = new PdfPTable(1);
        table5.setWidthPercentage(100);
        table5.setSpacingBefore(10);
        table5.setSpacingAfter(10);

        addCell(table5, "2.4.3 | Average teaching experience of full-time teachers in the same institution", contentFont);
        addCell(table5, "Answer before DVV Verification: 611", contentFont);
        addCell(table5, "Answer after DVV Verification: 599", contentFont);
        addCell(table5, "Remark: Input edited as per supporting documents", contentFont);

        document.add(table5);

        // Add table for Metric ID 2.4.4
        PdfPTable table6 = new PdfPTable(1);
        table6.setWidthPercentage(100);
        table6.setSpacingBefore(10);
        table6.setSpacingAfter(10);

        addCell(table6, "2.4.4 | Average percentage of full-time teachers who received awards, recognition, fellowships", contentFont);
        addCell(table6, "Answer before DVV Verification:", contentFont);
        addCell(table6, "2021-22: 11, 2020-21: 7, 2019-20: 7, 2018-19: 4, 2017-18: 3", contentFont);
        addCell(table6, "Answer after DVV Verification:", contentFont);
        addCell(table6, "2021-22: 4, 2020-21: 4, 2019-20: 4, 2018-19: 4, 2017-18: 3", contentFont);
        addCell(table6, "Remark: Input edited as Best paper present / poster cannot be considered as an award", contentFont);

        document.add(table6);

        // Add table for Metric ID 3.3.3
        PdfPTable table7 = new PdfPTable(1);
        table7.setWidthPercentage(100);
        table7.setSpacingBefore(10);
        table7.setSpacingAfter(10);

        addCell(table7, "3.3.3 | Number of awards / recognitions received for research/innovations", contentFont);
        addCell(table7, "Answer before DVV Verification:", contentFont);
        addCell(table7, "2021-22: 7, 2020-21: 3, 2019-20: 3, 2018-19: 6, 2017-18: 6", contentFont);
        addCell(table7, "Answer after DVV Verification:", contentFont);
        addCell(table7, "2021-22: 7, 2020-21: 2, 2019-20: 4, 2018-19: 7, 2017-18: 6", contentFont);
        addCell(table7, "Remark: Input edited as per supporting documents", contentFont);

        document.add(table7);

        // Add table for Metric ID 3.4.6
        PdfPTable table8 = new PdfPTable(1);
        table8.setWidthPercentage(100);
        table8.setSpacingBefore(10);
        table8.setSpacingAfter(10);

        addCell(table8, "3.4.6 | Number of books and chapters in edited volumes/books published and papers published", contentFont);
        addCell(table8, "Answer before DVV Verification:", contentFont);
        addCell(table8, "2021-22: 126, 2020-21: 129, 2019-20: 100, 2018-19: 114, 2017-18: 114", contentFont);
        addCell(table8, "Answer after DVV Verification:", contentFont);
        addCell(table8, "2021-22: 114, 2020-21: 125, 2019-20: 98, 2018-19: 113, 2017-18: 113", contentFont);
        addCell(table8, "Remark: Input edited as Calendar year publication to be considered (Jan to Dec)", contentFont);

        document.add(table8);

        // Add table for Metric ID 3.6.2
        PdfPTable table9 = new PdfPTable(1);
        table9.setWidthPercentage(100);
        table9.setSpacingBefore(10);
        table9.setSpacingAfter(10);

        addCell(table9, "3.6.2 | Number of awards received by the Institution, its teachers and students", contentFont);
        addCell(table9, "Answer before DVV Verification:", contentFont);
        addCell(table9, "2021-22: 2, 2020-21: 3, 2019-20: 2, 2018-19: 2, 2017-18: 2", contentFont);
        addCell(table9, "Answer after DVV Verification:", contentFont);
        addCell(table9, "2021-22: 0, 2020-21: 0, 2019-20: 0, 2018-19: 0, 2017-18: 0", contentFont);
        addCell(table9, "Remark: Input edited as Letter of appreciation / local awards cannot be considered", contentFont);

        document.add(table9);

        // Close the document
        document.close();

        // Set the response headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "annexure.pdf");

        // Return the PDF as a response
        return ResponseEntity.ok()
                .headers(headers)
                .body(byteArrayOutputStream.toByteArray());
    }

    private void addCell(PdfPTable table, String text, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setBorder(Rectangle.BOX);
        cell.setPadding(5);
        table.addCell(cell);
    }
}