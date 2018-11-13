package org.isooproject;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;

@SpringBootApplication
public class Application {

    @Autowired
    MongoDbFactory mongoDbFactory;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            MongoDatabase db = mongoDbFactory.getDb();
            db.createCollection("meetings");

            db.getCollection("meetings").insertOne(
                    new Document()
                            .append("title", "new meeting")
                            .append("location", "Seattle")
            );
        };
    }

}


