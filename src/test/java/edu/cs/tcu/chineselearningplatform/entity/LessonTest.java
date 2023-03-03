package edu.cs.tcu.chineselearningplatform.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class LessonTest {

    private Lesson lesson;

    @BeforeEach
    public void setup() {
        lesson = new Lesson();
    }

    @Test
    public void testAddVocab() {
        Vocab vocab = new Vocab();
        vocab.setWord("hello");
        vocab.setMeaning("你好");

        lesson.addVocab(vocab);

        List<Vocab> expectedVocabs = new ArrayList<>();
        expectedVocabs.add(vocab);

        Assertions.assertEquals(expectedVocabs, lesson.getVocabs());
        Assertions.assertEquals(lesson, vocab.getLesson());
    }

    @Test
    public void testRemoveVocab() {
        Vocab vocab = new Vocab();
        vocab.setWord("hello");
        vocab.setMeaning("你好");

        lesson.addVocab(vocab);
        lesson.removeVocab(vocab);

        List<Vocab> expectedVocabs = new ArrayList<>();

        Assertions.assertEquals(expectedVocabs, lesson.getVocabs());
        Assertions.assertNull(vocab.getLesson());
    }

    @Test
    public void testUpdateVocab() {
        Vocab oldVocab = new Vocab();
        oldVocab.setWord("hello");
        oldVocab.setMeaning("你好");

        Vocab updatedVocab = new Vocab();
        updatedVocab.setWord("goodbye");
        updatedVocab.setMeaning("再见");

        lesson.addVocab(oldVocab);
        lesson.updateVocab(oldVocab, updatedVocab);

        List<Vocab> expectedVocabs = new ArrayList<>();
        expectedVocabs.add(updatedVocab);

        Assertions.assertEquals(expectedVocabs, lesson.getVocabs());
        Assertions.assertEquals(lesson, updatedVocab.getLesson());
    }

    @Test
    public void testAddQuestion() {
        Question question = new Question();
        question.setQuestion("What is your name?");
        question.setAnswer("My name is John.");

        lesson.addQuestion(question);

        List<Question> expectedQuestions = new ArrayList<>();
        expectedQuestions.add(question);

        Assertions.assertEquals(expectedQuestions, lesson.getQuestionsBank());
        Assertions.assertEquals(lesson, question.getLesson());
    }

    @Test
    public void testRemoveQuestion() {
        Question question = new Question();
        question.setQuestion("What is your name?");
        question.setAnswer("My name is John.");

        lesson.addQuestion(question);
        lesson.removeQuestion(question);

        List<Question> expectedQuestions = new ArrayList<>();

        Assertions.assertEquals(expectedQuestions, lesson.getQuestionsBank());
        Assertions.assertNull(question.getLesson());
    }

    @Test
    public void testGetQuestionsBank() {
        List<Question> questionsBank = new ArrayList<>();
        Question question1 = new Question();
        Question question2 = new Question();
        questionsBank.add(question1);
        questionsBank.add(question2);
        lesson.setQuestionsBank(questionsBank);

        Assertions.assertEquals(questionsBank, lesson.getQuestionsBank());
    }

    @Test
    public void testSetQuestionsBank() {
        List<Question> questionsBank = new ArrayList<>();
        Question question1 = new Question();
        Question question2 = new Question();
        questionsBank.add(question1);
        questionsBank.add(question2);
        lesson.setQuestionsBank(questionsBank);

        Assertions.assertEquals(questionsBank, lesson.getQuestionsBank());
    }

    @Test
    public void testGetId() {
        String id = "lesson123";
        lesson.setId(id);

        Assertions.assertEquals(id, lesson.getId());
    }

    @Test
    public void testSetId() {
        String id = "lesson123";
        lesson.setId(id);

        Assertions.assertEquals(id, lesson.getId());
    }

    @Test
    public void testGetTitle() {
        String title = "Lesson Title";
        lesson.setTitle(title);

        Assertions.assertEquals(title, lesson.getTitle());
    }

    @Test
    public void testSetTitle() {
        String title = "Lesson Title";
        lesson.setTitle(title);

        Assertions.assertEquals(title, lesson.getTitle());
    }

    @Test
    public void testGetContent() {
        String content = "Lesson Content";
        lesson.setContent(content);

        Assertions.assertEquals(content, lesson.getContent());
    }

    @Test
    public void testSetContent() {
        String content = "Lesson Content";
        lesson.setContent(content);

        Assertions.assertEquals(content, lesson.getContent());
    }

    @Test
    public void testGetVocabs() {
        List<Vocab> vocabs = new ArrayList<>();
        Vocab vocab1 = new Vocab();
        Vocab vocab2 = new Vocab();
        vocabs.add(vocab1);
        vocabs.add(vocab2);
        lesson.setVocabs(vocabs);

        Assertions.assertEquals(vocabs, lesson.getVocabs());
    }

    @Test
    public void testSetVocabs() {
        List<Vocab> vocabs = new ArrayList<>();
        Vocab vocab1 = new Vocab();
        Vocab vocab2 = new Vocab();
        vocabs.add(vocab1);
        vocabs.add(vocab2);
        lesson.setVocabs(vocabs);

        Assertions.assertEquals(vocabs, lesson.getVocabs());
    }



    @Test
    public void testGetPredefined() {
        Lesson lesson = new Lesson();
        Homework homework = new Homework();
        lesson.setPredefined(homework);
        Assertions.assertEquals(homework, lesson.getPredefined());
    }

    @Test
    public void testSetPredefined() {
        Lesson lesson = new Lesson();
        Homework homework = new Homework();
        lesson.setPredefined(homework);
        Assertions.assertEquals(homework, lesson.getPredefined());

        Homework newHomework = new Homework();
        lesson.setPredefined(newHomework);
        Assertions.assertEquals(newHomework, lesson.getPredefined());
    }


}
