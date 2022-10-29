package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.LessonRepository;
import edu.cs.tcu.chineselearningplatform.entity.Lesson;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LessonService {
    private LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository){
        this.lessonRepository = lessonRepository;
    }

    /**
     * Method to find one lesson.
     * @param id of the lesson to be sought.
     * @return Result object that contains flag, status code, message, and found course.
     */
    public Lesson findById(String id) {
        return lessonRepository.findById(id).get();
    }

    /**
     * Method to save one lesson.
     * @param lesson to be saved.
     * @return Result object that contains flag, status code, message.
     */
    public void save(Lesson newLesson) {
        lessonRepository.save(newLesson);
    }

}
