package edu.cs.tcu.chineselearningplatform.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.cs.tcu.chineselearningplatform.dao.*;
import edu.cs.tcu.chineselearningplatform.entity.*;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Optional;

@Service
public class SectionService {
    private SectionRepository sectionRepository;
    private UserRepository userRepository;
    private UserService userService;
    private ExamRepository examRepository;
    private LessonService lessonService;
    private ExamAnswerRepository examAnswerRepository;
    private LessonRepository lessonRepository;
    private GradedQuestionRepository gradedQuestionRepository;
    private HomeworkRepository homeworkRepository;

    public SectionService(SectionRepository sectionRepository, UserRepository userRepository, UserService userService, ExamRepository examRepository, LessonService lessonService, ExamAnswerRepository examAnswerRepository, LessonRepository lessonRepository, GradedQuestionRepository gradedQuestionRepository, HomeworkRepository homeworkRepository){
        this.sectionRepository = sectionRepository;
        this.userRepository = userRepository;
        this.userService = userService;
        this.examRepository = examRepository;
        this.lessonService = lessonService;
        this.examAnswerRepository = examAnswerRepository;
        this.lessonRepository = lessonRepository;
        this.gradedQuestionRepository = gradedQuestionRepository;
        this.homeworkRepository = homeworkRepository;
    }

    /**
     * Method to find one course.
     * @param id of the course to be sought.
     * @return Result object that contains flag, status code, message, and found course.
     */
    public Optional<Section> findById(String id) {
        return sectionRepository.findById(id);
    }

    /**
     * Method to find all students in one course.
     * @param id of the course to be sought.
     * @return Result object that contains flag, status code, message, and all students in one course.
     */
    public List<User> findStudents(String id) {
        return findById(id).get().getStudents();
    }

    /**
     * Method to save one section.
     * @param section to be saved.
     * @param username
     * @return Result object that contains flag, status code, message.
     */
    public void save(Section newSection, String username) {
        User user = userRepository.findByUsername(username);
        newSection.setInstructor(user);
        user.addSection(newSection);
        sectionRepository.save(newSection);
        userService.save(user);
    }

    public List<Section> findByTeacher(String username) {
        return userService.findByUsername(username).getSections();
    }


    /**
     * Method to add student to course/section (Student join course/section).
     * @param "sectionId" of the section the student belongs to, student Id of the student.
     * @return Result object that contains flag, status code, message.
     */
    public void assignStudent(String sectionId, String studentId) {
        //find student by studentID
        User studentToBeAdded = userRepository.findById(studentId).get();
        Section course = sectionRepository.findById(sectionId).get();

        course.addStudent(studentToBeAdded);
        sectionRepository.save(course);
        userRepository.save(studentToBeAdded);

    }

    public void saveExamContent(String lessonId, List<GradedQuestion> questions, String time) {

    }

    public void saveExam(String sid, String lid, String start, String day, String length, List<GradedQuestion> questions) {
        for(GradedQuestion q: questions) {
            gradedQuestionRepository.save(q);
        }
        Homework examContent = new Homework();
        examContent.setQuestionList(questions);
        homeworkRepository.save(examContent);

        Exam exam = new Exam();
        exam.setExam(examContent);
        exam.setLength(length);
        exam.setStartTime(start);
        exam.setStartDate(day);
        examRepository.save(exam);

        Lesson currLesson = lessonService.findById(lid);
        Section currSection = findById(sid).get();
        String updateOldExam = currSection.addExam(lid, exam.getId());
        System.out.println(exam.getLength());
        sectionRepository.save(currSection);

        if(updateOldExam != null) {
            Exam oldExam = examRepository.findByObjectId(new ObjectId(updateOldExam));
            examRepository.delete(oldExam);
        }

    }

    public Exam getExamBySection(String sid, String lid) {
        Section currSection = findById(sid).get();
        String examId = currSection.getExamMap().get(lid);
        Exam exam = examRepository.findById(examId).get();
        return exam;

    }

    public void saveExamSubmission(List<ExamAnswer> answers, String sid, String lid) throws IOException, GeneralSecurityException {
        for(ExamAnswer a: answers){
            Answer ans = a.getAnswer();
            examAnswerRepository.save(a);
        }
        Exam exam = getExamBySection(sid, lid);
        exam.addSubmission(answers);
        exam.addTaken(answers.get(0).getStudent());
        examRepository.save(exam);
    }

    public void gradeExamSubmission(List<ExamAnswer> answers, String sid, String lid, Integer idx) throws JsonProcessingException {
        Integer grade = 0;
        for(ExamAnswer a: answers){
            grade += a.getGrade();
            examAnswerRepository.save(a);
        }
        String student = answers.get(0).getStudent();
        Exam exam = getExamBySection(sid, lid);
        exam.getSubmissions().set(idx, answers);
        exam.addToGradeMap(student, grade);
        examRepository.save(exam);

    }

    public void saveSection(Section section) {
        sectionRepository.save(section);
    }

}

