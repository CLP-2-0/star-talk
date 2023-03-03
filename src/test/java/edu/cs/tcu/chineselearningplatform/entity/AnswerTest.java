package edu.cs.tcu.chineselearningplatform.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnswerTest {

    @Test
    public void testGetId() {
        Answer answer = new Answer();
        answer.setId("123");
        assertEquals("123", answer.getId());
    }

    @Test
    public void testGetType() {
        Answer answer = new Answer();
        answer.setType("multiple-choice");
        assertEquals("multiple-choice", answer.getType());
    }

    @Test
    public void testGetKey() {
        Answer answer = new Answer();
        answer.setKey("A");
        assertEquals("A", answer.getKey());
    }

    @Test
    public void testSetId() {
        Answer answer = new Answer();
        answer.setId("123");
        assertEquals("123", answer.getId());
    }

    @Test
    public void testSetType() {
        Answer answer = new Answer();
        answer.setType("multiple-choice");
        assertEquals("multiple-choice", answer.getType());
    }

    @Test
    public void testSetKey() {
        Answer answer = new Answer();
        answer.setKey("A");
        assertEquals("A", answer.getKey());
    }

    @Test
    public void testGetUsername() {
        Answer answer = new Answer();
        answer.setUsername("Bob");
        assertEquals("Bob", answer.getUsername());
    }

    @Test
    public void testSetUsername() {
        Answer answer = new Answer();
        answer.setUsername("Bob");
        assertEquals("Bob", answer.getUsername());
    }


}
