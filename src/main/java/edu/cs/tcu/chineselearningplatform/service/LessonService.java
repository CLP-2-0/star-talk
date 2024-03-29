package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.GradedQuestionRepository;
import edu.cs.tcu.chineselearningplatform.dao.HomeworkRepository;
import edu.cs.tcu.chineselearningplatform.dao.LessonRepository;
import edu.cs.tcu.chineselearningplatform.entity.*;
import edu.cs.tcu.chineselearningplatform.entity.util.StatusCode;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LessonService {
    private LessonRepository lessonRepository;
    private GradedQuestionRepository gradedQuestionRepository;
    private HomeworkRepository homeworkRepository;

    public LessonService(LessonRepository lessonRepository, GradedQuestionRepository gradedQuestionRepository, HomeworkRepository homeworkRepository){
        this.lessonRepository = lessonRepository;
        this.gradedQuestionRepository = gradedQuestionRepository;
        this.homeworkRepository = homeworkRepository;
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
     * Method to save all lesson.
     * @param lessons to be saved.
     * @return Result object that contains flag, status code, message.
     */
    public void saveAll(List<Lesson> lessons) {
        lessonRepository.saveAll(lessons);
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
     * @return All lessons.
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
     * Method to delete one lesson.
     * @param lesson to be deleted.
     */
    public void delete(String lessonId) {
        lessonRepository.deleteById(lessonId);
    }

    /**
     * Method to save a predefined homework to one lesson.
     * @param homework to be saved.
     */
    public void savePredefinedHomework(String lessonId, List<GradedQuestion> questions) {
        for(GradedQuestion q: questions) {
            gradedQuestionRepository.save(q);
        }
        Homework hw = new Homework();
        hw.setQuestionList(questions);
        Lesson currLesson = findById(lessonId);
        homeworkRepository.save(hw);
        currLesson.setPredefined(hw);
        lessonRepository.save(currLesson);
    }

    public void saveExam(String lessonId, List<GradedQuestion> questions) {
        for(GradedQuestion q: questions) {
            gradedQuestionRepository.save(q);
        }
        Homework exam = new Homework();
        exam.setQuestionList(questions);
        Lesson currLesson = findById(lessonId);
        homeworkRepository.save(exam);
        currLesson.setExam(exam);
        lessonRepository.save(currLesson);
    }

    public void saveGrammarMeanings(String lessonId, List<Grammar> grammars) {
        Lesson lesson = lessonRepository.findById(lessonId).get();
        lesson.setGrammars(grammars);
        lessonRepository.save(lesson);
    }

    public List<Grammar> getSavedGrammars(String lessonId) {
        Optional<Lesson> lesson = lessonRepository.findById(lessonId);
        if (lesson.isPresent()) {
            return lesson.get().getGrammars();
        }
        return new ArrayList<>();
    }
}
