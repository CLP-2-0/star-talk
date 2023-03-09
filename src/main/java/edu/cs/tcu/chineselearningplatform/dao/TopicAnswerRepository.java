package edu.cs.tcu.chineselearningplatform.dao;

import edu.cs.tcu.chineselearningplatform.entity.TopicAnswer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TopicAnswerRepository extends MongoRepository<TopicAnswer, String> {
}
