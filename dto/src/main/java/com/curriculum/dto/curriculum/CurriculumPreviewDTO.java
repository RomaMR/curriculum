package com.curriculum.dto.curriculum;


public class CurriculumPreviewDTO {

    private String id;

    private String createdBy;

    private String name;

    private String knowledgeBranch;

    private String trainingDirection;

    private String specialty;

    private String faculty;

    private String qualificationLevel;

    private Integer term;

    public CurriculumPreviewDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getKnowledgeBranch() {
        return knowledgeBranch;
    }

    public void setKnowledgeBranch(final String knowledgeBranch) {
        this.knowledgeBranch = knowledgeBranch;
    }

    public String getTrainingDirection() {
        return trainingDirection;
    }

    public void setTrainingDirection(final String trainingDirection) {
        this.trainingDirection = trainingDirection;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(final String specialty) {
        this.specialty = specialty;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(final String faculty) {
        this.faculty = faculty;
    }

    public String getQualificationLevel() {
        return qualificationLevel;
    }

    public void setQualificationLevel(final String qualificationLevel) {
        this.qualificationLevel = qualificationLevel;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(final Integer term) {
        this.term = term;
    }
}
