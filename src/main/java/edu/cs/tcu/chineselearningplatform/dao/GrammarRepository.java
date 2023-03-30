package edu.cs.tcu.chineselearningplatform.dao;

import edu.cs.tcu.chineselearningplatform.entity.Grammar;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface GrammarRepository extends MongoRepository<Grammar, String> {
    @Query("{ '_id': ?0}")
    Grammar findByObjectId(ObjectId id);
}
