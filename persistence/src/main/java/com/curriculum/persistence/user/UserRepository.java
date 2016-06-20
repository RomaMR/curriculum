package com.curriculum.persistence.user;


import com.curriculum.domain.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface UserRepository extends MongoRepository<User, String>, QueryDslPredicateExecutor<User> {

    Long countByEmail(String email);

    User findByEmail(String email);

}