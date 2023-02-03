package edu.cs.tcu.chineselearningplatform.controller;

import edu.cs.tcu.chineselearningplatform.entity.Grammar;
import edu.cs.tcu.chineselearningplatform.entity.util.Result;
import edu.cs.tcu.chineselearningplatform.entity.util.StatusCode;
import edu.cs.tcu.chineselearningplatform.service.GrammarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/vocabs")
public class GrammarController {
    private GrammarService grammarService;

    public GrammarController(GrammarService grammarService){
        this.grammarService = grammarService;
    }

    @GetMapping("/{grammarId}")
    @ResponseBody
    public Result findById(@PathVariable String grammarId){
        return new Result(true, StatusCode.SUCCESS, "Find vocab by id success", grammarService.findByObjectId(grammarId));
    }

    @GetMapping("grammar-lesson/{lessonId}")
    @ResponseBody
    public Result findAllByLesson(@PathVariable String lessonId){
        return new Result(true, StatusCode.SUCCESS, "list of all grammars for this lesson success", grammarService.findAllByLesson(lessonId));
    }

    @PostMapping("/save/{lessonId}")
    @ResponseBody
    public Result save(@PathVariable String lessonId, @PathVariable Grammar newGrammar){
        return new Result(true, StatusCode.SUCCESS, "save grammar success");
    }

    @PostMapping("/{lessonId}")
    @ResponseBody
    public Result save(@PathVariable String lessonId, @RequestBody List<Grammar> grammars){
        grammarService.saveGrammars(grammars, lessonId);
        return new Result(true, StatusCode.SUCCESS, "save grammarlist success");
    }

    @DeleteMapping("/delete/{lessonId}/{grammarId}")
    @ResponseBody
    public Result deleteById(@PathVariable String lessonId, @PathVariable String grammarId){
        grammarService.delete(grammarId, lessonId);
        return new Result(true, StatusCode.SUCCESS, "delete vocab success");
    }

    @PutMapping("/update/{lessonId}/{vocabId}")
    @ResponseBody
    public Result update(@PathVariable String lessonId, @PathVariable String grammarId, @RequestBody Grammar updatedGrammar){
        grammarService.update(grammarId, updatedGrammar, lessonId);
        return new Result(true, StatusCode.SUCCESS, "update vocab success");
    }
}
