package edu.cs.tcu.chineselearningplatform.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import edu.cs.tcu.chineselearningplatform.dao.TopicAnswerRepository;
import edu.cs.tcu.chineselearningplatform.dao.TopicRepository;
import edu.cs.tcu.chineselearningplatform.dao.UserRepository;
import edu.cs.tcu.chineselearningplatform.entity.ForumTopic;
import edu.cs.tcu.chineselearningplatform.entity.TopicAnswer;
import edu.cs.tcu.chineselearningplatform.entity.User;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TopicAnswerServiceTest {

    @Mock
    private TopicRepository topicRepository;

    @Mock
    private TopicAnswerRepository topicAnswerRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TopicAnswerService topicAnswerService;

    @Test
    public void testCreateAnswer() {
        // Given
        String topicId = "1";
        String username = "testuser";
        ForumTopic topic = new ForumTopic();
        given(topicRepository.findById(anyString())).willReturn(Optional.of(topic));
        given(userRepository.findByUsername(anyString())).willReturn(new User());
        given(topicRepository.save(any(ForumTopic.class))).willReturn(topic);
        given(topicAnswerRepository.save(any(TopicAnswer.class))).willReturn(new TopicAnswer());

        // When
        topicAnswerService.createAnswer(topicId, new TopicAnswer(), username);

        // Then
        verify(topicRepository).findById(topicId);
        verify(userRepository).findByUsername(username);
        verify(topicAnswerRepository).save(any(TopicAnswer.class));
        verify(topicRepository).save(topic);
    }
}
