package edu.cs.tcu.chineselearningplatform.service;

import edu.cs.tcu.chineselearningplatform.dao.GradedQuestionRepository;
import edu.cs.tcu.chineselearningplatform.dao.HomeworkRepository;
import edu.cs.tcu.chineselearningplatform.dao.LessonRepository;
import edu.cs.tcu.chineselearningplatform.entity.GradedQuestion;
import edu.cs.tcu.chineselearningplatform.entity.Homework;
import edu.cs.tcu.chineselearningplatform.entity.Lesson;
import edu.cs.tcu.chineselearningplatform.entity.Section;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService {
    private LessonRepository lessonRepository;
    private GradedQuestionRepository gradedQuestionRepository;
    private HomeworkRepository homeworkRepository;

    public LessonService(LessonRepository lessonRepository, GradedQuestionRepository gradedQuestionRepository, HomeworkRepository homeworkRepository){
        this.lessonRepository = lessonRepository;
        this.gradedQuestionRepository = gradedQuestionRepository;
        this.homeworkRepository = homeworkRepository;
    }

    /**
     * Method to find one lesson.
     * @param id of the lesson to be sought.
     * @return Result object that contains flag, status code, message, and found course.
     */
    public Lesson findById(String id) {
        return lessonRepository.findById(id).get();
    }

    /**
     * Method to save one lesson.
     * @param lesson to be saved.
     * @return Result object that contains flag, status code, message.
     */
    public void save(Lesson newLesson) {
        lessonRepository.save(newLesson);
    }
    /**
     * Method to find all lesson.
     * @param
     * @return Result object that contains flag, status code, message, and found lesson.
     */
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }
    /**
     * Method to update one lesson.
     * @param lesson to be updated.
     * @return All lessons.
     */
    public void update(String lessonId, Lesson updatedLesson) {
        Lesson lesson = lessonRepository.findById(lessonId).get();
        lesson.setId(lessonId);
        lesson.setTitle(updatedLesson.getTitle());
        lesson.setContent(updatedLesson.getContent());
        System.out.println(lesson.getContent());
        lessonRepository.save(lesson);

    }
    /**
     * Method to delete one lesson.
     * @param lesson to be deleted.
     */
    public void delete(String lessonId) {
        lessonRepository.deleteById(lessonId);
    }

    /**
     * Method to save a predefined homework to one lesson.
     * @param homework to be saved.
     */
    public void savePredefinedHomework(String lessonId, List<GradedQuestion> questions) {
        for(GradedQuestion q: questions) {
            gradedQuestionRepository.save(q);
        }
        Homework hw = new Homework();
        hw.setQuestionList(questions);
        System.out.println(hw);
        Lesson currLesson = findById(lessonId);
//        hw.setLesson(currLesson);
        homeworkRepository.save(hw);
        currLesson.setPredefined(hw);
        lessonRepository.save(currLesson);
    }
}
