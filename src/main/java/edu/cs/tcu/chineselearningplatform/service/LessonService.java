package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.LessonRepository;
import edu.cs.tcu.chineselearningplatform.entity.Lesson;
import org.springframework.stereotype.Service;

import java.util.List;
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
    /**
     * Method to find all lesson.
     * @param
     * @return Result object that contains flag, status code, message, and found lesson.
     */
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }
    /**
     * Method to update one lesson.
     * @param lesson to be updated.
     * @return Result object that contains flag, status code, message.
     */
    public void update(String lessonId, Lesson updatedLesson) {
        Lesson lesson = lessonRepository.findById(lessonId).get();
        lesson.setId(lessonId);
        lesson.setTitle(updatedLesson.getTitle());
        lesson.setContent(updatedLesson.getContent());
        System.out.println(lesson.getContent());
        lessonRepository.save(lesson);

    }
    /**
     * Method to delte one lesson.
     * @param lesson to be deleted.
     * @return Result object that contains flag, status code, message.
     */
    public void delete(String lessonId) {
        lessonRepository.deleteById(lessonId);
    }
}
