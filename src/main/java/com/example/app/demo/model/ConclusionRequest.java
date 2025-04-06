package com.example.app.demo.model;

import java.util.List;

public class ConclusionRequest {
    private List<Section> sections;
    private List<String> concludingRemarks;

    // Getters and Setters
    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public List<String> getConcludingRemarks() {
        return concludingRemarks;
    }

    public void setConcludingRemarks(List<String> concludingRemarks) {
        this.concludingRemarks = concludingRemarks;
    }

    public static class Section {
        private String section;
        private String content;

        // Getters and Setters
        public String getSection() {
            return section;
        }

        public void setSection(String section) {
            this.section = section;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}