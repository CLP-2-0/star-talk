package edu.cs.tcu.chineselearningplatform.dao;

import edu.cs.tcu.chineselearningplatform.entity.Course;
import edu.cs.tcu.chineselearningplatform.entity.Vocab;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface VocabRepository extends MongoRepository<Vocab, String> {
    @Query("{ '_id': ?0}")
    Vocab findByObjectId(ObjectId id);
}
