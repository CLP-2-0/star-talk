package edu.cs.tcu.chineselearningplatform.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.assertions.Assertions.assertFalse;
import static com.mongodb.internal.connection.tlschannel.util.Util.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class ForumTopicTest {

    @Test
    public void testSetAndGetId() {
        ForumTopic forumTopic = new ForumTopic();
        assertNull(forumTopic.getId());
        forumTopic.setId("1");
        assertEquals("1", forumTopic.getId());
    }

    @Test
    public void testSetAndGetTitle() {
        ForumTopic forumTopic = new ForumTopic();
        assertNull(forumTopic.getTitle());
        forumTopic.setTitle("Title");
        assertEquals("Title", forumTopic.getTitle());
    }

    @Test
    public void testSetAndGetContent() {
        ForumTopic forumTopic = new ForumTopic();
        assertNull(forumTopic.getContent());
        forumTopic.setContent("Content");
        assertEquals("Content", forumTopic.getContent());
    }

    @Test
    public void testSetAndGetReplyCount() {
        ForumTopic forumTopic = new ForumTopic();
        assertNull(forumTopic.getReplyCount());
        forumTopic.setReplyCount(10);
        assertEquals(10, forumTopic.getReplyCount());
    }

    @Test
    public void testSetAndGetUserActive() {
        ForumTopic forumTopic = new ForumTopic();
        assertNull(forumTopic.getUserActive());
        forumTopic.setUserActive(5);
        assertEquals(5, forumTopic.getUserActive());
    }

    @Test
    public void testSetAndGetCreatedDate() {
        ForumTopic forumTopic = new ForumTopic();
        assertNull(forumTopic.getCreatedDate());
        LocalDateTime createdDate = LocalDateTime.of(2022, 3, 20, 10, 30);
        forumTopic.setCreatedDate(createdDate);
        assertEquals(createdDate, forumTopic.getCreatedDate());
    }

    @Test
    public void testGetTopicAnswer() {
        ForumTopic topic = new ForumTopic();
        assertTrue(topic.getTopicAnswer().isEmpty());
    }

    @Test
    public void testSetTopicAnswer() {
        ForumTopic topic = new ForumTopic();
        List<TopicAnswer> answers = new ArrayList<>();
        TopicAnswer answer1 = new TopicAnswer();
        TopicAnswer answer2 = new TopicAnswer();
        answers.add(answer1);
        answers.add(answer2);

        topic.setTopicAnswer(answers);

        assertEquals(answers, topic.getTopicAnswer());
    }

    @Test
    public void testAddAnswer() {
        ForumTopic topic = new ForumTopic();
        TopicAnswer answer = new TopicAnswer();

        topic.addAnswer(answer);

        assertTrue(topic.getTopicAnswer().contains(answer));
        assertSame(topic, answer.getTopic());
    }

    @Test
    public void testRemoveAnswer() {
        ForumTopic topic = new ForumTopic();
        TopicAnswer answer = new TopicAnswer();
        topic.addAnswer(answer);

        topic.removeAnswer(answer);

        assertFalse(topic.getTopicAnswer().contains(answer));
        assertNull(answer.getTopic());
    }

     @Test
     public void testGetLastPostDate() {
        LocalDateTime lastPostDate = LocalDateTime.now();
        ForumTopic forumTopic = new ForumTopic();
        forumTopic.setLastPostDate(lastPostDate);
        assertEquals(lastPostDate, forumTopic.getLastPostDate());
    }

    @Test
    void testSetLastPostDate() {
        LocalDateTime lastPostDate = LocalDateTime.now();
        ForumTopic forumTopic = new ForumTopic();
        forumTopic.setLastPostDate(lastPostDate);
        assertEquals(lastPostDate, forumTopic.getLastPostDate());

        LocalDateTime newLastPostDate = LocalDateTime.now().plusDays(1);
        forumTopic.setLastPostDate(newLastPostDate);
        assertEquals(newLastPostDate, forumTopic.getLastPostDate());
    }
}