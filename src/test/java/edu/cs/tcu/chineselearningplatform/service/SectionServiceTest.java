package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.SectionRepository;
import edu.cs.tcu.chineselearningplatform.dao.UserRepository;
import edu.cs.tcu.chineselearningplatform.entity.Section;
import edu.cs.tcu.chineselearningplatform.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class SectionServiceTest {

    @Mock
    private SectionRepository sectionRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserService userService;

    private SectionService sectionService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.sectionService = new SectionService(sectionRepository, userRepository, userService);
    }

    @Test
    public void testFindById() {
        // Given
        Section expectedSection = new Section();
        expectedSection.setId("1");
        expectedSection.setSection("Test Section");

        given(sectionRepository.findById("1")).willReturn(Optional.of(expectedSection));

        // When
        Optional<Section> actualSection = sectionService.findById("1");

        // Then
        assertThat(actualSection.isPresent()).isTrue();
        assertThat(actualSection.get().getId()).isEqualTo(expectedSection.getId());
        assertThat(actualSection.get().getSection()).isEqualTo(expectedSection.getSection());
        verify(sectionRepository, times(1)).findById("1");
    }

    @Test
    public void testFindStudents() {
        // Given
        User student1 = new User();
        student1.setId("1");
        student1.setUsername("student1");

        User student2 = new User();
        student2.setId("2");
        student2.setUsername("student2");

        Section section = new Section();
        section.setId("1");
        section.setSection("Test Section");
        section.setStudents(Arrays.asList(student1, student2));

        given(sectionRepository.findById("1")).willReturn(Optional.of(section));

        // When
        List<User> students = sectionService.findStudents("1");

        // Then
        assertThat(students).hasSize(2);
        assertThat(students).contains(student1, student2);
        verify(sectionRepository, times(1)).findById("1");
    }

    @Test
    public void testSave() {
        // Given
        Section sectionToSave = new Section();
        sectionToSave.setId("1");
        sectionToSave.setSection("Test Section");

        User instructor = new User();
        instructor.setId("1");
        instructor.setUsername("test_instructor");

        given(userRepository.findAll()).willReturn(Arrays.asList(instructor));
        given(sectionRepository.save(sectionToSave)).willReturn(sectionToSave);

        // When
        sectionService.save(sectionToSave);

        // Then
        assertThat(sectionToSave.getInstructor()).isEqualTo(instructor);
        assertThat(instructor.getSections()).contains(sectionToSave);
        verify(userRepository, times(1)).findAll();
        verify(sectionRepository, times(1)).save(sectionToSave);
        verify(userService, times(1)).save(instructor);
    }


    @Test
    public void testFindByTeacher() {
        // Given
        User teacher = new User();
        teacher.setId("1");
        teacher.setUsername("teacher1");

        Section section1 = new Section();
        section1.setId("1");
        section1.setSection("Section 1");
        section1.setInstructor(teacher);

        Section section2 = new Section();
        section2.setId("2");
        section2.setSection("Section 2");
        section2.setInstructor(teacher);

        teacher.setSections(Arrays.asList(section1, section2));

        given(userService.findByUsername("teacher1")).willReturn(teacher);

        // When
        List<Section> sections = sectionService.findByTeacher("teacher1");

        // Then
        assertThat(sections).hasSize(2);
        assertThat(sections).contains(section1, section2);
        verify(userService, times(1)).findByUsername("teacher1");
    }

    @Test
    public void testAssignStudent() {
        // Given
        User student = new User();
        student.setId("1");
        student.setUsername("student1");

        Section section = new Section();
        section.setId("1");
        section.setSection("Section 1");

        given(userRepository.findById("1")).willReturn(Optional.of(student));
        given(sectionRepository.findById("1")).willReturn(Optional.of(section));
        given(sectionRepository.save(section)).willReturn(section);
        given(userRepository.save(student)).willReturn(student);

        // When
        sectionService.assignStudent("1", "1");
        sectionService.assignStudent((section.getId()), student.getId());
        System.out.println(student.getSections());

        // Then
        assertThat(section.getStudents()).hasSize(1);
        assertThat(section.getStudents()).contains(student);
        assertThat(student.getSections()).hasSize(1);
        assertThat(student.getSections()).contains(section);
        verify(userRepository, times(1)).findById("1");
        verify(sectionRepository, times(1)).findById("1");
        verify(sectionRepository, times(1)).save(section);
        verify(userRepository, times(1)).save(student);
    }
}
