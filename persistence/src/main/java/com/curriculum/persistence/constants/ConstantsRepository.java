package com.curriculum.persistence.constants;

import com.curriculum.domain.constants.Constants;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ConstantsRepository extends MongoRepository<Constants, String>, QueryDslPredicateExecutor<Constants> {
}
