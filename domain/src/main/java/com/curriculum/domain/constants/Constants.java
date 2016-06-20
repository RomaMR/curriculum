package com.curriculum.domain.constants;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document
public class Constants {

    @Id
    private String id;

    private ArrayList<String> knowledgeBranch;

    private ArrayList<String> trainingDirection;

    private ArrayList<String> specialty;

    private ArrayList<String> faculty;

    private ArrayList<String> qualificationLevel;

    private ArrayList<String> studyForm;

    private ArrayList<String> type;

    public Constants() {
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public ArrayList<String> getKnowledgeBranch() {
        return knowledgeBranch;
    }

    public void setKnowledgeBranch(final ArrayList<String> knowledgeBranch) {
        this.knowledgeBranch = knowledgeBranch;
    }

    public ArrayList<String> getTrainingDirection() {
        return trainingDirection;
    }

    public void setTrainingDirection(final ArrayList<String> trainingDirection) {
        this.trainingDirection = trainingDirection;
    }

    public ArrayList<String> getSpecialty() {
        return specialty;
    }

    public void setSpecialty(final ArrayList<String> specialty) {
        this.specialty = specialty;
    }

    public ArrayList<String> getFaculty() {
        return faculty;
    }

    public void setFaculty(final ArrayList<String> faculty) {
        this.faculty = faculty;
    }

    public ArrayList<String> getQualificationLevel() {
        return qualificationLevel;
    }

    public void setQualificationLevel(final ArrayList<String> qualificationLevel) {
        this.qualificationLevel = qualificationLevel;
    }

    public ArrayList<String> getStudyForm() {
        return studyForm;
    }

    public void setStudyForm(final ArrayList<String> studyForm) {
        this.studyForm = studyForm;
    }

    public ArrayList<String> getType() {
        return type;
    }

    public void setType(final ArrayList<String> type) {
        this.type = type;
    }
}
