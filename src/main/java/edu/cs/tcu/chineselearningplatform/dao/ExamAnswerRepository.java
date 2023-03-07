package edu.cs.tcu.chineselearningplatform.dao;

import edu.cs.tcu.chineselearningplatform.entity.ExamAnswer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExamAnswerRepository extends MongoRepository<ExamAnswer, String> {

}
