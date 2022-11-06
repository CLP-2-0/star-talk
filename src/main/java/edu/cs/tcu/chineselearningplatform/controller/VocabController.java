package edu.cs.tcu.chineselearningplatform.controller;

import edu.cs.tcu.chineselearningplatform.entity.Vocab;
import edu.cs.tcu.chineselearningplatform.entity.util.Result;
import edu.cs.tcu.chineselearningplatform.entity.util.StatusCode;
import edu.cs.tcu.chineselearningplatform.service.VocabService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vocabs")
public class VocabController {
    private VocabService vocabService;

    public VocabController(VocabService vocabService){
        this.vocabService = vocabService;
    }

    /**
     * Method to find one vocab.
     * @param id of the vocab to be sought.
     * @return Result object that contains flag, status code, message, and found vocab.
     */
    @GetMapping("/{vocabId}")
    @ResponseBody
    public Result findById(@PathVariable String vocabId) {
        return new Result(true, StatusCode.SUCCESS, "Find vocab by id success", vocabService.findByObjectId(vocabId));
    }
    /**
     * Method to save one vocab.
     * @param vocab to be saved.
     * @return Result object that contains flag, status code, message.
     */
    @PostMapping("/save/{lessonId}")
    @ResponseBody
    public Result save(@PathVariable String lessonId, @RequestBody Vocab newVocab) {
        vocabService.save(newVocab, lessonId);
        return new Result(true, StatusCode.SUCCESS, "Save vocab success");
    }

    /**
     * Method to delete a vocab.
     * @param id of the lesson the vocab belongs to, id of the vocab.
     * @return Result object that contains flag, status code, message.
     */
    @DeleteMapping("/delete/{lessonId}/{vocabId}")
    @ResponseBody
    public Result deleteById(@PathVariable String lessonId, @PathVariable String vocabId) {
        vocabService.delete(vocabId, lessonId);
        return new Result(true, StatusCode.SUCCESS, "Delete vocab success!");
    }
}