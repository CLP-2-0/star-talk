package edu.cs.tcu.chineselearningplatform.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.cs.tcu.chineselearningplatform.entity.*;
import edu.cs.tcu.chineselearningplatform.entity.util.Result;
import edu.cs.tcu.chineselearningplatform.entity.util.StatusCode;
import edu.cs.tcu.chineselearningplatform.service.SectionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@Controller
@RequestMapping("/sections")
public class SectionController {
    private SectionService sectionService;

    public SectionController(SectionService sectionService){
        this.sectionService = sectionService;
    }

    /**
     * Method to find one course.
     * @param id of the course to be sought.
     * @return Result object that contains flag, status code, message, and found course.
     */
    @GetMapping("/{sectionId}")
    @ResponseBody
    public Result findById(@PathVariable String sectionId) {
        return new Result(true, StatusCode.SUCCESS, "Find course by id success", sectionService.findById(sectionId));
    }
    /**
     * Method to find all sections by a teacher.
     * @param username of the teacher
     * @return Result object that contains flag, status code, message, and found lessons.
     */
    @GetMapping("/{username}/all")
    @ResponseBody
    public Result findByTeacher(@PathVariable String username) {
        return new Result(true, StatusCode.SUCCESS, "Find course by teacher success", sectionService.findByTeacher(username));
    }

    /**
     * Method to find all students in one course.
     * @param id of the course to be sought.
     * @return Result object that contains flag, status code, message, and all students in one course.
     */
    @GetMapping("/{sectionId}/students")
    @ResponseBody
    public Result findStudents(@PathVariable String sectionId) {
        return new Result(true, StatusCode.SUCCESS, "Find students by course id success", sectionService.findStudents(sectionId));
    }
    /**
     * Method to save one section.
     * @param section to be saved.
     * @return Result object that contains flag, status code, message.
     */
    @PostMapping("/{username}")
    @ResponseBody
    public Result save(@RequestBody Section newSection, @PathVariable String username) {
        sectionService.save(newSection,username);
        return new Result(true, StatusCode.SUCCESS, "Save section success");
    }


    /**
     * Method to add student to course/section (Student join course/section).
     * @param "sectionId" of the section the student belongs to, student Id of the student.
     * @return Result object that contains flag, status code, message.
     */
    @PutMapping("/{sectionId}/{studentId}")
    @ResponseBody
    public Result assignStudent(@PathVariable String sectionId,@PathVariable String studentId){
        sectionService.assignStudent(sectionId,studentId);
        return new Result(true, StatusCode.SUCCESS, "Student joined success");
    }

    @PostMapping("/exam/{sid}/{lid}/{start}/{day}/{length}")
    @ResponseBody
    public Result saveExam(@RequestBody List<GradedQuestion> questions, @PathVariable String sid, @PathVariable String lid, @PathVariable String start, @PathVariable String day, @PathVariable String length) {
        sectionService.saveExam(sid, lid, start, day, length, questions);
        return new Result(true, StatusCode.SUCCESS, "Save exam success");
    }

    @GetMapping("/exam/{sid}/{lid}")
    @ResponseBody
    public Result getExam(@PathVariable String sid, @PathVariable String lid) {
        return new Result(true, StatusCode.SUCCESS, "Find exam by section success", sectionService.getExamBySection(sid,lid));
    }

    @PostMapping("/submission/{sid}/{lid}")
    @ResponseBody
    public Result saveSubmission(@RequestBody List<ExamAnswer> answers, @PathVariable String sid, @PathVariable String lid) throws IOException, GeneralSecurityException {
        sectionService.saveExamSubmission(answers, sid, lid);
        return new Result(true, StatusCode.SUCCESS, "Save exam submission success");
    }

    @PutMapping("/submission/{sid}/{lid}/{idx}")
    @ResponseBody
    public Result gradeSubmission(@RequestBody List<ExamAnswer> answers, @PathVariable String sid, @PathVariable String lid, @PathVariable Integer idx) throws JsonProcessingException {
        sectionService.gradeExamSubmission(answers, sid, lid, idx);
        return new Result(true, StatusCode.SUCCESS, "Grade exam submission success");
    }

}

