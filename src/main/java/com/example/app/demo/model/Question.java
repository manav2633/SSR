package com.example.app.demo.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String section; // e.g., "1.1.1 Curriculum Design and Development"
    private String questionText; // e.g., "Curricula developed and implemented have relevance to..."
    private String response; // e.g., "The curricula at DA-IICT has been consciously developed..."
    private String documentUrl; // URL to the document in AWS S3
}
