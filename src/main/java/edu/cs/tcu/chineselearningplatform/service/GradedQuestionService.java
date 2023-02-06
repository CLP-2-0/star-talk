package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.AnswerRepository;
import edu.cs.tcu.chineselearningplatform.dao.GradedQuestionRepository;
import edu.cs.tcu.chineselearningplatform.entity.Answer;
import edu.cs.tcu.chineselearningplatform.entity.GradedQuestion;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public void saveAnswerToAQuestion(Answer answer, String username, String questionId) {
        answerRepository.save(answer);
        GradedQuestion question = findGradedQuestion(questionId);
        question.addAnswer(username, answer.getId());
        gradedQuestionRepository.save(question);
    }

    public List<String> getAllAnswerForAQuestion(String questionId) {
        GradedQuestion question = findGradedQuestion(questionId);
        Map answerMap = question.getAnswersMap();
        List<String> list = new ArrayList<>();
        answerMap.forEach((k, v) -> {
            String username = k.toString().split("-")[1];
            Answer answer = answerRepository.findByObjectId(new ObjectId(v.toString()));
            list.add(username + "_" + answer.getType() + "_" + answer.getKey());
        });
        return list;
    }
}

