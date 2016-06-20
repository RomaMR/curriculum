package com.curriculum.persistence.curriculum;


import com.curriculum.domain.cirriculum.Curriculum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;


public interface CurriculumRepository extends MongoRepository<Curriculum, String>, QueryDslPredicateExecutor<Curriculum> {


}
