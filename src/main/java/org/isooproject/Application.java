package org.isooproject;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class Application {

    @Autowired
    MongoDbFactory mongoDbFactory;

    @Autowired
    MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            Meeting meeting = new Meeting();
            meeting.setLocation("Redmond");
            meeting.setTitle("MongoDB Study");
            mongoTemplate.insert(meeting, "meetings");
        };
    }

}


