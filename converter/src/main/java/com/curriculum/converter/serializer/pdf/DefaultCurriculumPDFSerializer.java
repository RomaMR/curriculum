package com.curriculum.converter.serializer.pdf;

import com.curriculum.converter.AbstractConverter;
import com.curriculum.domain.cirriculum.Curriculum;
import com.curriculum.domain.cirriculum.Module;
import com.curriculum.domain.cirriculum.Textbook;
import com.curriculum.domain.cirriculum.individual.IndividualElement;
import com.curriculum.domain.cirriculum.individual.IndividualWork;
import com.curriculum.dto.pdf.CurriculumPDF;
import com.curriculum.dto.pdf.ModulePDF;
import com.curriculum.dto.pdf.TextbookPDF;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component("defaultCurriculumPDFSerializer")
public class DefaultCurriculumPDFSerializer extends AbstractConverter<Curriculum, CurriculumPDF> {
    @Override
    public CurriculumPDF convert(final Curriculum curriculum, final CurriculumPDF curriculumPDF) {
        curriculumPDF.setName(curriculum.getName());
        curriculumPDF.setKnowledgeBranch(curriculum.getKnowledgeBranch());
        curriculumPDF.setTrainingDirection(curriculum.getTrainingDirection());
        curriculumPDF.setSpecialty(curriculum.getSpecialty());
        curriculumPDF.setFaculty(curriculum.getFaculty());
        curriculumPDF.setQualificationLevel(curriculum.getQualificationLevel());
        curriculumPDF.setStudyForm(curriculum.getStudyForm());
        curriculumPDF.setTerm(curriculum.getTerm());

        final Double course = Math.ceil(curriculum.getTerm() / 2.);
        curriculumPDF.setCourse(course.intValue());

        Integer curriculumSum = new Integer(0);

        final List<Module> modules = curriculum.getModules();
        final List<Textbook> textbooks = curriculum.getTextbooks();
        if (modules != null) {
            final Integer lecturesSum = modules.stream().mapToInt(Module::getLectures).sum();
            curriculumPDF.setLecturesSum(lecturesSum);

            final Integer laboratoriesSum = modules.stream().mapToInt(Module::getLaboratories).sum();
            curriculumPDF.setLaboratoriesSum(laboratoriesSum);

            final Integer auditoriumSum = lecturesSum + laboratoriesSum;
            curriculumPDF.setAuditoriumSum(auditoriumSum);

            curriculumSum += auditoriumSum;
        }

        final IndividualWork individualWork = curriculum.getIndividualWork();
        if (individualWork != null) {
            BigDecimal individualWorkSum = new BigDecimal(0);

            final IndividualElement colloquium = individualWork.getColloquium();
            if (colloquium != null) {
                curriculumPDF.setColloquium(colloquium.getCount());
                curriculumPDF.setColloquiumDuration(colloquium.getDurability());
                curriculumPDF.setColloquiumProgress(colloquium.getProgress());
                final BigDecimal colloquiumSum = colloquium.getDurability().multiply(new BigDecimal(colloquium.getCount()));
                curriculumPDF.setColloquiumSum(colloquiumSum);
                individualWorkSum = individualWorkSum.add(colloquiumSum);
            }

            final IndividualElement laboratory = individualWork.getLaboratory();
            if (laboratory != null) {
                curriculumPDF.setLaboratoriesCount(laboratory.getCount());
                curriculumPDF.setLaboratoryDuration(laboratory.getDurability());
                curriculumPDF.setLaboratoriesProgress(laboratory.getProgress());
                final BigDecimal laboratorySum = laboratory.getDurability().multiply(new BigDecimal(laboratory.getCount()));
                curriculumPDF.setLaboratorySum(laboratorySum);
                individualWorkSum = individualWorkSum.add(laboratorySum);
            }
            curriculumPDF.setProgressSum(curriculumPDF.getLaboratoriesSum()+curriculumPDF.getColloquiumProgress());
            curriculumPDF.setGeneralDuration(curriculumPDF.getColloquiumSum().add(new BigDecimal(curriculumPDF.getLaboratoriesSum())));
            curriculumPDF.setIndividualWork(individualWorkSum.intValue());

            curriculumSum += individualWorkSum.intValue();
        }

        curriculumPDF.setCurriculumSum(curriculumSum);

        if (modules != null) {
            final List<ModulePDF> modulePDFs = modules.stream().map(module -> {
                final ModulePDF modulePDF = new ModulePDF();
                modulePDF.setCode(module.getCode());
                modulePDF.setName(module.getName());
                modulePDF.setDescription(module.getDescription());
                modulePDF.setLectures(module.getLectures());
                modulePDF.setLaboratories(module.getLaboratories());
                return modulePDF;
            }).collect(Collectors.toList());
            curriculumPDF.setModules(modulePDFs);
            curriculumPDF.setLectures(modulePDFs);
            curriculumPDF.setLaboratories(modulePDFs);
        }

        if(textbooks != null) {
            final List<TextbookPDF> textbooksPDFs = textbooks.stream().map(textbook -> {
                final TextbookPDF textbookPDF = new TextbookPDF();
                textbookPDF.setCode(textbook.getCode());
                textbookPDF.setDescription(textbook.getValue());
                return textbookPDF;
            }).collect(Collectors.toList());
            curriculumPDF.setTextbooks(textbooksPDFs);
        }

        return curriculumPDF;
    }


    @Override
    public CurriculumPDF convert(final Curriculum curriculum) {
        return convert(curriculum, new CurriculumPDF());
    }
}
