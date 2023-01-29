package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.QuestionRepository;
import edu.cs.tcu.chineselearningplatform.entity.Lesson;
import edu.cs.tcu.chineselearningplatform.entity.Question;
import edu.cs.tcu.chineselearningplatform.entity.Vocab;
import org.bson.types.ObjectId;
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

    public Question findByObjectId(String id) {
        return questionRepository.findByObjectId(new ObjectId(id));
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
     * @param question to be updated.
     * @return Result object that contains flag, status code, message.
     */
    public void update(String questionId, Question updatedQuestion) {
        updatedQuestion.setId(questionId);
        questionRepository.save(updatedQuestion);

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
