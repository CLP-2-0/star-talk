package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.CourseRepository;
import edu.cs.tcu.chineselearningplatform.entity.Course;
import edu.cs.tcu.chineselearningplatform.entity.User;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    /**
     * Method to find one course.
     * @param id of the course to be sought.
     * @return Result object that contains flag, status code, message, and found course.
     */
    public Course findByObjectId(String id) {
        return courseRepository.findByObjectId(new ObjectId(id));
    }

    /**
     * Method to find all students in one course.
     * @param id of the course to be sought.
     * @return Result object that contains flag, status code, message, and all students in one course.
     */
    public List<User> findStudents(String id) {
        return findByObjectId(id).getStudents();
    }
}
