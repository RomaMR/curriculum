package com.curriculum.web.controller;

import com.curriculum.domain.cirriculum.Curriculum;
import com.curriculum.dto.curriculum.CurriculumPreviewDTO;
import com.curriculum.facade.curriculum.CurriculumFacade;
import com.curriculum.web.config.API;
import com.curriculum.web.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(API.Curriculum.ROOT)
public class CurriculumController {
  private static final Logger LOGGER = LoggerFactory.getLogger(CurriculumController.class);

  @Autowired
  @Qualifier("defaultCurriculumFacade")
  private CurriculumFacade curriculumFacade;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Curriculum> find(@PathVariable("id") String id) {
    LOGGER.info("CurriculumController.find(), id = {}", id);
    final Curriculum curriculum = curriculumFacade.find(id);
    LOGGER.info("CurriculumController.find() finished");
    return new ResponseEntity(curriculum, HttpStatus.OK);
  }

  @RequestMapping(value = "/{id}/pdf", method = RequestMethod.GET, produces = "application/pdf")
  public ResponseEntity<byte[]> getPdf(@PathVariable("id") String id) throws Exception {
    LOGGER.info("CurriculumController.getPdf(), id = {}", id);
    final byte[] pdf = curriculumFacade.getPdf(id);
    final HttpHeaders headers = new HttpHeaders();
    headers.add("content-disposition", "attachment; filename=" + id + ".pdf");
    LOGGER.info("CurriculumController.getPdf() finished");
    return new ResponseEntity(pdf, headers, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Page<CurriculumPreviewDTO>> findAllPreviews(
          @RequestParam(value = "offset", required = false) final Integer offset,
          @RequestParam(value = "limit", required = false) final Integer limit,
          @RequestParam(value = "search", required = false) final String search) {

    LOGGER.info("CurriculumController.findAllPreviews(), offset={}, limit={}, search={}", offset, limit, search);
    final Pageable pageable = PaginationUtil.generatePageRequest(offset, limit);
    final Page<CurriculumPreviewDTO> page = curriculumFacade.findAllPreviews(pageable, search);
    LOGGER.info("CurriculumController.findAllPreviews() finished");
    return new ResponseEntity(page, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Curriculum> save(@RequestBody Curriculum curriculum) {
    LOGGER.info("CurriculumController.save()");
    final Curriculum persistentCurriculum = curriculumFacade.save(curriculum);
    LOGGER.info("CurriculumController.save() finished");
    return new ResponseEntity(persistentCurriculum, HttpStatus.CREATED);
  }

  @RequestMapping(value = API.ID, method = RequestMethod.PATCH)
  public ResponseEntity update(@PathVariable("id") String id, @RequestBody Curriculum curriculum) {
    LOGGER.info("CurriculumController.update(), id={}", id);
    curriculumFacade.update(id, curriculum);
    LOGGER.info("CurriculumController.update() finished");
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }
}
