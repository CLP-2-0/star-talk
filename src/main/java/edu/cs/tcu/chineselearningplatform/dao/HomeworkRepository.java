package edu.cs.tcu.chineselearningplatform.dao;

import edu.cs.tcu.chineselearningplatform.entity.Homework;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface HomeworkRepository extends MongoRepository<Homework, String> {
    @Query("{ '_id': ?0}")
    Homework findByObjectId(ObjectId id);

    @Query("{'section': ?0}")
    List<Homework> findAllBySection(String SectionId);

}
