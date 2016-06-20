package com.curriculum.facade.constants;

import com.curriculum.domain.constants.Constants;
import com.curriculum.service.constants.ConstantsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component("defaultConstantsFacade")
public class DefaultConstantsFacade implements ConstantsFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultConstantsFacade.class);

    @Autowired
    @Qualifier("defaultConstantsService")
    private ConstantsService constantsService;

    @Override
    public Constants find(final String id) {
        LOGGER.info("DefaultConstantsFacade.find(), id={}", id);
        final Constants constants = constantsService.find(id);
        LOGGER.info("DefaultConstantsFacade.find() finished");
        return constants;
    }

    @Override
    public Page<Constants> findAll(final Pageable pageable) {
        LOGGER.info("DefaultConstantsFacade.findAll()");
        final Page<Constants> page = constantsService.findAll(pageable);
        LOGGER.info("DefaultConstantsFacade.findAll() finished");
        return page;
    }

    @Override
    public void save(final Constants constants) {
        LOGGER.info("DefaultConstantsFacade.save()");
        constantsService.save(constants);
        LOGGER.info("DefaultConstantsFacade.save() finished");
    }

}
