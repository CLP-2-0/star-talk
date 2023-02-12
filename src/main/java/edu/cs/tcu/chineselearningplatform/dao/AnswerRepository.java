package edu.cs.tcu.chineselearningplatform.dao;

import edu.cs.tcu.chineselearningplatform.entity.Answer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AnswerRepository extends MongoRepository<Answer, String> {
    @Query("{ '_id': ?0}")
    Answer findByObjectId(ObjectId id);
}
