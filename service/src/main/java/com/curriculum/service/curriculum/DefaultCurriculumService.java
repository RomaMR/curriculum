package com.curriculum.service.curriculum;

import com.curriculum.domain.cirriculum.Curriculum;
import com.curriculum.domain.cirriculum.QCurriculum;
import com.curriculum.exception.ContentNotFoundException;
import com.curriculum.persistence.curriculum.CurriculumRepository;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service("defaultCurriculumService")
public class DefaultCurriculumService implements CurriculumService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultCurriculumService.class);

    @Autowired
    @Qualifier("curriculumRepository")
    private CurriculumRepository curriculumRepository;

    @Override
    public Page<Curriculum> findAll(final Pageable pageable, final String search) {
        LOGGER.info("DefaultCurriculumService.findAll()");

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (StringUtils.isNotBlank(search)) {
            final QCurriculum qCurriculum = QCurriculum.curriculum;
            booleanBuilder.or(qCurriculum.name.containsIgnoreCase(search));
            booleanBuilder.or(qCurriculum.knowledgeBranch.containsIgnoreCase(search));
            booleanBuilder.or(qCurriculum.trainingDirection.containsIgnoreCase(search));
            booleanBuilder.or(qCurriculum.specialty.containsIgnoreCase(search));
            booleanBuilder.or(qCurriculum.faculty.containsIgnoreCase(search));
            booleanBuilder.or(qCurriculum.qualificationLevel.containsIgnoreCase(search));
        }

        final Predicate predicate = booleanBuilder.getValue();
        final Page<Curriculum> page = curriculumRepository.findAll(predicate, pageable);
        LOGGER.info("DefaultCurriculumService.findAll() finished");
        return page;
    }

    @Override
    public Curriculum save(final Curriculum curriculum) {
        LOGGER.info("DefaultCurriculumService.save()");
        final Curriculum persistentCurriculum = curriculumRepository.save(curriculum);
        LOGGER.info("DefaultCurriculumService.save() finished");
        return persistentCurriculum;
    }

    @Override
    public Curriculum find(final String id) {
        LOGGER.info("DefaultCurriculumService.find(), id={}", id);
        final Curriculum curriculum = curriculumRepository.findOne(id);
        if (curriculum == null) {
            final String message = "Curriculum not found";
            LOGGER.error("DefaultCurriculumService.find(), id={}, message={}", id, message);
            throw new ContentNotFoundException(message);
        }
        LOGGER.info("DefaultCurriculumService.find() finished");
        return curriculum;
    }

}
