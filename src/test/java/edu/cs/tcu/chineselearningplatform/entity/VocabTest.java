package edu.cs.tcu.chineselearningplatform.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VocabTest {

    @Test
    void getId() {
        Vocab vocab = new Vocab();
        vocab.setId("123");
        assertEquals("123", vocab.getId());
    }

    @Test
    void setId() {
        Vocab vocab = new Vocab();
        vocab.setId("123");
        assertEquals("123", vocab.getId());
    }

    @Test
    void getWord() {
        Vocab vocab = new Vocab();
        vocab.setWord("hello");
        assertEquals("hello", vocab.getWord());
    }

    @Test
    void setWord() {
        Vocab vocab = new Vocab();
        vocab.setWord("hello");
        assertEquals("hello", vocab.getWord());
    }

    @Test
    void getMeaning() {
        Vocab vocab = new Vocab();
        vocab.setMeaning("你好");
        assertEquals("你好", vocab.getMeaning());
    }

    @Test
    void setMeaning() {
        Vocab vocab = new Vocab();
        vocab.setMeaning("你好");
        assertEquals("你好", vocab.getMeaning());
    }

    @Test
    void getPinyin() {
        Vocab vocab = new Vocab();
        vocab.setPinyin("nǐ hǎo");
        assertEquals("nǐ hǎo", vocab.getPinyin());
    }

    @Test
    void setPinyin() {
        Vocab vocab = new Vocab();
        vocab.setPinyin("nǐ hǎo");
        assertEquals("nǐ hǎo", vocab.getPinyin());
    }

    @Test
    void getType() {
        Vocab vocab = new Vocab();
        vocab.setType("noun");
        assertEquals("noun", vocab.getType());
    }

    @Test
    void setType() {
        Vocab vocab = new Vocab();
        vocab.setType("noun");
        assertEquals("noun", vocab.getType());
    }

    @Test
    void getLesson() {
        Vocab vocab = new Vocab();
        Lesson lesson = new Lesson();
        vocab.setLesson(lesson);
        assertEquals(lesson, vocab.getLesson());
    }

    @Test
    void setLesson() {
        Vocab vocab = new Vocab();
        Lesson lesson = new Lesson();
        vocab.setLesson(lesson);
        assertEquals(lesson, vocab.getLesson());
    }
}
