package com.curriculum.facade.curriculum;

import com.curriculum.domain.cirriculum.Curriculum;
import com.curriculum.dto.curriculum.CurriculumPreviewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CurriculumFacade {

  Curriculum find(String id);

  Curriculum save(Curriculum curriculum);

  Page<CurriculumPreviewDTO> findAllPreviews(Pageable pageable, String search);

  void update(String id, Curriculum curriculum);

  byte[] getPdf(String id) throws Exception;
}
