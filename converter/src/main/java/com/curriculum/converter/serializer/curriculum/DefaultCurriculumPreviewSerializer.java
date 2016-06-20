package com.curriculum.converter.serializer.curriculum;

import com.curriculum.converter.AbstractConverter;
import com.curriculum.domain.cirriculum.Curriculum;
import com.curriculum.dto.curriculum.CurriculumPreviewDTO;
import org.springframework.stereotype.Component;

@Component
public class DefaultCurriculumPreviewSerializer extends AbstractConverter<Curriculum, CurriculumPreviewDTO> {

    @Override
    public CurriculumPreviewDTO convert(final Curriculum curriculum, final CurriculumPreviewDTO curriculumPreviewDTO) {
        curriculumPreviewDTO.setId(curriculum.getId());
        curriculumPreviewDTO.setName(curriculum.getName());
        curriculumPreviewDTO.setFaculty(curriculum.getFaculty());
        curriculumPreviewDTO.setKnowledgeBranch(curriculum.getKnowledgeBranch());
        curriculumPreviewDTO.setQualificationLevel(curriculum.getQualificationLevel());
        curriculumPreviewDTO.setSpecialty(curriculum.getSpecialty());
        curriculumPreviewDTO.setTerm(curriculum.getTerm());
        curriculumPreviewDTO.setTrainingDirection(curriculum.getTrainingDirection());
        curriculumPreviewDTO.setCreatedBy(curriculum.getCreatedBy());
        return curriculumPreviewDTO;
    }

    @Override
    public CurriculumPreviewDTO convert(final Curriculum curriculum) {
        return convert(curriculum, new CurriculumPreviewDTO());
    }
}
