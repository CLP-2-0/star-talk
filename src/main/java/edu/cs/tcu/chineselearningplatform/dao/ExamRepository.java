package edu.cs.tcu.chineselearningplatform.dao;

import edu.cs.tcu.chineselearningplatform.entity.Exam;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ExamRepository extends MongoRepository<Exam, String> {
    @Query("{ '_id': ?0}")
    Exam findByObjectId(ObjectId id);
}
