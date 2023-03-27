package edu.cs.tcu.chineselearningplatform.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TopicAnswerTest {

    private TopicAnswer topicAnswer;
    private User answerCreator;
    private ForumTopic topic;
    private List<Reply> replies;

    @BeforeEach
    public void setUp() {
        topicAnswer = new TopicAnswer();
        answerCreator = new User();
        topic = new ForumTopic();
        replies = new ArrayList<>();
    }

    @Test
    public void testGettersAndSetters() {
        String id = "1";
        String content = "This is a topic answer";
        LocalDateTime createdDate = LocalDateTime.now();
        LocalDateTime lastUpdatedDate = LocalDateTime.now();

        topicAnswer.setId(id);
        Assertions.assertEquals(id, topicAnswer.getId());

        topicAnswer.setContent(content);
        Assertions.assertEquals(content, topicAnswer.getContent());

        topicAnswer.setAnswerCreator(answerCreator);
        Assertions.assertEquals(answerCreator, topicAnswer.getAnswerCreator());

        topicAnswer.setTopic(topic);
        Assertions.assertEquals(topic, topicAnswer.getTopic());

        topicAnswer.setReplies(replies);
        Assertions.assertEquals(replies, topicAnswer.getReplies());

        topicAnswer.setCreatedDate(createdDate);
        Assertions.assertEquals(createdDate, topicAnswer.getCreatedDate());

        topicAnswer.setLastUpdatedDate(lastUpdatedDate);
        Assertions.assertEquals(lastUpdatedDate, topicAnswer.getLastUpdatedDate());
    }

    @Test
    public void testAddReply() {
        Reply reply = new Reply();
        topicAnswer.addReply(reply);
        Assertions.assertTrue(topicAnswer.getReplies().contains(reply));
        Assertions.assertEquals(topicAnswer, reply.getTopicAnswer());
    }

    @Test
    public void testRemoveReply() {
        Reply reply = new Reply();
        topicAnswer.addReply(reply);
        Assertions.assertTrue(topicAnswer.getReplies().contains(reply));

        topicAnswer.removeReply(reply);
        Assertions.assertFalse(topicAnswer.getReplies().contains(reply));
        Assertions.assertNull(reply.getTopicAnswer());
    }
}
