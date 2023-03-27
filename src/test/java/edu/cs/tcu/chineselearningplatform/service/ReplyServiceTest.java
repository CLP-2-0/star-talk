package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.ReplyRepository;
import edu.cs.tcu.chineselearningplatform.dao.TopicAnswerRepository;
import edu.cs.tcu.chineselearningplatform.dao.UserRepository;
import edu.cs.tcu.chineselearningplatform.entity.Reply;
import edu.cs.tcu.chineselearningplatform.entity.TopicAnswer;
import edu.cs.tcu.chineselearningplatform.entity.User;
import edu.cs.tcu.chineselearningplatform.service.ReplyService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ReplyServiceTest {

    @Mock
    private ReplyRepository replyRepository;

    @Mock
    private TopicAnswerRepository topicAnswerRepository;

    @Mock
    private UserRepository userRepository;

    private ReplyService replyService;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        replyService = new ReplyService(replyRepository, topicAnswerRepository, userRepository);
    }

    @Test
    public void testCreateReply() {
        // Create a dummy TopicAnswer
        TopicAnswer topicAnswer = new TopicAnswer();
        topicAnswer.setId("testAnswerId");

        // Create a dummy User
        User user = new User();
        user.setUsername("testUser");

        // Create a dummy Reply
        Reply reply = new Reply();
        reply.setContent("testContent");

        // Mock the dependencies
        when(topicAnswerRepository.findById(any())).thenReturn(java.util.Optional.of(topicAnswer));
        when(userRepository.findByUsername(any())).thenReturn(user);

        // Call the method being tested
        replyService.createReply("testAnswerId", reply, "testUser");

        // Verify that the TopicAnswer and Reply were saved
        verify(topicAnswerRepository, times(1)).save(topicAnswer);
        verify(replyRepository, times(1)).save(reply);

        // Verify that the Reply was added to the TopicAnswer
        assert(topicAnswer.getReplies().contains(reply));
    }
}
