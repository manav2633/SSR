package com.example.app.demo.service;



import com.example.app.demo.model.MetricDeviation;
import com.example.app.demo.repository.MetricDeviationRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class AnnexureService {

    @Autowired
    private MetricDeviationRepository repository;

    public ByteArrayInputStream generatePdf() {
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // Set font similar to the original document
            Font titleFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 12);
            Font normalFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);
            Font boldFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 10);

            // Add title
            Paragraph title = new Paragraph(
                "Self Study Report of DHIRUBHAI AMBANI INSTITUTE OF INFORMATION AND COMMUNICATION TECHNOLOGY (DA-IICT)",
                titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph(" "));
            document.add(new Paragraph("6.ANNEXURE", boldFont));
            document.add(new Paragraph("1.Metrics Level Deviations", boldFont));
            document.add(new Paragraph(" "));

            // Create table
            PdfPTable table = new PdfPTable(1);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);

            List<MetricDeviation> deviations = repository.findAll();
            for (MetricDeviation deviation : deviations) {
                PdfPCell cell = new PdfPCell();
                cell.setBorder(Rectangle.BOX);
                cell.setPadding(5);

                // Metric ID
                cell.addElement(new Paragraph(deviation.getMetricId(), boldFont));
                // Description
                cell.addElement(new Paragraph(deviation.getDescription(), normalFont));
                // Sub Question
                cell.addElement(new Paragraph(deviation.getSubQuestion(), normalFont));
                // Before Verification
                cell.addElement(new Paragraph("Answer before DVV Verification: " + deviation.getBeforeVerification(), normalFont));
                // After Verification
                cell.addElement(new Paragraph("Answer after DVV Verification: " + deviation.getAfterVerification(), normalFont));
                // Remark
                cell.addElement(new Paragraph("Remark: " + deviation.getRemark(), normalFont));

                table.addCell(cell);
            }

            document.add(table);

            // Add page number
            Paragraph pageNumber = new Paragraph("Page 104/107    17-05-2023 03:57:34", normalFont);
            pageNumber.setAlignment(Element.ALIGN_RIGHT);
            document.add(pageNumber);

            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}