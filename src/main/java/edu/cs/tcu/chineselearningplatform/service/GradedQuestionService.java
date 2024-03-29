package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.AnswerRepository;
import edu.cs.tcu.chineselearningplatform.dao.GradedQuestionRepository;
import edu.cs.tcu.chineselearningplatform.entity.Answer;
import edu.cs.tcu.chineselearningplatform.entity.GradedQuestion;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;
import java.sql.Timestamp;
import java.io.IOException;
import java.util.List;

@Service
public class GradedQuestionService {
    private GradedQuestionRepository gradedQuestionRepository;
    private AnswerRepository answerRepository;

    public GradedQuestionService(GradedQuestionRepository gradedQuestionRepository, AnswerRepository answerRepository){
        this.gradedQuestionRepository = gradedQuestionRepository;
        this.answerRepository = answerRepository;
    }

    public GradedQuestion findGradedQuestion(String id) {
        GradedQuestion question = gradedQuestionRepository.findByObjectId(new ObjectId(id));
        return question;
    }

    public void saveAnswerToAQuestion(Answer answer, String username, String questionId) throws IOException, GeneralSecurityException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        answer.setUsername(timestamp.getTime() + "_" +username);

        answerRepository.save(answer);
        GradedQuestion question = findGradedQuestion(questionId);
        question.addAnswer(answer);
        gradedQuestionRepository.save(question);
    }

    public List<Answer> getAllAnswerForAQuestion(String questionId) {
        GradedQuestion question = findGradedQuestion(questionId);

        return question.getAnswerList();
    }

    public void saveCommentToAnAnswer(String comment, String username, String answerId) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(comment);

        comment = timestamp.getTime() + "_" +username+ "_"+comment;
        Answer a = answerRepository.findById(answerId).get();
        a.addComment(comment);
        answerRepository.save(a);

    }

    public List<String> getAllCommentsForAnAnswer(String answerId) {
        Answer a = answerRepository.findById(answerId).get();
        return a.getCommentList();
    }
}
