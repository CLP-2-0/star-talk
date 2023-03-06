package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.TopicAnswerRepository;
import edu.cs.tcu.chineselearningplatform.dao.TopicRepository;
import edu.cs.tcu.chineselearningplatform.entity.ForumTopic;
import edu.cs.tcu.chineselearningplatform.entity.Section;
import edu.cs.tcu.chineselearningplatform.entity.TopicAnswer;
import edu.cs.tcu.chineselearningplatform.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    private TopicRepository topicRepository;
    private TopicAnswerRepository topicAnswerRepository;
    private TopicAnswerService topicAnswerService;

    public TopicService(TopicRepository topicRepository, TopicAnswerRepository topicAnswerRepository, TopicAnswerService topicAnswerService) {
        this.topicRepository = topicRepository;
        this.topicAnswerRepository = topicAnswerRepository;
        this.topicAnswerService = topicAnswerService;
    }

    public List<ForumTopic> findAll() {
        return topicRepository.findAll();
    }

    public Object findTopicById(String topicId) {
        return topicRepository.findById(topicId).get();
    }

    public void createTopic(ForumTopic newTopic) {
        topicRepository.save(newTopic);
    }

    public void updateTopic(String topicId, ForumTopic updatedTopic) {
        ForumTopic topic = topicRepository.findById(topicId).get();
        topic.setId(topicId);
        topic.setTitle(updatedTopic.getTitle());
        topic.setContent(updatedTopic.getContent());
        topicRepository.save(topic);
    }

    public void delete(String topicId) {
        topicRepository.deleteById(topicId);
    }

    public void createAnswer(String topicId, TopicAnswer newAnswer) {
        ForumTopic topic = topicRepository.findById(topicId).get();

        List<TopicAnswer> answers = topic.getTopicAnswer();
        answers.add(newAnswer);

        topic.setTopicAnswer(answers);
        topicRepository.save(topic);

    }

    public List<TopicAnswer> findAllAnswersByTopicId(String topicId) {
        return topic.findByUsername(username).getSections();
    }
}
