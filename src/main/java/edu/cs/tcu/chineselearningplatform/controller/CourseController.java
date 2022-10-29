package edu.cs.tcu.chineselearningplatform.controller;

import edu.cs.tcu.chineselearningplatform.entity.util.Result;
import edu.cs.tcu.chineselearningplatform.entity.util.StatusCode;
import edu.cs.tcu.chineselearningplatform.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    /**
     * Method to find one course.
     * @param id of the course to be sought.
     * @return Result object that contains flag, status code, message, and found course.
     */
    @GetMapping("/{courseId}")
    @ResponseBody
    public Result findById(@PathVariable String courseId) {
        return new Result(true, StatusCode.SUCCESS, "Find course by id success", courseService.findByObjectId(courseId));
    }

    /**
     * Method to find all students in one course.
     * @param id of the course to be sought.
     * @return Result object that contains flag, status code, message, and all students in one course.
     */
    @GetMapping("/{courseId}/students")
    @ResponseBody
    public Result findStudents(@PathVariable String courseId) {
        return new Result(true, StatusCode.SUCCESS, "Find students by course id success", courseService.findStudents(courseId));
    }
}
