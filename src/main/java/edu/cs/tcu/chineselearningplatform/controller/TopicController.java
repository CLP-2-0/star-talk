package edu.cs.tcu.chineselearningplatform.controller;

import edu.cs.tcu.chineselearningplatform.entity.ForumTopic;
import edu.cs.tcu.chineselearningplatform.entity.Lesson;
import edu.cs.tcu.chineselearningplatform.entity.TopicAnswer;
import edu.cs.tcu.chineselearningplatform.entity.util.Result;
import edu.cs.tcu.chineselearningplatform.entity.util.StatusCode;
import edu.cs.tcu.chineselearningplatform.service.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/topics")
public class TopicController {
    private TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }


    /**
     * Method to find all topics by section.
     */
    @GetMapping
    @ResponseBody
    public Result findAllTopic(){
        List<ForumTopic> all = topicService.findAll();
        return new Result(true, StatusCode.SUCCESS,"Find all topic!", all);

    }

    @GetMapping("/{topicId}")
    @ResponseBody
    public Result findTopicById(@PathVariable String topicId) {
        return new Result(true, StatusCode.SUCCESS, "Find by id success", topicService.findTopicById(topicId));
    }

    @PostMapping("/{sectionId}")
    @ResponseBody
    public Result createTopic(@RequestBody ForumTopic newTopic, @PathVariable String sectionId) {
        topicService.createTopic(newTopic,sectionId);
        return new Result(true, StatusCode.SUCCESS, "Save success");
    }

    @PutMapping("/{topicId}")
    @ResponseBody
    public Result updateTopic(@PathVariable String topicId, @RequestBody ForumTopic updatedTopic){
        topicService.updateTopic(topicId,updatedTopic);
        return new Result(true, StatusCode.SUCCESS, "updated");
    }

    @DeleteMapping("/{topicId}")
    @ResponseBody
    public Result delete(@PathVariable String topicId){
        topicService.delete(topicId);
        return new Result(true,StatusCode.SUCCESS,"Delete success");
    }



}

