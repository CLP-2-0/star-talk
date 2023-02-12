package edu.cs.tcu.chineselearningplatform.dao;

import edu.cs.tcu.chineselearningplatform.entity.GradedQuestion;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface GradedQuestionRepository extends MongoRepository<GradedQuestion, String> {
    @Query("{ '_id': ?0}")
    GradedQuestion findByObjectId(ObjectId id);
}
