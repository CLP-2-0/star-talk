package edu.cs.tcu.chineselearningplatform.service;

import static com.mongodb.assertions.Assertions.assertNotNull;
import static com.mongodb.internal.connection.tlschannel.util.Util.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import edu.cs.tcu.chineselearningplatform.entity.Question;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import edu.cs.tcu.chineselearningplatform.dao.AnswerRepository;
import edu.cs.tcu.chineselearningplatform.dao.GradedQuestionRepository;
import edu.cs.tcu.chineselearningplatform.entity.Answer;
import edu.cs.tcu.chineselearningplatform.entity.GradedQuestion;

@SpringBootTest
public class GradedQuestionServiceTest {

    private GradedQuestionService gradedQuestionService;

    @Mock
    private GradedQuestionRepository gradedQuestionRepository;

    @Mock
    private AnswerRepository answerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gradedQuestionService = new GradedQuestionService(gradedQuestionRepository, answerRepository);
    }

    @Test
    public void testFindGradedQuestion() {
        // create a GradedQuestion object for testing
        GradedQuestion question = new GradedQuestion();

        Question question1 = new Question();
        question.setId(String.valueOf(new ObjectId("6079f3c53f3a9313d8f0c672")));
        question.setQuestion(question1);

        // mock the gradedQuestionRepository.findByObjectId() method to return the question object when called with "6079f3c53f3a9313d8f0c672" as argument
        when(gradedQuestionRepository.findByObjectId(new ObjectId("6079f3c53f3a9313d8f0c672"))).thenReturn(question);

        // call the gradedQuestionService.findGradedQuestion() method with "6079f3c53f3a9313d8f0c672" as argument and store the result in a variable
        GradedQuestion result = gradedQuestionService.findGradedQuestion("6079f3c53f3a9313d8f0c672");

        // check that the result is not null and has the correct question
        assertNotNull(result);
        assertEquals(question1, result.getQuestion());
    }

//    @Test
//    public void testSaveAnswerToAQuestion() throws IOException, GeneralSecurityException {
//        // create a mock answer object
//        Answer answer = mock(Answer.class);
//        when(answer.getType()).thenReturn("audio");
//        when(answer.getKey()).thenReturn("testKey");
//
//        // create a mock graded question object
//        GradedQuestion question = mock(GradedQuestion.class);
//        when(gradedQuestionRepository.findByObjectId(any(ObjectId.class))).thenReturn(question);
//
//        // call the saveAnswerToAQuestion() method with the mock objects and test arguments
//        gradedQuestionService.saveAnswerToAQuestion(answer, "testUser", "testQuestionId");
//
//        // verify that the answer object's save() method was called
//        verify(answerRepository).save(answer);
//
//        // verify that the graded question object's addAnswer() method was called with the mock answer object
//        verify(question).addAnswer(answer);
//
//        // verify that the graded question repository's save() method was called with the mock graded question object
//        verify(gradedQuestionRepository).save(question);
//    }

//    @Test
//    public void testGetAllAnswerForAQuestion() {
//        // create a graded question object for testing
//        GradedQuestion question = new GradedQuestion();
//        Question question1 = new Question();
//        question1.setQuestion("How are you?");
//        question.setQuestion(question1);
//        gradedQuestionRepository.save(question);
//
//        // create some answer objects for the question
//        Answer answer1 = new Answer();
//        Answer answer2 = new Answer();
//        answerRepository.save(answer1);
//        answerRepository.save(answer2);
//        question.addAnswer(answer1);
//        question.addAnswer(answer2);
//        gradedQuestionRepository.save(question);
//
//        // call the service method to get all answers for the question
//        List<Answer> result = gradedQuestionService.getAllAnswerForAQuestion(question.getId().toString());
//
//        // check that the result contains the expected answer objects
//        assertThat(result).contains(answer1, answer2);
//    }


}
