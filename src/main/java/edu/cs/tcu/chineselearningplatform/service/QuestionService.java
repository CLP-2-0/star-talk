package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.QuestionRepository;
import edu.cs.tcu.chineselearningplatform.entity.Lesson;
import edu.cs.tcu.chineselearningplatform.entity.Question;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;
    private LessonService lessonService;


    public QuestionService(QuestionRepository questionRepository, LessonService lessonService){

        this.questionRepository = questionRepository;
        this.lessonService = lessonService;
    }

    /**
     * Method to find one question.
     * @param id of the question to be sought.
     * @return Result object that contains flag, status code, message, and found homework.
     */
    public Question findById(String id) {
        return questionRepository.findById(id).get();
    }

    public List<Question> findAllByLesson(String lessonId) {
        return questionRepository.findAllByLesson(lessonId);
    }


    /**
     * Method to save one question.
     * @param question to be saved.
     * @return Result object that contains flag, status code, message.
     */
    public void save(Question newQuestion, String lessonId) {
        Lesson lesson = lessonService.findById(lessonId);
        lesson.addQuestion(newQuestion);
        System.out.println(lessonId);
        questionRepository.save(newQuestion);
        lessonService.save(lesson);
    }

    public void saveExamQuestion(Question newQuestion, String lessonId) {
        Lesson lesson = lessonService.findById(lessonId);
        lesson.addEQuestion(newQuestion);
        System.out.println(lessonId);
        questionRepository.save(newQuestion);
        lessonService.save(lesson);
    }

    /**
     * Method to find all homework.
     * @param
     * @return Result object that contains flag, status code, message, and found lesson.
     */
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    /**
     * Method to update one question.
     *
     * @param question to be updated.
     * @return Result object that contains flag, status code, message.
     */
    public Question update(String questionId, Question updatedQuestion) {
        updatedQuestion.setId(questionId);
        questionRepository.save(updatedQuestion);

        return updatedQuestion;
    }

    /**
     * Method to delete one question.
     * @param question to be deleted.
     * @return Result object that contains flag, status code, message.
     */
    public void delete(String questionId) {
        Question question = questionRepository.findById(questionId).get();
        questionRepository.delete(question);
    }

}