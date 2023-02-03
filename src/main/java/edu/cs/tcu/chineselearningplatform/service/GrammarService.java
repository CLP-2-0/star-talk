package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.GrammarRepository;
import edu.cs.tcu.chineselearningplatform.entity.Grammar;
import edu.cs.tcu.chineselearningplatform.entity.Lesson;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GrammarService {
    private GrammarRepository grammarRepository;
    private LessonService lessonService;

    public GrammarService(GrammarRepository grammarRepository, LessonService lessonService){

        this.grammarRepository = grammarRepository;
        this.lessonService = lessonService;
    }

    public Grammar findByObjectId(String id) {
        return grammarRepository.findById(id).get();
    }
    public List<Grammar> findAllByLesson(String lessonId){
        return grammarRepository.findAllbyLesson(lessonId);
    }

    public void save(Grammar newGrammar, String lessonId, List newGrammars){
        newGrammars.add(newGrammar);
        grammarRepository.save(newGrammar);
    }

    public void saveGrammars(List<Grammar> grammars, String lessonId){
        Lesson lesson = lessonService.findById(lessonId);
        List newGrammars = new ArrayList<>();
        for(Grammar g: grammars){
            System.out.println(g.getGrammer());
            save(g, lessonId, newGrammars);
        }
        lesson.setGrammars(newGrammars);
        lessonService.save(lesson);
    }

    public void delete(String grammarId, String lessonId){
        Lesson lesson = lessonService.findById(lessonId);
        Grammar grammar = grammarRepository.findByObjectId(new ObjectId(grammarId));
        lesson.removeGrammar(grammar);
        grammarRepository.delete(grammar);
        lessonService.save(lesson);
    }

    public void update(String grammarId, Grammar updatedGrammar, String lessonId){
        Lesson lesson = lessonService.findById(lessonId);
        Grammar grammar = grammarRepository.findByObjectId(new ObjectId(grammarId));

        updatedGrammar.setId(grammarId);

        lesson.updateGrammar(grammar, updatedGrammar);

        grammarRepository.save(updatedGrammar);
        lessonService.save(lesson);
    }
}
