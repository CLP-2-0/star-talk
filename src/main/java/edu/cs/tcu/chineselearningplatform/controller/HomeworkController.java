package edu.cs.tcu.chineselearningplatform.controller;

import edu.cs.tcu.chineselearningplatform.entity.GradedQuestion;
import edu.cs.tcu.chineselearningplatform.entity.Homework;
import edu.cs.tcu.chineselearningplatform.entity.Question;
import edu.cs.tcu.chineselearningplatform.entity.util.Result;
import edu.cs.tcu.chineselearningplatform.entity.util.StatusCode;
import edu.cs.tcu.chineselearningplatform.service.HomeworkService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/homework")
public class HomeworkController {
    private HomeworkService homeworkService;

    public HomeworkController(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    /**
     * Method to save one homework.
     * @param homework to be saved.
     * @return Result object that contains flag, status code, message.
     */
    @PostMapping("/{sid}/{lid}")
    @ResponseBody
    public Result save(@RequestBody List<GradedQuestion> questions, @PathVariable String sid, @PathVariable String lid) {
        homeworkService.save(questions, sid, lid);
        return new Result(true, StatusCode.SUCCESS, "Save homework success");
    }

    /**
     * Method to find one homework.
     * @param id of the homework to be sought.
     * @return Result object that contains flag, status code, message, and found lesson.
     */

    @GetMapping("/{homeworkId}")
    @ResponseBody
    public Result findById(@PathVariable String homeworkId) {
        return new Result(true, StatusCode.SUCCESS, "Find homework by id success", homeworkService.findById(homeworkId));
    }

    /**
     * Method to find a homework for a lesson of a section.
     * @params id of the section and id of the lesson in it.
     * @return Result object that contains flag, status code, message, and found homework.
     */
    @GetMapping("/{sid}/{lid}")
    @ResponseBody
    public Result findHomework(@PathVariable String sid, @PathVariable String lid) {
        return new Result(true, StatusCode.SUCCESS, "The result homework", homeworkService.findHomework(sid, lid));
    }

    /**
     * Method to find all homeworks.
     * @param
     * @return Result object that contains flag, status code, message, and found lesson.
     */
    @GetMapping
    @ResponseBody
    public Result findAll(){
        List<Homework> all = homeworkService.findAll();
        return new Result(true,StatusCode.SUCCESS,"Find all homeworks", all);
    }

    /**
     * Method to update one homework.
     * @param homework to be updated.
     * @return Result object that contains flag, status code, message.
     */
    @PutMapping("/{homeworkId}")
    @ResponseBody
    public Result update( @PathVariable String homeworkId, @RequestBody Homework updatedHomework){
        homeworkService.update(homeworkId, updatedHomework);
        return new Result(true, StatusCode.SUCCESS, "Update homework success");
    }

    /**
     * Method to delete one homework.
     * @param homework to be deleted.
     * @return Result object that contains flag, status code, message.
     */
    @DeleteMapping("/{homeworkId}")
    @ResponseBody
    public Result delete( @PathVariable String homeworkId){
        homeworkService.delete(homeworkId);
        return new Result(true,StatusCode.SUCCESS,"Delete homework success");
    }
}