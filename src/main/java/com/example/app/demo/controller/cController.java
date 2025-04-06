package com.example.app.demo.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/pdf")
public class cController {

    @GetMapping("/conclude")
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
        Font italicFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.ITALIC);

        // Add main heading
        // Paragraph mainHeading = new Paragraph("TECHNOLOGY (DA-IICT)", headingFont);
        // mainHeading.setAlignment(Element.ALIGN_CENTER);
        // mainHeading.setSpacingAfter(20);
        // document.add(mainHeading);

        // Add section heading
        Paragraph sectionHeading = new Paragraph("5. CONCLUSION", headingFont);
        sectionHeading.setAlignment(Element.ALIGN_CENTER);
        sectionHeading.setSpacingAfter(20);
        document.add(sectionHeading);

        // Add "Additional Information" heading
        Paragraph additionalInfoHeading = new Paragraph("Additional Information :", subHeadingFont);
        additionalInfoHeading.setSpacingAfter(10);
        document.add(additionalInfoHeading);

        // Add "Multidisciplinary/interdisciplinary" section
        Paragraph multidisciplinaryHeading = new Paragraph("Multidisciplinary/interdisciplinary:", boldFont);
        multidisciplinaryHeading.setSpacingAfter(5);
        document.add(multidisciplinaryHeading);

        Paragraph multidisciplinaryContent = new Paragraph("This is integrated with the basic philosophy of this university. We believe that a student requires a broad base and a focused goal. We teach our students computer science, IT, electronics, communication technology, and VLSI, besides introductory science courses in mathematics and physics. Then we allow them to explore what they want to learn.", normalFont);
        multidisciplinaryContent.setSpacingAfter(10);
        document.add(multidisciplinaryContent);

        // Add "Academic bank of credits (ABC)" section
        Paragraph abcHeading = new Paragraph("Academic bank of credits (ABC):", boldFont);
        abcHeading.setSpacingAfter(5);
        document.add(abcHeading);

        Paragraph abcContent = new Paragraph("DA-IICT has started the implementation of credit transfer with other institutes from 2019-20. There are three joint M.Tech. degree programs in which the concept of ABC is utilised:", normalFont);
        abcContent.setSpacingAfter(10);
        document.add(abcContent);

        // Add "Skill development" section
        Paragraph skillDevelopmentHeading = new Paragraph("Skill development:", boldFont);
        skillDevelopmentHeading.setSpacingAfter(5);
        document.add(skillDevelopmentHeading);

        Paragraph skillDevelopmentContent = new Paragraph("A multitude of skill development is inbuilt into our curriculum. Students learn data structures, circuit design, and OOP programming from the beginning. When they graduate they have skills in communication design, technical writing, data analysis and become experts in computer programming, webpage design and such other modern-day skills.", normalFont);
        skillDevelopmentContent.setSpacingAfter(10);
        document.add(skillDevelopmentContent);

        // Add "Integration of Indian knowledge" section
        Paragraph indianKnowledgeHeading = new Paragraph("Integration of Indian knowledge:", boldFont);
        indianKnowledgeHeading.setSpacingAfter(5);
        document.add(indianKnowledgeHeading);

        Paragraph indianKnowledgeContent = new Paragraph("In several Group discussions the students use native languages. All students take rigorous courses on Indian society and culture. The Cultural Committee, run by students celebrates all festivals in our campus. This inculcates the foundation of secularism, and a team spirit.", normalFont);
        indianKnowledgeContent.setSpacingAfter(10);
        document.add(indianKnowledgeContent);

        // Add "Focus on Outcome-based education (OBE)" section
        Paragraph obeHeading = new Paragraph("Focus on Outcome-based education (OBE):", boldFont);
        obeHeading.setSpacingAfter(5);
        document.add(obeHeading);

        Paragraph obeContent = new Paragraph("We have developed a learners-centric curriculum. The Program(s) Outcome (PO) is created by the Dean (AP). It is used by the Curriculum Review Committee(s) while reviewing the curriculum. For a new program proposal, a PO is first developed. While proposing a new course the stipulated PO is followed. For students learning, we keep continuous evaluation criteria right from the beginning.", normalFont);
        obeContent.setSpacingAfter(10);
        document.add(obeContent);

        // Add "Distance education/online education" section
        Paragraph distanceEducationHeading = new Paragraph("Distance education/online education:", boldFont);
        distanceEducationHeading.setSpacingAfter(5);
        document.add(distanceEducationHeading);

        Paragraph distanceEducationContent = new Paragraph("The pandemic year (2020-21) was a challenge for delivering education. Online teaching was started during this period. Faculty members used Moodle, Google Classroom and WebEx for teaching, online lab and quizzes. We had used Metti in conducting our online admissions tests and regular exams. Referring to online courses is encouraged here. Faculty tells the students who are the preferred and authentic sources of these online courses. Students refer to NPTEL, Coursera and other standard MOOC courses regularly.", normalFont);
        distanceEducationContent.setSpacingAfter(10);
        document.add(distanceEducationContent);

        // Add "Concluding Remarks" heading
        Paragraph concludingRemarksHeading = new Paragraph("Concluding Remarks :", subHeadingFont);
        concludingRemarksHeading.setSpacingAfter(10);
        document.add(concludingRemarksHeading);

        // Add concluding remarks content
        Paragraph concludingRemarksContent = new Paragraph("DA-IICT is a university devoted to Information and Communication (ICT) education and research. Since its inception, the Institute strives hard to provide quality education affordable to its aspirants with the goal of making engineering with social responsibility. The Institute is equipped with the state-of-the-art infrastructure, unique curriculum, vibrant student community, experienced faculty with total autonomy in governance.", normalFont);
        concludingRemarksContent.setSpacingAfter(10);
        document.add(concludingRemarksContent);

        // Add more concluding remarks content
        Paragraph concludingRemarksContent2 = new Paragraph("The quality standard adopted by the Institute is to pursue global standards of academic excellence in teaching, research, consultancy and continuing education focusing on ICT and allied areas.", normalFont);
        concludingRemarksContent2.setSpacingAfter(10);
        document.add(concludingRemarksContent2);

        // Add more concluding remarks content
        Paragraph concludingRemarksContent3 = new Paragraph("The Institute adheres Outcome-Based Education and implements Choice Based Credit System in all programs. The curriculum of each program is developed keeping in mind the attainment of Program Outcomes and Course Outcomes. Our faculty members are PhDs from premier universities in India and abroad, and many faculty members are having post-doctoral research experience. With their rich expertise, faculty members have developed various innovative pedagogical techniques to enhance teaching-learning and assessment mechanisms.", normalFont);
        concludingRemarksContent3.setSpacingAfter(10);
        document.add(concludingRemarksContent3);

        // Add more concluding remarks content
        Paragraph concludingRemarksContent4 = new Paragraph("The Institute encourages research in multidisciplinary areas that resulted in publications in reputed journals, conferences, sponsored projects, consultancy and patents. The awards and recognition received by our faculty include Padma Shri, Vikram Sarabhai, Sahitya Academy and more than a dozen faculty members are Senior members of the IEEE. The Institute has signed several MOUs with various research organisations, which has resulted in the offering of joint programs with IIT Jammu, AAU Anand and the IIRS Dehradun with the active participation of Industries.", normalFont);
        concludingRemarksContent4.setSpacingAfter(10);
        document.add(concludingRemarksContent4);

        // Add more concluding remarks content
        Paragraph concludingRemarksContent5 = new Paragraph("The student community of the Institute is vibrant, self-regulated by a Student Body Government. Students from diverse social, cultural, economic, religious and linguistic backgrounds live together on the campus with a rich pool of students clubs, which conducts numerous activities in sports, culture and tech-culture throughout the year.", normalFont);
        concludingRemarksContent5.setSpacingAfter(10);
        document.add(concludingRemarksContent5);

        // Add more concluding remarks content
        Paragraph concludingRemarksContent6 = new Paragraph("The Institute is mentored by visionary advisory bodies and proactive management. The Institute has a strong base of alumni and some of them are playing leadership roles in industry. Standing with the support of faculty, alumni, students and management the Institute believes in providing value-based education that integrates knowledge, skills, ethics, commitment to profession and service to society.", normalFont);
        concludingRemarksContent6.setSpacingAfter(10);
        document.add(concludingRemarksContent6);

        // Close the document
        document.close();
    }
}