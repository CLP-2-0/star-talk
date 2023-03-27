package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.TopicRepository;
import edu.cs.tcu.chineselearningplatform.entity.ForumTopic;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TopicServiceTest {

    @Mock
    private TopicRepository topicRepository;

    @InjectMocks
    private TopicService topicService;

    @Test
    public void testFindAll() {

    }

    @Test
    public void testFindTopicById() {

    }

    @Test
    public void testCreateTopic() {
        // Arrange
    }

//    @Test
//    public void testUpdateTopic() {
//        String topicId = "someTopicId";
//        ForumTopic updatedTopic = new ForumTopic();
//        updatedTopic.setTitle("Updated Topic Title");
//        updatedTopic.setContent("Updated Topic Content");
//        topicService.updateTopic(topicId, updatedTopic);
//
//        ForumTopic topic = (ForumTopic) topicService.findTopicById(topicId);
//        assertEquals("Updated Topic Title", topic.getTitle());
//        assertEquals("Updated Topic Content", topic.getContent());
//        // add any additional assertions as needed
//    }

    @Test
    public void testDelete() {
        // Arrange

    }
}
