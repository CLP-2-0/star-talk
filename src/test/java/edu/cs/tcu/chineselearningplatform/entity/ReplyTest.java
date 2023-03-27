package edu.cs.tcu.chineselearningplatform.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ReplyTest {

    @Test
    public void testSetAndGetId() {
        Reply reply = new Reply();
        assertNull(reply.getId());
        reply.setId("1");
        assertEquals("1", reply.getId());
    }

    @Test
    public void testSetAndGetContent() {
        Reply reply = new Reply();
        assertNull(reply.getContent());
        reply.setContent("Content");
        assertEquals("Content", reply.getContent());
    }

    @Test
    public void testSetAndGetReplyCreator() {
        Reply reply = new Reply();
        assertNull(reply.getReplyCreator());
        User user = new User();
        user.setUsername("testuser");
        reply.setReplyCreator(user);
        assertEquals(user, reply.getReplyCreator());
    }

    @Test
    public void testSetAndGetTopicAnswer() {
        Reply reply = new Reply();
        assertNull(reply.getTopicAnswer());
        TopicAnswer topicAnswer = new TopicAnswer();
        reply.setTopicAnswer(topicAnswer);
        assertEquals(topicAnswer, reply.getTopicAnswer());
    }

    @Test
    public void testSetAndGetCreatedDate() {
        Reply reply = new Reply();
        assertNull(reply.getCreatedDate());
        LocalDateTime createdDate = LocalDateTime.of(2022, 3, 20, 10, 30);
        reply.setCreatedDate(createdDate);
        assertEquals(createdDate, reply.getCreatedDate());
    }

    @Test
    public void testSetAndGetLastUpdateDate() {
        Reply reply = new Reply();
        assertNull(reply.getLastUpdateDate());
        LocalDateTime lastUpdateDate = LocalDateTime.of(2022, 3, 20, 11, 30);
        reply.setLastUpdateDate(lastUpdateDate);
        assertEquals(lastUpdateDate, reply.getLastUpdateDate());
    }

}
