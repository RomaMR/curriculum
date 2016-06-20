package com.curriculum.service.curriculum;

import com.curriculum.domain.cirriculum.Curriculum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CurriculumService {

   Page<Curriculum> findAll(Pageable pageable, String search);

   Curriculum save(Curriculum curriculum);

   Curriculum find(String id);
}
