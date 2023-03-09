package edu.cs.tcu.chineselearningplatform.datainitializer;

import edu.cs.tcu.chineselearningplatform.dao.UserRepository;

import edu.cs.tcu.chineselearningplatform.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MockDataInitializer implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

    }
}

//    private UserRepository userRepository;
////    private LessonRepository lessonRepository;
////    private VocabRepository vocabRepository;
////
////    public MockDataInitializer(LessonRepository lessonRepository) {
////        this.lessonRepository = lessonRepository;
////    }
//
//    /*
//    public MockDataInitializer(VocabRepository vocabRepository) {
//    this.vocabRepository = vocabRepository;
//    }
//     */
//
//    /*
//    public MockDataInitializer(HomeworkRepository homeworkRepository) {
//    this.homeworkRepository = homeworkRepository;
//    }
//     */
//
////    public MockDataInitializer(UserRepository userRepository) {
////        this.userRepository = userRepository;
////    }
////    @Override
////    public void run(String... args) throws Exception {
////
////        for(User user : userRepository.findAll()){
////            System.out.println(user);
////        };
////        for(Lesson lesson : lessonRepository.findAll()){
////            System.out.println(lesson);
////        }
//
////         for(Vocab vocab : vocabRepository.findAll()) {
////         System.out.println(vocab);
////         }
//
////        for(Homework homework : homeworkRepository.findAll()) {
////            System.out.println((homework));
////        }
//    }
//}
