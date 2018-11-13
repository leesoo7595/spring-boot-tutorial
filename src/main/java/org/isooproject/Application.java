package org.isooproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    @Autowired
    MeetingRepository meetingRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
          Meeting meeting = new Meeting();
          meeting.setName("New Meeting");
          meeting.setTitle("Neo4j Study");
          meetingRepository.save(meeting);
        };
    }

}


