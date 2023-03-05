package edu.cs.tcu.chineselearningplatform.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.cs.tcu.chineselearningplatform.GoogleDrive;
import edu.cs.tcu.chineselearningplatform.dao.ExamAnswerRepository;
import edu.cs.tcu.chineselearningplatform.dao.ExamRepository;
import edu.cs.tcu.chineselearningplatform.dao.SectionRepository;
import edu.cs.tcu.chineselearningplatform.dao.UserRepository;
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
    private GoogleDrive googleDrive = new GoogleDrive();

    public SectionService(SectionRepository sectionRepository, UserRepository userRepository, UserService userService, ExamRepository examRepository, LessonService lessonService, ExamAnswerRepository examAnswerRepository){
        this.sectionRepository = sectionRepository;
        this.userRepository = userRepository;
        this.userService = userService;
        this.examRepository = examRepository;
        this.lessonService = lessonService;
        this.examAnswerRepository = examAnswerRepository;
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
     * @return Result object that contains flag, status code, message.
     */
    public void save(Section newSection) {
        User user = userRepository.findAll().get(0);
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

    public void saveExam(String sid, String lid, Exam exam) {
        examRepository.save(exam);
        Section currSection = findById(sid).get();
        Lesson currLesson = lessonService.findById(lid);
        String updateOldExam = currSection.addExam(lid, exam.getId());

        sectionRepository.save(currSection);

        if(updateOldExam != null) {
            Exam oldExam = examRepository.findByObjectId(new ObjectId(updateOldExam));
            examRepository.delete(oldExam);
        }

    }

    public Exam getExamBySection(String sid, String lid) {
        Section currSection = findById(sid).get();
        String examId = currSection.getExamMap().get(lid);
        Exam exam = examRepository.findByObjectId(new ObjectId(examId));
        return exam;

    }

    public void saveExamSubmission(List<ExamAnswer> answers, String sid, String lid) throws IOException, GeneralSecurityException {
        for(ExamAnswer a: answers){
            Answer ans = a.getAnswer();
            if(ans.getType().equals("audio")){
                String base64 = ans.getKey();
                //Get file ID from google drive
                String fid = googleDrive.uploadFile(base64, a.getStudent());
                ans.setKey(fid);
            }
            examAnswerRepository.save(a);
        }
        Exam exam = getExamBySection(sid, lid);
        exam.addSubmission(answers);
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

}
