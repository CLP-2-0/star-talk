package edu.cs.tcu.chineselearningplatform.dao;

import edu.cs.tcu.chineselearningplatform.entity.QuestionBank;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface QuestionBankRepository extends MongoRepository<QuestionBank, String> {
    @Query("{ '_id': ?0}")
    QuestionBank findByObjectId(ObjectId id);
}
