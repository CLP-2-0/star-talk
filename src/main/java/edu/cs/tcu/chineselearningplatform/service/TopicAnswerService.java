package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.TopicAnswerRepository;
import edu.cs.tcu.chineselearningplatform.dao.TopicRepository;
import edu.cs.tcu.chineselearningplatform.dao.UserRepository;
import edu.cs.tcu.chineselearningplatform.entity.ForumTopic;
import edu.cs.tcu.chineselearningplatform.entity.TopicAnswer;
import edu.cs.tcu.chineselearningplatform.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TopicAnswerService {

    private TopicRepository topicRepository;
    private TopicAnswerRepository topicAnswerRepository;



    public TopicAnswerService(TopicRepository topicRepository, TopicAnswerRepository topicAnswerRepository) {
        this.topicRepository = topicRepository;
        this.topicAnswerRepository = topicAnswerRepository;
    }

    public void createAnswer(String topicId, TopicAnswer answer) {
        ForumTopic topic = topicRepository.findById(topicId).get();
        topic.addAnswer(answer);
        topicRepository.save(topic);
        topicAnswerRepository.save(answer);
    }
}
