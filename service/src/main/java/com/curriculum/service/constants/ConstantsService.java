package com.curriculum.service.constants;

import com.curriculum.domain.constants.Constants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ConstantsService {
    Page<Constants> findAll(Pageable pageable);

    Constants find(String id);

    void save(Constants constants);
}
