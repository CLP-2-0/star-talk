package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.QuestionRepository;
import edu.cs.tcu.chineselearningplatform.entity.Lesson;
import edu.cs.tcu.chineselearningplatform.entity.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class QuestionServiceTest {

    private QuestionService questionService;

    @Mock
    private QuestionRepository questionRepositoryMock;

    @Mock
    private LessonService lessonServiceMock;

    private Lesson testLesson;
    private Question testQuestion;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        questionService = new QuestionService(questionRepositoryMock, lessonServiceMock);

        // create a test lesson
        testLesson = new Lesson();
        testLesson.setId("lessonId");


        // create a test question
        testQuestion = new Question();
        testQuestion.setId("questionId");
        testQuestion.setQuestion("What is your name?");
        testQuestion.setAnswer("My name is John");
        testQuestion.setLesson(testLesson);
    }

    @Test
    public void testFindById() {
        when(questionRepositoryMock.findById("questionId")).thenReturn(Optional.of(testQuestion));

        Question foundQuestion = questionService.findById("questionId");

        verify(questionRepositoryMock, times(1)).findById("questionId");
        assertNotNull(foundQuestion);
        assertEquals("What is your name?", foundQuestion.getQuestion());
        assertEquals("My name is John", foundQuestion.getAnswer());
        assertEquals(testLesson.getId(), foundQuestion.getLesson().getId());
    }

    @Test
    public void testFindAllByLesson() {
        List<Question> questionList = new ArrayList<>();
        questionList.add(testQuestion);

        when(questionRepositoryMock.findAllByLesson("lessonId")).thenReturn(questionList);

        List<Question> foundQuestionList = questionService.findAllByLesson("lessonId");

        verify(questionRepositoryMock, times(1)).findAllByLesson("lessonId");
        assertNotNull(foundQuestionList);
        assertEquals(1, foundQuestionList.size());
        assertEquals("What is your name?", foundQuestionList.get(0).getQuestion());
        assertEquals("My name is John", foundQuestionList.get(0).getAnswer());
        assertEquals(testLesson.getId(), foundQuestionList.get(0).getLesson().getId());
    }

    @Test
    public void testSave() {
        when(lessonServiceMock.findById(any(String.class))).thenReturn(testLesson);
        when(questionRepositoryMock.save(any(Question.class))).thenReturn(testQuestion);

        questionService.save(testQuestion, "lessonId");

        verify(lessonServiceMock, times(1)).findById("lessonId");
        verify(lessonServiceMock, times(1)).save(any(Lesson.class));
        verify(questionRepositoryMock, times(1)).save(testQuestion);
    }


//    @Test
//    public void testFindAll() {
//        List<Question> questionList = new ArrayList<>();
//        questionList.add(testQuestion);
//
//        when(questionRepositoryMock.findAll()).thenReturn(questionList);
//
//        List<Question> foundQuestionList = questionService.findAll();
//
//        verify(questionRepositoryMock, times(1)).findAll();
//        assertNotNull(foundQuestionList);
//        assertEquals(1, foundQuestionList.size());
//        assertEquals("What is your name?", foundQuestionList.get(0).getQuestion());
//        assertEquals("My name is John");
//    }

//    @Test
//    public void testUpdate() {
//
//        // create the initial question object
//        Question question = new Question();
//        question.setId("questionId");
//        question.setQuestion("What is your name?");
//        question.setAnswer("My name is Alice");
//
//        // create the updated question object
//        Question updatedQuestion = new Question();
//        updatedQuestion.setQuestion("What is your age?");
//        updatedQuestion.setAnswer("I am 25 years old");
//
//        // create the lesson object
//        Lesson lesson = new Lesson();
//        lesson.setId("lessonId");
//
//        // mock the repository and service methods
//        when(questionRepositoryMock.findById("questionId")).thenReturn(Optional.of(question));
//        when(lessonServiceMock.findById("lessonId")).thenReturn(lesson);
//        when(questionRepositoryMock.save(any(Question.class))).thenReturn(updatedQuestion);
//
//        // call the update method
//        questionService.update("questionId", updatedQuestion);
//
//        // verify that the repository and service methods were called
//        verify(questionRepositoryMock, times(2)).findById("questionId");
//        verify(lessonServiceMock, times(1)).findById("lessonId");
//        verify(questionRepositoryMock, times(1)).save(any(Question.class));
//
//        // assert that the question was updated correctly
//        assertEquals("What is your age?", question.getQuestion());
//        assertEquals("I am 25 years old", question.getAnswer());
//        assertEquals(lesson.getId(), question.getLesson().getId());
//    }

}
