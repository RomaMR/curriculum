package com.curriculum.web.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PaginationUtil {

    public static final int DEFAULT_PAGE = 1;

    public static final int MIN_PAGE = 1;

    public static final int DEFAULT_LIMIT = 20;

    public static final int MAX_LIMIT = Integer.MAX_VALUE;

    public static Pageable generatePageRequest(Integer offset, Integer limit) {

        if (offset == null || offset < MIN_PAGE) {
            offset = DEFAULT_PAGE;
        }
        if (limit == null || limit <= 0 || limit > MAX_LIMIT) {
            limit = DEFAULT_LIMIT;
        }
        return new PageRequest(offset - 1, limit);
    }

}