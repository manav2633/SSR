package com.example.app.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ConclusionData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String section; // e.g., "Multidisciplinary/interdisciplinary"
    private String content; // e.g., "This is integrated with the basic philosophy of this university..."
}