package edu.cs.tcu.chineselearningplatform.dao;

import edu.cs.tcu.chineselearningplatform.entity.Question;
import edu.cs.tcu.chineselearningplatform.entity.Vocab;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

public interface QuestionRepository extends MongoRepository<Question, String> {
    @Query("{ '_id': ?0}")
    Question findByObjectId(ObjectId id);
}
