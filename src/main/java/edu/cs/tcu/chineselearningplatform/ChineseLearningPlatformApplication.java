package edu.cs.tcu.chineselearningplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ChineseLearningPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChineseLearningPlatformApplication.class, args);
    }

}
