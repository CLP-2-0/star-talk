package edu.tcu.chineselearningplatform.dao;

import edu.tcu.chineselearningplatform.entity.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {
}
