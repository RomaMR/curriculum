package com.curriculum.facade.constants;

import com.curriculum.domain.constants.Constants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ConstantsFacade {
    Page<Constants> findAll(Pageable pageable);

    void save(Constants constants);

    Constants find(String id);
}
