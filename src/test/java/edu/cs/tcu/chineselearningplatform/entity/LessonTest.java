package edu.cs.tcu.chineselearningplatform.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        assertEquals(expectedVocabs, lesson.getVocabs());
        assertEquals(lesson, vocab.getLesson());
    }

    @Test
    public void testRemoveVocab() {
        Vocab vocab = new Vocab();
        vocab.setWord("hello");
        vocab.setMeaning("你好");

        lesson.addVocab(vocab);
        lesson.removeVocab(vocab);

        List<Vocab> expectedVocabs = new ArrayList<>();

        assertEquals(expectedVocabs, lesson.getVocabs());
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

        assertEquals(expectedVocabs, lesson.getVocabs());
        assertEquals(lesson, updatedVocab.getLesson());
    }

    @Test
    public void testAddQuestion() {
        Question question = new Question();
        question.setQuestion("What is your name?");
        question.setAnswer("My name is John.");

        lesson.addQuestion(question);

        List<Question> expectedQuestions = new ArrayList<>();
        expectedQuestions.add(question);

        assertEquals(expectedQuestions, lesson.getQuestionsBank());
        assertEquals(lesson, question.getLesson());
    }

    @Test
    public void testRemoveQuestion() {
        Question question = new Question();
        question.setQuestion("What is your name?");
        question.setAnswer("My name is John.");

        lesson.addQuestion(question);
        lesson.removeQuestion(question);

        List<Question> expectedQuestions = new ArrayList<>();

        assertEquals(expectedQuestions, lesson.getQuestionsBank());
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

        assertEquals(questionsBank, lesson.getQuestionsBank());
    }

    @Test
    public void testSetQuestionsBank() {
        List<Question> questionsBank = new ArrayList<>();
        Question question1 = new Question();
        Question question2 = new Question();
        questionsBank.add(question1);
        questionsBank.add(question2);
        lesson.setQuestionsBank(questionsBank);

        assertEquals(questionsBank, lesson.getQuestionsBank());
    }

    @Test
    public void testGetId() {
        String id = "lesson123";
        lesson.setId(id);

        assertEquals(id, lesson.getId());
    }

    @Test
    public void testSetId() {
        String id = "lesson123";
        lesson.setId(id);

        assertEquals(id, lesson.getId());
    }

    @Test
    public void testGetTitle() {
        String title = "Lesson Title";
        lesson.setTitle(title);

        assertEquals(title, lesson.getTitle());
    }

    @Test
    public void testSetTitle() {
        String title = "Lesson Title";
        lesson.setTitle(title);

        assertEquals(title, lesson.getTitle());
    }

    @Test
    public void testGetContent() {
        String content = "Lesson Content";
        lesson.setContent(content);

        assertEquals(content, lesson.getContent());
    }

    @Test
    public void testSetContent() {
        String content = "Lesson Content";
        lesson.setContent(content);

        assertEquals(content, lesson.getContent());
    }

    @Test
    public void testGetVocabs() {
        List<Vocab> vocabs = new ArrayList<>();
        Vocab vocab1 = new Vocab();
        Vocab vocab2 = new Vocab();
        vocabs.add(vocab1);
        vocabs.add(vocab2);
        lesson.setVocabs(vocabs);

        assertEquals(vocabs, lesson.getVocabs());
    }

    @Test
    public void testSetVocabs() {
        List<Vocab> vocabs = new ArrayList<>();
        Vocab vocab1 = new Vocab();
        Vocab vocab2 = new Vocab();
        vocabs.add(vocab1);
        vocabs.add(vocab2);
        lesson.setVocabs(vocabs);

        assertEquals(vocabs, lesson.getVocabs());
    }



    @Test
    public void testGetPredefined() {
        Lesson lesson = new Lesson();
        Homework homework = new Homework();
        lesson.setPredefined(homework);
        assertEquals(homework, lesson.getPredefined());
    }

    @Test
    public void testSetPredefined() {
        Lesson lesson = new Lesson();
        Homework homework = new Homework();
        lesson.setPredefined(homework);
        assertEquals(homework, lesson.getPredefined());

        Homework newHomework = new Homework();
        lesson.setPredefined(newHomework);
        assertEquals(newHomework, lesson.getPredefined());
    }

    @Test
    public void testGetAndSetGrammarMeaning() {
        // create a new lesson
        Lesson lesson = new Lesson();

        // create a list of grammar meanings
        List<String> grammarMeaningList = new ArrayList<>();
        grammarMeaningList.add("grammar meaning 1");
        grammarMeaningList.add("grammar meaning 2");

        // set the grammar meanings
        lesson.setGrammarMeaning(grammarMeaningList);

        // check that the get method returns the correct list of grammar meanings
        assertEquals(grammarMeaningList, lesson.getGrammarMeaning());

        // create a new list of grammar meanings
        List<String> newGrammarMeaningList = new ArrayList<>();
        newGrammarMeaningList.add("new grammar meaning 1");
        newGrammarMeaningList.add("new grammar meaning 2");

        // set the new grammar meanings
        lesson.setGrammarMeaning(newGrammarMeaningList);

        // check that the get method returns the new list of grammar meanings
        assertEquals(newGrammarMeaningList, lesson.getGrammarMeaning());
    }

    @Test
    void testGetExamBank() {
        // create a lesson with an exam bank
        Lesson lesson = new Lesson();
        List<Question> examBank = new ArrayList<>();
        examBank.add(new Question());
        lesson.setExamBank(examBank);

        // verify that the exam bank returned by getExamBank() matches the one set above
        Assertions.assertEquals(examBank, lesson.getExamBank());
    }

    @Test
    void testSetExamBank() {
        // create a lesson and a new exam bank
        Lesson lesson = new Lesson();
        List<Question> examBank = new ArrayList<>();
        examBank.add(new Question());

        // set the new exam bank using setExamBank()
        lesson.setExamBank(examBank);

        // verify that the exam bank returned by getExamBank() matches the one set above
        Assertions.assertEquals(examBank, lesson.getExamBank());
    }

    @Test
    void testAddEQuestion() {
        // create a lesson and a new question
        Lesson lesson = new Lesson();
        Question question = new Question();

        // add the question to the exam bank using addEQuestion()
        lesson.addEQuestion(question);

        // verify that the exam bank now contains the added question
        Assertions.assertTrue(lesson.getExamBank().contains(question));
        Assertions.assertEquals(lesson, question.getLesson());
    }

    @Test
    void testRemoveEQuestion() {
        // create a lesson with an exam bank and a question in the bank
        Lesson lesson = new Lesson();
        Question question = new Question();
        lesson.addEQuestion(question);

        // remove the question from the exam bank using removeEQuestion()
        lesson.removeEQuestion(question);

        // verify that the exam bank no longer contains the removed question
        Assertions.assertFalse(lesson.getExamBank().contains(question));
        Assertions.assertNull(question.getLesson());
    }

    @Test
    void testGetExam() {
        // create a lesson with an exam
        Lesson lesson = new Lesson();
        Homework exam = new Homework();
        lesson.setExam(exam);

        // verify that the exam returned by getExam() matches the one set above
        Assertions.assertEquals(exam, lesson.getExam());
    }

    @Test
    void testSetExam() {
        // create a lesson and a new exam
        Lesson lesson = new Lesson();
        Homework exam = new Homework();

        // set the new exam using setExam()
        lesson.setExam(exam);

        // verify that the exam returned by getExam() matches the one set above
        Assertions.assertEquals(exam, lesson.getExam());
    }

    @Test
    public void testSetOrder() {
        int expectedOrder = 1;
        lesson.setOrder(expectedOrder);
        int actualOrder = lesson.getOrder();
        assertEquals(expectedOrder, actualOrder);
    }

    @Test
    public void testGetOrder() {
        int expectedOrder = 2;
        lesson.setOrder(expectedOrder);
        int actualOrder = lesson.getOrder();
        assertEquals(expectedOrder, actualOrder);
    }

}
