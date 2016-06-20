package com.curriculum.persistence.token;

import com.curriculum.domain.token.Token;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface TokenRepository extends MongoRepository<Token, String>, QueryDslPredicateExecutor<Token> {
    Token findByUserId(final String userId);

    Long deleteByUserId(final String userId);
}
