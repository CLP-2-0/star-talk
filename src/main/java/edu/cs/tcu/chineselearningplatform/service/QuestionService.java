package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.QuestionRepository;
import edu.cs.tcu.chineselearningplatform.entity.Question;
import org.bson.types.ObjectId;


import java.util.List;

public class QuestionService {
    private QuestionRepository questionRepository;


    public QuestionService(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    /**
     * Method to find one question.
     * @param id of the question to be sought.
     * @return Result object that contains flag, status code, message, and found homework.
     */
    public Question findByObjectId(String id) {
        return questionRepository.findByObjectId(new ObjectId(id));
    }

    /**
     * Method to save one question.
     * @param question to be saved.
     * @return Result object that contains flag, status code, message.
     */
    public void save(Question newQuestion) {
        questionRepository.save(newQuestion);
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
     * @param lessonId
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
        Question question = questionRepository.findByObjectId(new ObjectId(questionId));
        questionRepository.delete(question);
    }

}
