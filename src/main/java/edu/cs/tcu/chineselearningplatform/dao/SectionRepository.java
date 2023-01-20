package edu.cs.tcu.chineselearningplatform.dao;

import edu.cs.tcu.chineselearningplatform.entity.Section;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface SectionRepository extends MongoRepository<Section, String> {
    @Query("{ '_id': ?0}")
    Section findByObjectId(ObjectId id);
}
