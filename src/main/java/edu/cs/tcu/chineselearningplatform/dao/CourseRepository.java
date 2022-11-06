package edu.cs.tcu.chineselearningplatform.dao;

import edu.cs.tcu.chineselearningplatform.entity.Course;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface CourseRepository extends MongoRepository<Course, String> {
    @Query("{ '_id': ?0}")
    Course findByObjectId(ObjectId id);
}
