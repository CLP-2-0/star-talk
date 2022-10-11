package edu.tcu.chineselearningplatform.dao;

import edu.tcu.chineselearningplatform.entity.Homework;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HomeworkRepository extends MongoRepository<Homework, String> {
}
