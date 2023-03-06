package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.GradedQuestionRepository;
import edu.cs.tcu.chineselearningplatform.dao.HomeworkRepository;
import edu.cs.tcu.chineselearningplatform.dao.SectionRepository;
import edu.cs.tcu.chineselearningplatform.entity.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.mongodb.assertions.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class HomeworkServiceTest {

    @Mock
    HomeworkRepository homeworkRepository;

    @Mock
    SectionService sectionService;

    @Mock
    LessonService lessonService;

    @Mock
    SectionRepository sectionRepository;

    @Mock
    GradedQuestionRepository gradedQuestionRepository;

    @InjectMocks
    HomeworkService homeworkService;

    private Section section;
    private Lesson lesson;
    private GradedQuestion gradedQuestion;
    private List<GradedQuestion> gradedQuestionList;
    private Homework homework;
    private Homework homework2;

    List<Homework> homeworks;

    @BeforeEach
    public void setUp() {
        section = new Section();
        section.setId("1");
        section.setSection("Section 1");

        lesson = new Lesson();
        lesson.setId("1");
        lesson.setTitle("Lesson 1");

        gradedQuestion = new GradedQuestion();
        gradedQuestion.setId("1");


        gradedQuestionList = new ArrayList<>();
        gradedQuestionList.add(gradedQuestion);

        homework = new Homework();
        homework.setId("1");
        homework.setSection(section);
        homework.setLesson(lesson);
        homework.setQuestionList(gradedQuestionList);

        homework2 = new Homework();
        homework2.setId("1");
        homework2.setSection(section);
        homework2.setLesson(lesson);
        homework2.setQuestionList(gradedQuestionList);

        this.homeworks = new ArrayList<>();
        this.homeworks.add(homework);
        this.homeworks.add(homework2);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    public void testFindById() {
        // Mock the behavior of the homeworkRepository
        when(homeworkRepository.findById("1")).thenReturn(Optional.of(homework));

        // Call the findById method of the homeworkService
        Homework result = homeworkService.findById("1");

        // Verify the results
        assertEquals(homework, result);
    }

    @Test
    public void testSave() {
        // Mock the behavior of the sectionService and lessonService
        when(sectionService.findById("1")).thenReturn(Optional.of(section));
        when(lessonService.findById("1")).thenReturn(lesson);

        // Mock the behavior of the sectionRepository and gradedQuestionRepository
        when(sectionRepository.save(any(Section.class))).thenReturn(section);
        when(gradedQuestionRepository.save(any(GradedQuestion.class))).thenReturn(gradedQuestion);

        // Call the save method of the homeworkService
        homeworkService.save(gradedQuestionList, "1", "1");

        // Verify that the homeworkRepository.save method was called once
        verify(homeworkRepository, times(1)).save(any(Homework.class));
    }

//    @Test
//    public void testFindHomework() {
//        // Mock the behavior of the sectionService
//        when(sectionService.findById("1")).thenReturn(Optional.of(section));
//
//        // Mock the behavior of the homeworkRepository
//        when(homeworkRepository.findByObjectId(any(ObjectId.class))).thenReturn(homework);
//
//        // Call the findHomework method of the homeworkService
//        Homework result = homeworkService.findHomework("1", "1");
//
//        // Verify the results
//        assertEquals(homework, result);
//    }

    @Test
    public void testFindAll() {
        // Given
        given(this.homeworkRepository.findAll()).willReturn(this.homeworks);

        // When
        List<Homework> actualHomeworks = this.homeworkService.findAll();

        // Then
        assertThat(actualHomeworks.size()).isEqualTo(this.homeworks.size());
        verify(this.homeworkRepository, times(1)).findAll();
    }

    @Test
    void testUpdateSuccess() {
        Homework updatedHomework = new Homework();
        updatedHomework.setId("1");
        updatedHomework.setSection(section);

        when(homeworkRepository.findById("1")).thenReturn(Optional.of(homework));
        homeworkService.update("1", updatedHomework);

        verify(homeworkRepository, times(1)).save((homework));
        assertEquals(section, homework.getSection());
    }



    @Test
    void testDeleteSuccess() {
        // Given
        String homeworkId = "123456789";
        Homework homework = new Homework();
        homework.setId(homeworkId);

        given(this.homeworkRepository.findById(homeworkId)).willReturn(Optional.of(homework));

        // When
        this.homeworkService.delete(homeworkId);

        // Then
        verify(this.homeworkRepository, times(1)).findById(homeworkId);
        verify(this.homeworkRepository, times(1)).delete(homework);
    }


}

