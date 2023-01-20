package edu.cs.tcu.chineselearningplatform.controller;

import edu.cs.tcu.chineselearningplatform.entity.Lesson;
import edu.cs.tcu.chineselearningplatform.entity.Vocab;
import edu.cs.tcu.chineselearningplatform.entity.util.Result;
import edu.cs.tcu.chineselearningplatform.entity.util.StatusCode;
import edu.cs.tcu.chineselearningplatform.service.VocabService;
import edu.cs.tcu.chineselearningplatform.wrapper.VocabWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vocabs")
public class VocabController {
    private VocabService vocabService;

    public VocabController(VocabService vocabService){
        this.vocabService = vocabService;
    }

    /**
     * Method to find one vocab.
     * @param "id" of the vocab to be sought.
     * @return Result object that contains flag, status code, message, and found vocab.
     */
    @GetMapping("/{vocabId}")
    @ResponseBody
    public Result findById(@PathVariable String vocabId) {
        return new Result(true, StatusCode.SUCCESS, "Find vocab by id success", vocabService.findByObjectId(vocabId));
    }

    @GetMapping("vocab-lesson/{lessonId}")
    @ResponseBody
    public Result findAllByLesson(@PathVariable String lessonId){
        return new Result(true, StatusCode.SUCCESS, "list of all vocabs for that lesson success", vocabService.findAllByLesson(lessonId));
    }
    /**
     * Method to save one vocab.
     * @param "vocab" to be saved.
     * @return Result object that contains flag, status code, message.
     */
    @PostMapping("/save/{lessonId}")
    @ResponseBody
    public Result save(@PathVariable String lessonId, @RequestBody Vocab newVocab) {
//        vocabService.save(newVocab, lessonId);
        return new Result(true, StatusCode.SUCCESS, "Save vocab success");
    }
    /**
     * Method to save vocab list.
     * @param vocabList to be saved.
     * @return Result object that contains flag, status code, message.
     */
    @PostMapping("/{lessonId}")
    @ResponseBody
    public Result save(@PathVariable String lessonId, @RequestBody List<Vocab> vocabs){
        {
            vocabService.saveVocabs(vocabs, lessonId);
            return new Result(true, StatusCode.SUCCESS, "Save vocabList success");
        }
    }

    /**
     * Method to delete a vocab.
     * @param "id" of the lesson the vocab belongs to, id of the vocab.
     * @return Result object that contains flag, status code, message.
     */
    @DeleteMapping("/delete/{lessonId}/{vocabId}")
    @ResponseBody
    public Result deleteById(@PathVariable String lessonId, @PathVariable String vocabId) {
        vocabService.delete(vocabId, lessonId);
        return new Result(true, StatusCode.SUCCESS, "Delete vocab success!");
    }

    /**
     * Method to update a vocab.
     * @param "id" of the lesson the vocab belongs to, id of the vocab.
     * @return Result object that contains flag, status code, message.
     */
    @PutMapping("/update/{lessonId}/{vocabId}")
    @ResponseBody
    public Result update(@PathVariable String lessonId, @PathVariable String vocabId, @RequestBody Vocab updatedVocab) {
        vocabService.update(vocabId, updatedVocab, lessonId);
        return new Result(true, StatusCode.SUCCESS, "Update vocab success!");
    }

}
