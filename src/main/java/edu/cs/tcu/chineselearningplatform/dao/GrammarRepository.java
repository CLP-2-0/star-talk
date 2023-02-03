package edu.cs.tcu.chineselearningplatform.dao;

import edu.cs.tcu.chineselearningplatform.entity.Grammar;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface GrammarRepository extends MongoRepository<Grammar, String> {
    @Query("{ '_id': ?0}")
    Grammar findByObjectId(ObjectId id);

    @Query("{'lesson': ?0")
    List<Grammar> findAllbyLesson(String LessonId);

}
