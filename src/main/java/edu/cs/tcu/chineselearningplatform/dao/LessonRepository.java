package edu.cs.tcu.chineselearningplatform.dao;

import edu.cs.tcu.chineselearningplatform.entity.Lesson;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LessonRepository extends MongoRepository<Lesson, String> {
}
