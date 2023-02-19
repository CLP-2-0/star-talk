package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.SectionRepository;
import edu.cs.tcu.chineselearningplatform.dao.UserRepository;
import edu.cs.tcu.chineselearningplatform.entity.Section;
import edu.cs.tcu.chineselearningplatform.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectionService {
    private SectionRepository sectionRepository;
    private UserRepository userRepository;
    private UserService userService;

    public SectionService(SectionRepository sectionRepository, UserRepository userRepository, UserService userService){
        this.sectionRepository = sectionRepository;
        this.userRepository = userRepository;
        this.userService = userService;
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
}
