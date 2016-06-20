package com.curriculum.dto.pdf;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.math.BigDecimal;
import java.util.List;

@JacksonXmlRootElement(localName = "curriculum")
public class CurriculumPDF {

    private String name;

    private String knowledgeBranch;

    private String trainingDirection;

    private String specialty;

    private String faculty;

    private String qualificationLevel;

    private String studyForm;

    private Integer term;

    private Integer course;

    private Integer lecturesSum;

    private Integer laboratoriesSum;

    private Integer individualWork;

    private Integer colloquium;

    private Integer curriculumSum;

    private Integer auditoriumSum;

    private Integer laboratoriesCount;

    private Integer laboratoriesProgress;

    private Integer colloquiumProgress;

    private Integer progressSum;

    private BigDecimal laboratoryDuration;

    private BigDecimal colloquiumDuration;

    private BigDecimal laboratorySum;

    private BigDecimal colloquiumSum;

    private BigDecimal generalDuration;


    @JacksonXmlProperty(localName = "module")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<ModulePDF> modules;

    @JacksonXmlProperty(localName = "lectures")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<ModulePDF> lectures;

    @JacksonXmlProperty(localName = "laboratories")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<ModulePDF> laboratories;

    @JacksonXmlProperty(localName = "textbooks")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<TextbookPDF> textbooks;

    public CurriculumPDF() {
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

    public Integer getCourse() {
        return course;
    }

    public void setCourse(final Integer course) {
        this.course = course;
    }

    public Integer getLecturesSum() {
        return lecturesSum;
    }

    public void setLecturesSum(final Integer lecturesSum) {
        this.lecturesSum = lecturesSum;
    }

    public Integer getLaboratoriesSum() {
        return laboratoriesSum;
    }

    public void setLaboratoriesSum(final Integer laboratoriesSum) {
        this.laboratoriesSum = laboratoriesSum;
    }

    public Integer getIndividualWork() {
        return individualWork;
    }

    public void setIndividualWork(final Integer individualWork) {
        this.individualWork = individualWork;
    }

    public Integer getColloquium() {
        return colloquium;
    }

    public void setColloquium(final Integer colloquium) {
        this.colloquium = colloquium;
    }

    public Integer getCurriculumSum() {
        return curriculumSum;
    }

    public void setCurriculumSum(final Integer curriculumSum) {
        this.curriculumSum = curriculumSum;
    }

    public Integer getAuditoriumSum() {
        return auditoriumSum;
    }

    public void setAuditoriumSum(final Integer auditoriumSum) {
        this.auditoriumSum = auditoriumSum;
    }

    public List<ModulePDF> getModules() {
        return modules;
    }

    public void setModules(final List<ModulePDF> modules) {
        this.modules = modules;
    }

    public List<ModulePDF> getLectures() {
        return lectures;
    }

    public void setLectures(final List<ModulePDF> lectures) {
        this.lectures = lectures;
    }

    public List<ModulePDF> getLaboratories() {
        return laboratories;
    }

    public void setLaboratories(final List<ModulePDF> laboratories) {
        this.laboratories = laboratories;
    }

    public List<TextbookPDF> getTextbooks() {
        return textbooks;
    }

    public void setTextbooks(List<TextbookPDF> textbooks) {
        this.textbooks = textbooks;
    }

    public void setLaboratoriesCount(final Integer laboratoriesCount) {
        this.laboratoriesCount = laboratoriesCount;
    }

    public Integer geLaboratoriesCount() {
        return laboratoriesCount;
    }

    public BigDecimal getLaboratoryDuration() {
        return laboratoryDuration;
    }

    public void setLaboratoryDuration(final BigDecimal laboratoryDuration) {
        this.laboratoryDuration = laboratoryDuration;
    }

    public BigDecimal getColloquiumDuration() {
        return colloquiumDuration;
    }

    public void setColloquiumDuration(final BigDecimal colloquiumDuration) {
        this.colloquiumDuration = colloquiumDuration;
    }

    public BigDecimal getLaboratorySum() {
        return laboratorySum;
    }

    public void setLaboratorySum(final BigDecimal laboratorySum) {
        this.laboratorySum = laboratorySum;
    }

    public BigDecimal getColloquiumSum() {
        return colloquiumSum;
    }

    public void setColloquiumSum(final BigDecimal colloquiumSum) {
        this.colloquiumSum = colloquiumSum;
    }

    public Integer getLaboratoriesCount() {
        return laboratoriesCount;
    }

    public BigDecimal getGeneralDuration() {
        return generalDuration;
    }

    public void setGeneralDuration(BigDecimal generalDuration) {
        this.generalDuration = generalDuration;
    }

    public Integer getLaboratoriesProgress() {
        return laboratoriesProgress;
    }

    public void setLaboratoriesProgress(Integer laboratoriesProgress) {
        this.laboratoriesProgress = laboratoriesProgress;
    }

    public Integer getColloquiumProgress() {
        return colloquiumProgress;
    }

    public void setColloquiumProgress(Integer colloquiumProgress) {
        this.colloquiumProgress = colloquiumProgress;
    }

    public Integer getProgressSum() {
        return progressSum;
    }

    public void setProgressSum(Integer progressSum) {
        this.progressSum = progressSum;
    }
}
