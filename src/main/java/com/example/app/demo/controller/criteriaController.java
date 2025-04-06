package com.example.app.demo.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/pdf")
public class criteriaController {

    @GetMapping("/criteria")
    public void generatePdf(HttpServletResponse response) throws IOException, DocumentException {
        // Set the content type and attachment header
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"4_try.pdf\"");

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
        Font linkFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.UNDERLINE, BaseColor.BLUE);

        // Add main heading
        Paragraph mainHeading = new Paragraph("4. Quality Indicator Framework (QIF)", headingFont);
        mainHeading.setAlignment(Element.ALIGN_CENTER);
        mainHeading.setSpacingAfter(20);
        document.add(mainHeading);

        // Add subheading for Criterion 1
        Paragraph criterionHeading = new Paragraph("Criterion 1 - Curricular Aspects", subHeadingFont);
        criterionHeading.setSpacingAfter(10);
        document.add(criterionHeading);

        // Add subheading for 1.1 Curriculum Design and Development
        Paragraph curriculumHeading = new Paragraph("1.1 Curriculum Design and Development", boldFont);
        curriculumHeading.setSpacingAfter(10);
        document.add(curriculumHeading);

        // Add 1.1.1 content
        Paragraph content1 = new Paragraph(
                "1.1.1 Curricula developed and implemented have relevance to the local, national, regional and global developmental needs which is reflected in Programme outcomes (POs), Programme Specific Outcomes (PSOs) and Course Outcomes (COs) of the Programmes offered by the Institution.",
                normalFont);
        content1.setSpacingAfter(10);
        document.add(content1);

        // Add "Response" heading
        Paragraph responseHeading = new Paragraph("Response:", boldFont);
        responseHeading.setSpacingAfter(10);
        document.add(responseHeading);

        // Add response content
        Paragraph responseContent = new Paragraph(
                "The curricula at DA-IICT has been consciously developed by considering local, national, regional and global developmental needs so that students are equipped with foundational knowledge, industry relevance electives and exposure in internship and project work. The course structure of the curricula of each programme is broadly classified into three categories. The first category, referred to as Foundation, is a set of compulsory courses required to be taken by every student in the programme. The next one is formed by a set of courses, referred to as the Electives, which forms both the technical strength and humanities and social science skills of the programmes. The third one is composed of internships and projects. The curricula provide students a multi-track option where a student can achieve depth in one track and/or breadth in multiple tracks through an appropriate choice of elective courses.",
                normalFont);
        responseContent.setSpacingAfter(10);
        document.add(responseContent);

        // Add "Local development" section
        Paragraph localDevelopmentHeading = new Paragraph("Local development:", boldFont);
        localDevelopmentHeading.setSpacingAfter(5);
        document.add(localDevelopmentHeading);

        List localDevelopmentList = new List(List.UNORDERED);
        localDevelopmentList.add(new ListItem(
                "A set of courses such as Language and Literature, Science, Technology and Society engage students in understanding local socio-economic-tech conditions.",
                normalFont));
        localDevelopmentList.add(new ListItem(
                "The Rural internship after the third semester of BTech program allows students to interact with the local community and understand the needs for societal development.",
                normalFont));
        document.add(localDevelopmentList);

        // Add "National development" section
        Paragraph nationalDevelopmentHeading = new Paragraph("National development:", boldFont);
        nationalDevelopmentHeading.setSpacingAfter(5);
        document.add(nationalDevelopmentHeading);

        List nationalDevelopmentList = new List(List.UNORDERED);
        nationalDevelopmentList.add(new ListItem(
                "The institute runs a joint MTech (CSE) program with IIT Jammu, a joint MTech (EC) program with C R Rao AIMSCS-Hyderabad and a joint MSc (Agriculture Analytics) program with AAU-Anand and IIRS-Dehradun. These put a strong focus of the institute’s objective with pan India view of its academic and research collaboration.",
                normalFont));
        nationalDevelopmentList.add(new ListItem(
                "The course on Approaches to Indian Society visualizes students about the national needs and how the young generation can engage in providing solutions to social developments of our nation.",
                normalFont));
        nationalDevelopmentList.add(new ListItem(
                "Course on Principles of Economics provides avenues to students to understand the socio-economic factors of the country.",
                normalFont));
        nationalDevelopmentList.add(new ListItem(
                "Industrial or Research internship helps students to experience solving problems and acquiring skills in scientific and empirical results.",
                normalFont));
        nationalDevelopmentList.add(new ListItem(
                "Yoga, life skills, sports make the student engage in co-curricular and extra-curricular activities apart from curricular aspects.",
                normalFont));
        document.add(nationalDevelopmentList);

        // Add "Global development" section
        Paragraph globalDevelopmentHeading = new Paragraph("Global development:", boldFont);
        globalDevelopmentHeading.setSpacingAfter(5);
        document.add(globalDevelopmentHeading);

        Paragraph globalDevelopmentContent = new Paragraph(
                "A rich collection of electives offered in our curricula meets the students’ expectation for Global developmental needs. Different kinds of electives (ICT, Technical, Science, Open)",
                normalFont);
        globalDevelopmentContent.setSpacingAfter(10);
        document.add(globalDevelopmentContent);

        // Add Self Study Report section
        Paragraph selfStudyReportHeading = new Paragraph(
                "Self Study Report of DHIRUBHAI AMBANI INSTITUTE OF INFORMATION AND COMMUNICATION TECHNOLOGY (DA-IICT)",
                boldFont);
        selfStudyReportHeading.setSpacingAfter(10);
        document.add(selfStudyReportHeading);

        // Add table for File Description and Document links
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10);
        table.setSpacingAfter(10);

        // Add table headers
        table.addCell(createCell("File Description", boldFont));
        table.addCell(createCell("Document", boldFont));

        // Add table rows
        table.addCell(createCell("Upload Additional information", normalFont));
        table.addCell(createCell("View Document", linkFont));

        table.addCell(createCell("Link for Additional information", normalFont));
        table.addCell(createCell("View Document", linkFont));

        document.add(table);

        // Add 1.1.2 section
        Paragraph section112Heading = new Paragraph(
                "1.1.2 Percentage of Programmes where syllabus revision was carried out during the last five years.",
                boldFont);
        section112Heading.setSpacingAfter(10);
        document.add(section112Heading);

        Paragraph section112Response = new Paragraph("Response: 100", normalFont);
        section112Response.setSpacingAfter(10);
        document.add(section112Response);

        // Add 1.1.2.1 section
        Paragraph section1121Heading = new Paragraph(
                "1.1.2.1 How many Programmes were revised out of total number of Programmes offered during the last five years",
                boldFont);
        section1121Heading.setSpacingAfter(5);
        document.add(section1121Heading);

        Paragraph section1121Response = new Paragraph("Response: 9", normalFont);
        section1121Response.setSpacingAfter(10);
        document.add(section1121Response);

        // Add 1.1.2.2 section
        Paragraph section1122Heading = new Paragraph(
                "1.1.2.2 Number of all Programmes offered by the institution during the last five years.", boldFont);
        section1122Heading.setSpacingAfter(5);
        document.add(section1122Heading);

        Paragraph section1122Response = new Paragraph("Response: 9", normalFont);
        section1122Response.setSpacingAfter(10);
        document.add(section1122Response);

        // Add table for File Description and Document links for 1.1.2
        PdfPTable table112 = new PdfPTable(2);
        table112.setWidthPercentage(100);
        table112.setSpacingBefore(10);
        table112.setSpacingAfter(10);

        // Add table headers
        table112.addCell(createCell("File Description", boldFont));
        table112.addCell(createCell("Document", boldFont));

        // Add table rows
        table112.addCell(createCell("Minutes of relevant Academic Council/BOS meeting", normalFont));
        table112.addCell(createCell("View Document", linkFont));

        table112.addCell(createCell("Institutional data in prescribed format", normalFont));
        table112.addCell(createCell("View Document", linkFont));

        table112.addCell(createCell("Details of Programme syllabus revision in last 5 years", normalFont));
        table112.addCell(createCell("View Document", linkFont));

        table112.addCell(createCell("Any additional information", normalFont));
        table112.addCell(createCell("View Document", linkFont));

        table112.addCell(createCell("Link for additional information", normalFont));
        table112.addCell(createCell("View Document", linkFont));

        document.add(table112);

        // Add 1.1.3 section
        Paragraph section113Heading = new Paragraph(
                "1.1.3 Average percentage of courses having focus on employability/ entrepreneurship/skill development offered by the institution during the last five years",
                boldFont);
        section113Heading.setSpacingAfter(10);
        document.add(section113Heading);

        Paragraph section113Response = new Paragraph("Response: 100", normalFont);
        section113Response.setSpacingAfter(10);
        document.add(section113Response);

        // Add 1.1.3.1 section
        Paragraph section1131Heading = new Paragraph(
                "1.1.3.1 Number of courses having focus on employability/ entrepreneurship/skill development year-wise during the last five years",
                boldFont);
        section1131Heading.setSpacingAfter(5);
        document.add(section1131Heading);

        // Add table for year-wise data
        PdfPTable table1131 = new PdfPTable(5);
        table1131.setWidthPercentage(100);
        table1131.setSpacingBefore(10);
        table1131.setSpacingAfter(10);

        // Add table headers
        table1131.addCell(createCell("2021-22", boldFont));
        table1131.addCell(createCell("2020-21", boldFont));
        table1131.addCell(createCell("2019-20", boldFont));
        table1131.addCell(createCell("2018-19", boldFont));
        table1131.addCell(createCell("2017-18", boldFont));

        // Add table rows
        table1131.addCell(createCell("186", normalFont));
        table1131.addCell(createCell("177", normalFont));
        table1131.addCell(createCell("170", normalFont));
        table1131.addCell(createCell("152", normalFont));
        table1131.addCell(createCell("157", normalFont));

        document.add(table1131);

        // Add table for File Description and Document links for 1.1.3
        PdfPTable table113 = new PdfPTable(2);
        table113.setWidthPercentage(100);
        table113.setSpacingBefore(10);
        table113.setSpacingAfter(10);

        // Add table headers
        table113.addCell(createCell("File Description", boldFont));
        table113.addCell(createCell("Document", boldFont));

        // Add table rows
        table113.addCell(createCell("Programme/ Curriculum/Syllabus of the courses", normalFont));
        table113.addCell(createCell("View Document", linkFont));

        table113.addCell(createCell("MoU's with relevant organizations for these courses, if any", normalFont));
        table113.addCell(createCell("View Document", linkFont));

        table113.addCell(createCell(
                "Minutes of the Boards of Studies/Academic Council meetings with approvals for these courses",
                normalFont));
        table113.addCell(createCell("View Document", linkFont));

        table113.addCell(createCell("Institutional data in prescribed format", normalFont));
        table113.addCell(createCell("View Document", linkFont));

        table113.addCell(createCell("Any additional information", normalFont));
        table113.addCell(createCell("View Document", linkFont));

        document.add(table113);

        // Add 1.2 Academic Flexibility section
        Paragraph section12Heading = new Paragraph("1.2 Academic Flexibility", boldFont);
        section12Heading.setSpacingAfter(10);
        document.add(section12Heading);

        // Add 1.2.1 section
        Paragraph section121Heading = new Paragraph(
                "1.2.1 Percentage of new courses introduced of the total number of courses across all programs offered during the last five years.",
                boldFont);
        section121Heading.setSpacingAfter(10);
        document.add(section121Heading);

        Paragraph section121Response = new Paragraph("Response: 68.73", normalFont);
        section121Response.setSpacingAfter(10);
        document.add(section121Response);

        // Add 1.2.1.1 section
        Paragraph section1211Heading = new Paragraph(
                "1.2.1.1 How many new courses were introduced within the last five years.", boldFont);
        section1211Heading.setSpacingAfter(5);
        document.add(section1211Heading);

        Paragraph section1211Response = new Paragraph("Response: 222", normalFont);
        section1211Response.setSpacingAfter(10);
        document.add(section1211Response);

        // Add 1.2.1.2 section
        Paragraph section1212Heading = new Paragraph(
                "1.2.1.2 Number of courses offered by the institution across all programmes during the last five years.",
                boldFont);
        section1212Heading.setSpacingAfter(5);
        document.add(section1212Heading);

        Paragraph section1212Response = new Paragraph("Response: 323", normalFont);
        section1212Response.setSpacingAfter(10);
        document.add(section1212Response);

        // Add table for File Description and Document links for 1.2.1
        PdfPTable table121 = new PdfPTable(2);
        table121.setWidthPercentage(100);
        table121.setSpacingBefore(10);
        table121.setSpacingAfter(10);

        // Add table headers
        table121.addCell(createCell("File Description", boldFont));
        table121.addCell(createCell("Document", boldFont));

        // Add table rows
        table121.addCell(createCell("Minutes of relevant Academic Council/BOS meeting", normalFont));
        table121.addCell(createCell("View Document", linkFont));

        table121.addCell(createCell("Institutional data in prescribed format", normalFont));
        table121.addCell(createCell("View Document", linkFont));

        table121.addCell(createCell("Any additional information", normalFont));
        table121.addCell(createCell("View Document", linkFont));

        document.add(table121);

        // Add 1.2.2 section
        Paragraph section122Heading = new Paragraph(
                "1.2.2 Percentage of Programmes in which Choice Based Credit System (CBCS) / elective course system has been implemented (Data for the latest completed academic year).",
                boldFont);
        section122Heading.setSpacingAfter(10);
        document.add(section122Heading);

        Paragraph section122Response = new Paragraph("Response: 88.89", normalFont);
        section122Response.setSpacingAfter(10);
        document.add(section122Response);

        // Add 1.2.2.1 section
        Paragraph section1221Heading = new Paragraph(
                "1.2.2.1 Number of Programmes in which CBCS / Elective course system implemented.", boldFont);
        section1221Heading.setSpacingAfter(5);
        document.add(section1221Heading);

        Paragraph section1221Response = new Paragraph("Response: 8", normalFont);
        section1221Response.setSpacingAfter(10);
        document.add(section1221Response);

        // Add 1.3 Curriculum Enrichment section
        Paragraph section13Heading = new Paragraph("1.3 Curriculum Enrichment", boldFont);
        section13Heading.setSpacingAfter(10);
        document.add(section13Heading);

        // Add 1.3.1 section
        Paragraph section131Heading = new Paragraph(
                "1.3.1 Institution integrates crosscutting issues relevant to Professional Ethics, Gender, Human Values, Environment and Sustainability into the Curriculum",
                boldFont);
        section131Heading.setSpacingAfter(5);
        document.add(section131Heading);

        Paragraph section131Response = new Paragraph("Response:", boldFont);
        section131Response.setSpacingAfter(5);
        document.add(section131Response);

        Paragraph section131Content = new Paragraph(
                "The curriculum of all programmes emphasize in integrating cross-cutting issues relevant to professional ethics, gender, human values, environment, and sustainability with a view to ensure holistic development of the students. Faculty members adopt a variety of innovative pedagogical approaches to enhance teaching-learning and evaluation, namely, project-based learning, flipped classroom, readings-presentation, etc.",
                normalFont);
        section131Content.setSpacingAfter(5);
        document.add(section131Content);

        Paragraph section131Content2 = new Paragraph(
                "The course Environmental Sciences in the undergraduate programmes make all students aware of the environment and its associated parameters and values to the society. The institute continually integrates a large number of open electives in the areas of ethics, human values, gender, and organizational behavior and human development. Technical Writing, Research Methodology, and Narratology are PG level courses that enhance students’ skills for professional ethics and development. Gender sensitization sessions are conducted in every academic session for making students acquainted with campus life.",
                normalFont);
        section131Content2.setSpacingAfter(5);
        document.add(section131Content2);

        Paragraph section131Content3 = new Paragraph(
                "Furthermore, our student body is composed of a variety of co-curricular and extra-curricular activities by the student clubs throughout the calendar that provide substantial value addition to the overall growth of the students.",
                normalFont);
        section131Content3.setSpacingAfter(10);
        document.add(section131Content3);

        // Add table for File Description and Document links for 1.3.1
        PdfPTable table131 = new PdfPTable(2);
        table131.setWidthPercentage(100);
        table131.setSpacingBefore(10);
        table131.setSpacingAfter(10);

        // Add table headers
        table131.addCell(createCell("File Description", boldFont));
        table131.addCell(createCell("Document", boldFont));

        // Add table rows
        table131.addCell(createCell(
                "Upload the list and description of the courses which address the Gender, Environment and Sustainability, Human Values and Professional Ethics into the Curriculum",
                normalFont));
        table131.addCell(createCell("View Document", linkFont));

        document.add(table131);

        // Add 1.3.2 section
        Paragraph section132Heading = new Paragraph(
                "1.3.2 Number of value-added courses for imparting transferable and life skills offered during last five years.",
                boldFont);
        section132Heading.setSpacingAfter(5);
        document.add(section132Heading);

        Paragraph section132Response = new Paragraph("Response: 29", normalFont);
        section132Response.setSpacingAfter(5);
        document.add(section132Response);

        // Add 1.3.2.1 section
        Paragraph section1321Heading = new Paragraph(
                "1.3.2.1 How many new value-added courses are added within the last five years.", boldFont);
        section1321Heading.setSpacingAfter(5);
        document.add(section1321Heading);

        Paragraph section1321Response = new Paragraph("Response: 29", normalFont);
        section1321Response.setSpacingAfter(10);
        document.add(section1321Response);

        // Add table for File Description and Document links for 1.3.2
        PdfPTable table132 = new PdfPTable(2);
        table132.setWidthPercentage(100);
        table132.setSpacingBefore(10);
        table132.setSpacingAfter(10);

        // Add table headers
        table132.addCell(createCell("File Description", boldFont));
        table132.addCell(createCell("Document", boldFont));

        // Add table rows
        table132.addCell(createCell("Institutional data in prescribed format", normalFont));
        table132.addCell(createCell("View Document", linkFont));

        table132.addCell(createCell("Brochure or any other document relating to value added courses", normalFont));
        table132.addCell(createCell("View Document", linkFont));

        table132.addCell(createCell("Any additional information", normalFont));
        table132.addCell(createCell("View Document", linkFont));

        document.add(table132);

        // Add 1.3.3 section
        Paragraph section133Heading = new Paragraph(
                "1.3.3 Average Percentage of students enrolled in the courses under 1.3.2 above.", boldFont);
        section133Heading.setSpacingAfter(5);
        document.add(section133Heading);

        Paragraph section133Response = new Paragraph("Response: 25.39", normalFont);
        section133Response.setSpacingAfter(5);
        document.add(section133Response);

        // Add 1.3.3.1 section
        Paragraph section1331Heading = new Paragraph(
                "1.3.3.1 Number of students enrolled in value-added courses imparting transferable and life skills offered year-wise during the last five years.",
                boldFont);
        section1331Heading.setSpacingAfter(5);
        document.add(section1331Heading);

        // Add table for year-wise data
        PdfPTable table1331 = new PdfPTable(5);
        table1331.setWidthPercentage(100);
        table1331.setSpacingBefore(10);
        table1331.setSpacingAfter(10);

        // Add table headers
        table1331.addCell(createCell("2021-22", boldFont));
        table1331.addCell(createCell("2020-21", boldFont));
        table1331.addCell(createCell("2019-20", boldFont));
        table1331.addCell(createCell("2018-19", boldFont));
        table1331.addCell(createCell("2017-18", boldFont));

        // Add table rows
        table1331.addCell(createCell("517", normalFont));
        table1331.addCell(createCell("475", normalFont));
        table1331.addCell(createCell("455", normalFont));
        table1331.addCell(createCell("450", normalFont));
        table1331.addCell(createCell("431", normalFont));

        document.add(table1331);

        // Add 1.3.4 section
        Paragraph section134Heading = new Paragraph(
                "1.3.4 Percentage of students undertaking field projects / research projects / internships (Data for the latest completed academic year).",
                boldFont);
        section134Heading.setSpacingAfter(5);
        document.add(section134Heading);

        Paragraph section134Response = new Paragraph("Response: 50.63", normalFont);
        section134Response.setSpacingAfter(5);
        document.add(section134Response);

        // Add 1.3.4.1 section
        Paragraph section1341Heading = new Paragraph(
                "1.3.4.1 Number of students undertaking field projects or research projects or internships.", boldFont);
        section1341Heading.setSpacingAfter(5);
        document.add(section1341Heading);

        Paragraph section1341Response = new Paragraph("Response: 1050", normalFont);
        section1341Response.setSpacingAfter(10);
        document.add(section1341Response);

        // Add table for File Description and Document links for 1.3.4
        PdfPTable table134 = new PdfPTable(2);
        table134.setWidthPercentage(100);
        table134.setSpacingBefore(10);
        table134.setSpacingAfter(10);

        // Add table headers
        table134.addCell(createCell("File Description", boldFont));
        table134.addCell(createCell("Document", boldFont));

        // Add table rows
        table134.addCell(createCell(
                "List of Programmes and number of students undertaking field projects research projects/ / internships (Data Template)",
                normalFont));
        table134.addCell(createCell("View Document", linkFont));

        table134.addCell(createCell("Any additional information", normalFont));
        table134.addCell(createCell("View Document", linkFont));

        table134.addCell(createCell("Link for additional information", normalFont));
        table134.addCell(createCell("View Document", linkFont));

        document.add(table134);

        // Add 1.4 Feedback System section
        Paragraph section14Heading = new Paragraph("1.4 Feedback System", boldFont);
        section14Heading.setSpacingAfter(10);
        document.add(section14Heading);

        // Add 1.4.1 section
        Paragraph section141Heading = new Paragraph(
                "1.4.1 Structured feedback for design and review of syllabus – semester-wise / year-wise is received from 1) Students, 2) Teachers, 3) Employers, 4) Alumni",
                boldFont);
        section141Heading.setSpacingAfter(5);
        document.add(section141Heading);

        Paragraph section141Response = new Paragraph("Response: A. All 4 of the above", normalFont);
        section141Response.setSpacingAfter(10);
        document.add(section141Response);

        // Add table for File Description and Document links for 1.4.1
        PdfPTable table141 = new PdfPTable(2);
        table141.setWidthPercentage(100);
        table141.setSpacingBefore(10);
        table141.setSpacingAfter(10);

        // Add table headers
        table141.addCell(createCell("File Description", boldFont));
        table141.addCell(createCell("Document", boldFont));

        // Add table rows
        table141.addCell(createCell("URL for stakeholder feedback report", normalFont));
        table141.addCell(createCell("View Document", linkFont));

        table141.addCell(createCell("Institutional data in prescribed format", normalFont));
        table141.addCell(createCell("View Document", linkFont));

        table141.addCell(createCell("Any additional information", normalFont));
        table141.addCell(createCell("View Document", linkFont));

        table141.addCell(createCell(
                "Action taken report of the University on feedback report as stated in the minutes of the Governing Council, Syndicate, Board of Management (Upload)",
                normalFont));
        table141.addCell(createCell("View Document", linkFont));

        document.add(table141);

        // Add 1.4.2 section
        Paragraph section142Heading = new Paragraph(
                "1.4.2 Feedback processes of the institution may be classified as follows:", boldFont);
        section142Heading.setSpacingAfter(5);
        document.add(section142Heading);

        Paragraph section142Response = new Paragraph(
                "Response: A. Feedback collected, analysed and action taken and feedback available on website",
                normalFont);
        section142Response.setSpacingAfter(10);
        document.add(section142Response);

        // Add table for File Description and Document links for 1.4.2
        PdfPTable table142 = new PdfPTable(2);
        table142.setWidthPercentage(100);
        table142.setSpacingBefore(10);
        table142.setSpacingAfter(10);

        // Add table headers
        table142.addCell(createCell("File Description", boldFont));
        table142.addCell(createCell("Document", boldFont));

        // Add table rows
        table142.addCell(createCell("URL for feedback report", normalFont));
        table142.addCell(createCell("View Document", linkFont));

        table142.addCell(createCell("Upload any additional information", normalFont));
        table142.addCell(createCell("View Document", linkFont));

        table142.addCell(createCell("Institutional data in prescribed format", normalFont));
        table142.addCell(createCell("View Document", linkFont));

        document.add(table142);

        // Close the document
        document.close();
    }

    // Helper method to create a cell with specified font
    private PdfPCell createCell(String text, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setPadding(5);
        return cell;
    }
}