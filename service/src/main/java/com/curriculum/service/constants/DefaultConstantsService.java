package com.curriculum.service.constants;

import com.curriculum.domain.constants.Constants;
import com.curriculum.exception.ContentNotFoundException;
import com.curriculum.persistence.constants.ConstantsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("defaultConstantsService")
public class DefaultConstantsService implements ConstantsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultConstantsService.class);

    @Autowired
    @Qualifier("constantsRepository")
    private ConstantsRepository constantsRepository;

    @Override
    public Page<Constants> findAll(final Pageable pageable) {
        LOGGER.info("DefaultConstantsFacade.findAll()");
        final Page<Constants> page = constantsRepository.findAll(pageable);
        LOGGER.info("DefaultConstantsFacade.findAll() finished");
        return page;
    }

    @Override
    public Constants find(final String id) {
        LOGGER.info("DefaultConstantsFacade.find(), id={}", id);
        final Constants constants = constantsRepository.findOne(id);
        if (constants == null) {
            final String message = "Constants not found";
            LOGGER.error("DefaultConstantsFacade.find(), id={}, message={}", id, message);
            throw new ContentNotFoundException(message);
        }
        LOGGER.info("DefaultConstantsFacade.find() finished");
        return constants;
    }

    @Override
    public void save(final Constants constants) {
        LOGGER.info("DefaultConstantsFacade.save()");
        constantsRepository.save(constants);
        LOGGER.info("DefaultConstantsFacade.save() finished");
    }
}
