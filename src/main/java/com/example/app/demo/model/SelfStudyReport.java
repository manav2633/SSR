package com.example.app.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.validation.constraints.NotBlank;

@Entity
public class SelfStudyReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String curriculumDesc;
    
    private String revisionPercentage;
    private String revisedPrograms;
    private String totalPrograms;
    private String curriculumFilePath;
    private String supportingDocPath;
    private String institutionalDataPath;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurriculumDesc() {
        return curriculumDesc;
    }

    public void setCurriculumDesc(String curriculumDesc) {
        this.curriculumDesc = curriculumDesc;
    }

    public String getRevisionPercentage() {
        return revisionPercentage;
    }

    public void setRevisionPercentage(String revisionPercentage) {
        this.revisionPercentage = revisionPercentage;
    }

    public String getRevisedPrograms() {
        return revisedPrograms;
    }

    public void setRevisedPrograms(String revisedPrograms) {
        this.revisedPrograms = revisedPrograms;
    }

    public String getTotalPrograms() {
        return totalPrograms;
    }

    public void setTotalPrograms(String totalPrograms) {
        this.totalPrograms = totalPrograms;
    }

    public String getCurriculumFilePath() {
        return curriculumFilePath;
    }

    public void setCurriculumFilePath(String curriculumFilePath) {
        this.curriculumFilePath = curriculumFilePath;
    }

    public String getSupportingDocPath() {
        return supportingDocPath;
    }

    public void setSupportingDocPath(String supportingDocPath) {
        this.supportingDocPath = supportingDocPath;
    }

    public String getInstitutionalDataPath() {
        return institutionalDataPath;
    }

    public void setInstitutionalDataPath(String institutionalDataPath) {
        this.institutionalDataPath = institutionalDataPath;
    }
}