package com.curriculum.domain.cirriculum;

import com.curriculum.domain.cirriculum.individual.IndividualWork;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class Curriculum {

  @Id
  private String id;

  @CreatedBy
  private String createdBy;

  @CreatedDate
  private Date createdDate;

  private String name;

  private String knowledgeBranch;

  private String trainingDirection;

  private String specialty;

  private String faculty;

  private String qualificationLevel;

  private String studyForm;

  private Integer term;

  private String type;

  private IndividualWork individualWork;

  private List<Module> modules;

  private List<Textbook> textbooks;

  public Curriculum() {
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

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(final Date createdDate) {
    this.createdDate = createdDate;
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

  public String getStudyForm() {
    return studyForm;
  }

  public void setStudyForm(final String studyForm) {
    this.studyForm = studyForm;
  }

  public Integer getTerm() {
    return term;
  }

  public void setTerm(final Integer term) {
    this.term = term;
  }

  public String getType() {
    return type;
  }

  public void setType(final String type) {
    this.type = type;
  }

  public IndividualWork getIndividualWork() {
    return individualWork;
  }

  public void setIndividualWork(final IndividualWork individualWork) {
    this.individualWork = individualWork;
  }

  public List<Module> getModules() {
    return modules;
  }

  public void setModules(final List<Module> modules) {
    this.modules = modules;
  }

  public List<Textbook> getTextbooks() {
    return textbooks;
  }

  public void setTextbooks(final List<Textbook> textbooks) {
    this.textbooks = textbooks;
  }
}