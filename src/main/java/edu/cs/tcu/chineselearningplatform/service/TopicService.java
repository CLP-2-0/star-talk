package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.SectionRepository;
import edu.cs.tcu.chineselearningplatform.dao.TopicAnswerRepository;
import edu.cs.tcu.chineselearningplatform.dao.TopicRepository;
import edu.cs.tcu.chineselearningplatform.entity.ForumTopic;
import edu.cs.tcu.chineselearningplatform.entity.Section;
import edu.cs.tcu.chineselearningplatform.entity.TopicAnswer;
import edu.cs.tcu.chineselearningplatform.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    private TopicRepository topicRepository;
    private SectionRepository sectionRepository;

    public TopicService(TopicRepository topicRepository, SectionRepository sectionRepository) {
        this.topicRepository = topicRepository;
        this.sectionRepository = sectionRepository;
    }

    public List<ForumTopic> findAll() {
        return topicRepository.findAll();
    }

    public Object findTopicById(String topicId) {
        return topicRepository.findById(topicId).get();
    }

    public void createTopic(ForumTopic newTopic, String sectionId) {
        newTopic.setBelongSection(sectionId);
        topicRepository.save(newTopic);
    }

    public void updateTopic(String topicId, ForumTopic updatedTopic) {
        ForumTopic topic = topicRepository.findById(topicId).get();
        topic.setId(topicId);
        topic.setTitle(updatedTopic.getTitle());
        topic.setContent(updatedTopic.getContent());
        topic.setReplyCount(updatedTopic.getReplyCount());
        topic.setUserActive(updatedTopic.getUserActive());
        topicRepository.save(topic);
    }

    public void delete(String topicId) {
        topicRepository.deleteById(topicId);
    }

}
