//package edu.cs.tcu.chineselearningplatform.service;
//
//import edu.cs.tcu.chineselearningplatform.dao.QuestionRepository;
//import edu.cs.tcu.chineselearningplatform.entity.Lesson;
//import edu.cs.tcu.chineselearningplatform.entity.Question;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.mockito.BDDMockito.given;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//public class QuestionServiceTest {
//
//    private QuestionService questionService;
//
//    @Mock
//    private QuestionRepository questionRepositoryMock;
//
//    @Mock
//    private LessonService lessonServiceMock;
//
//    private Lesson testLesson;
//    private Question testQuestion;
//
//    List<Question> questions;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//        questionService = new QuestionService(questionRepositoryMock, lessonServiceMock);
//
//        // create a test lesson
//        testLesson = new Lesson();
//        testLesson.setId("lessonId");
//
//
//        // create a test question
//        testQuestion = new Question();
//        testQuestion.setId("questionId");
//        testQuestion.setQuestion("What is your name?");
//        testQuestion.setAnswer("My name is John");
//        testQuestion.setLesson(testLesson);
//
//        this.questions = new ArrayList<>();
//        this.questions.add(testQuestion);
//    }
//
//    @AfterEach
//    void tearDown() {
//
//    }
//
//    @Test
//    public void testFindById() {
//        when(questionRepositoryMock.findById("questionId")).thenReturn(Optional.of(testQuestion));
//
//        Question foundQuestion = questionService.findById("questionId");
//
//        verify(questionRepositoryMock, times(1)).findById("questionId");
//        assertNotNull(foundQuestion);
//        assertEquals("What is your name?", foundQuestion.getQuestion());
//        assertEquals("My name is John", foundQuestion.getAnswer());
//        assertEquals(testLesson.getId(), foundQuestion.getLesson().getId());
//    }
//
//    @Test
//    public void testFindAllByLesson() {
//        List<Question> questionList = new ArrayList<>();
//        questionList.add(testQuestion);
//
//        when(questionRepositoryMock.findAllByLesson("lessonId")).thenReturn(questionList);
//
//        List<Question> foundQuestionList = questionService.findAllByLesson("lessonId");
//
//        verify(questionRepositoryMock, times(1)).findAllByLesson("lessonId");
//        assertNotNull(foundQuestionList);
//        assertEquals(1, foundQuestionList.size());
//        assertEquals("What is your name?", foundQuestionList.get(0).getQuestion());
//        assertEquals("My name is John", foundQuestionList.get(0).getAnswer());
//        assertEquals(testLesson.getId(), foundQuestionList.get(0).getLesson().getId());
//    }
//
//    @Test
//    public void testSave() {
//        when(lessonServiceMock.findById(any(String.class))).thenReturn(testLesson);
//        when(questionRepositoryMock.save(any(Question.class))).thenReturn(testQuestion);
//
//        questionService.save(testQuestion, "lessonId");
//
//        verify(lessonServiceMock, times(1)).findById("lessonId");
//        verify(lessonServiceMock, times(1)).save(any(Lesson.class));
//        verify(questionRepositoryMock, times(1)).save(testQuestion);
//    }
//
//
//    @Test
//    public void testFindAll() {
//        // Given
//        given(this.questionRepositoryMock.findAll()).willReturn(this.questions);
//
//        // When
//        List<Question> actualQuestions = this.questionService.findAll();
//
//        // Then
//        assertThat(actualQuestions.size()).isEqualTo(this.questions.size());
//        verify(this.questionRepositoryMock, times(1)).findAll();
//    }
//
//    @Test
//    public void testUpdate() {
//        // Given
//        Question oldQuestion = new Question();
//        oldQuestion.setId("1");
//        oldQuestion.setQuestion("What is your name?");
//
//        Question update = new Question();
//        update.setQuestion("What is your name?");
//
//        given(this.questionRepositoryMock.findById("1")).willReturn(Optional.of(oldQuestion));
//        given(this.questionRepositoryMock.save(oldQuestion)).willReturn(oldQuestion);
//
//        // When
//        Question updatedQuestion = this.questionService.update("1", update);
//
//        // Then
//        assertThat(updatedQuestion.getId()).isEqualTo("1");
//        assertThat(updatedQuestion.getQuestion()).isEqualTo(update.getQuestion());
//        verify(this.questionRepositoryMock, times(1)).findById("1");
//        verify(this.questionRepositoryMock, times(1)).save(oldQuestion);
//    }
//
//
//    @Test
//    void testDeleteSuccess() {
//        // Given
//        String questionId = "123456789";
//        Question question = new Question();
//        question.setId(questionId);
//
//        given(this.questionRepositoryMock.findById(questionId)).willReturn(Optional.of(question));
//
//        // When
//        this.questionService.delete(questionId);
//
//        // Then
//        verify(this.questionRepositoryMock, times(1)).findById(questionId);
//        verify(this.questionRepositoryMock, times(1)).delete(question);
//    }
//
//}
