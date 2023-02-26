//package edu.cs.tcu.chineselearningplatform.service;
//
//import edu.cs.tcu.chineselearningplatform.dao.QuestionRepository;
//import edu.cs.tcu.chineselearningplatform.entity.Lesson;
//import edu.cs.tcu.chineselearningplatform.entity.Question;
//import org.bson.types.ObjectId;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.doAnswer;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//
//public class QuestionServiceTest {
//    @Mock
//    QuestionRepository questionRepository;
//    @InjectMocks
//    QuestionService questionService;
//    @Mock
//    LessonService lessonService;
//    @Test
//    void testFindById() {
//        Question question1 = new Question();
//        question1.setQuestion("Q1");
//        question1.setAnswer("A1");
//
//
//
//        when(questionRepository.findByObjectId(any(ObjectId.class))).thenReturn(question1);
//
//        Question res = questionService.findById("6342139d1d62b17c341a49b1");
//
//        assertEquals(question1.getQuestion(), res.getQuestion());
//    }
////
////    @Test
////    void save() {
////        Question question1 = new Question();
////        question1.setQuestion("Q1");
////        question1.setAnswer("A1");
////        question1.setId("6342139d1d62b17c341a49b1");
////
////        Lesson lesson = new Lesson();
////        lesson.setId("100");
////
////        when(lessonService.findById(any(String.class))).thenReturn(lesson);
////
////        doAnswer(invocation -> {
////            Object arg0 = invocation.getArgument(0);
////
////            assertEquals(question1, arg0);
////            return null;
////        }).when(questionRepository).save(any(Question.class));
////
////        doAnswer(invocation -> {
////            Object arg0 = invocation.getArgument(0);
////
////            assertEquals(lesson, arg0);
////            return null;
////        }).when(lessonService).save(any(Lesson.class));
//////        questionService.save(question1, "100");
////    }
//
////    @Test
////    void delete() {
////        Question question1 = new Question();
////        question1.setQuestion("Q1");
////        question1.setAnswer("A1");
////
////        Lesson lesson = new Lesson();
////        lesson.setId("100");
////
////        when(lessonService.findById(any(String.class))).thenReturn(lesson);
////        when(questionRepository.findByObjectId(any(ObjectId.class))).thenReturn(question1);
////        doAnswer(invocation -> {
////            Object arg0 = invocation.getArgument(0);
////
////            assertEquals(question1, arg0);
////            return null;
////        }).when(questionRepository).delete(any(Question.class));
////
////        doAnswer(invocation -> {
////            Object arg0 = invocation.getArgument(0);
////
////            assertEquals(lesson, arg0);
////            return null;
////        }).when(lessonService).save(any(Lesson.class));
////        questionService.delete("6342139d1d62b17c341a49b1");
////    }
//}
