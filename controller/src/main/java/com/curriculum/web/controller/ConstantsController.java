package com.curriculum.web.controller;

import com.curriculum.domain.constants.Constants;
import com.curriculum.facade.constants.ConstantsFacade;
import com.curriculum.web.config.API;
import com.curriculum.web.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(API.Constants.ROOT)
public class ConstantsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConstantsController.class);

    @Autowired
    @Qualifier("defaultConstantsFacade")
    private ConstantsFacade constantsFacade;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Constants> find(@PathVariable("id") String id) {
        LOGGER.info("ConstantsController.find()");
        final Constants constants = constantsFacade.find(id);
        LOGGER.info("ConstantsController.find() finished");
        return new ResponseEntity(constants, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Constants> findAll(@RequestParam(value = "offset", required = false) final Integer offset,
                                                     @RequestParam(value = "limit", required = false) final Integer limit) {
        LOGGER.info("ConstantsController.findAll(), offset={},limit={}", offset, limit);
        final Pageable pageable = PaginationUtil.generatePageRequest(offset, limit);
        final Page<Constants> page = constantsFacade.findAll(pageable);
        LOGGER.info("ConstantsController.findAll() finished");
        return new ResponseEntity(page, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody Constants constants) {
        LOGGER.info("ConstantsController.save()");
        constantsFacade.save(constants);
        LOGGER.info("ConstantsController.save() finished");
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
