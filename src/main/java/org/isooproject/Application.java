package org.isooproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();

            RestTemplate restTemplate = restTemplateBuilder.build();
            GithubRepository[] result = restTemplate.getForObject("https://api.github.com/users/leesoo7595/repos", GithubRepository[].class);
            Arrays.stream(result).forEach(r -> {
                System.out.println("repo : " + r.getUrl());
            });

            GithubCommit[] commits = restTemplate.getForObject("https://api.github.com/repos/leesoo7595/Airbnb-Project/commits", GithubCommit[].class);
            Arrays.stream(commits).forEach(c -> {
                System.out.println("url : " + c.getUrl() + " / sha : " + c.getSha());
            });

            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        };
    }

}


