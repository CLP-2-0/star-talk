package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.TopicAnswerRepository;
import edu.cs.tcu.chineselearningplatform.dao.TopicRepository;
import edu.cs.tcu.chineselearningplatform.dao.UserRepository;
import edu.cs.tcu.chineselearningplatform.entity.ForumTopic;
import edu.cs.tcu.chineselearningplatform.entity.TopicAnswer;
import edu.cs.tcu.chineselearningplatform.entity.User;
import org.springframework.stereotype.Service;

@Service
public class TopicAnswerService {

    private TopicRepository topicRepository;
    private TopicAnswerRepository topicAnswerRepository;
    private UserRepository userRepository;


    public TopicAnswerService(TopicRepository topicRepository, TopicAnswerRepository topicAnswerRepository, UserRepository userRepository) {
        this.topicRepository = topicRepository;
        this.topicAnswerRepository = topicAnswerRepository;
        this.userRepository = userRepository;
    }

    public void createAnswer(String topicId, TopicAnswer answer, String username) {
        ForumTopic topic = topicRepository.findById(topicId).get();
        User answerCreator = userRepository.findByUsername(username);
        answer.setAnswerCreator(answerCreator);
        topic.addAnswer(answer);
        topicRepository.save(topic);
        topicAnswerRepository.save(answer);

    }
}
