package edu.cs.tcu.chineselearningplatform.datainitializer;

import edu.cs.tcu.chineselearningplatform.dao.UserRepository;
import edu.cs.tcu.chineselearningplatform.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MockDataInitializer implements CommandLineRunner {
    private UserRepository userRepository;

    public MockDataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public void run(String... args) throws Exception {

        for(User user : userRepository.findAll()){
            System.out.println(user);
        }

    }
}
