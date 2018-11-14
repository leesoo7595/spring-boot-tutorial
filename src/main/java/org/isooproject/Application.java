package org.isooproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    @Autowired
    WebClient.Builder webClientBuild;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();

            WebClient webClient = webClientBuild.baseUrl("https://api.github.com").build();

            Mono<GithubRepository[]> reposMono = webClient.get().uri("/users/leesoo7595/repos")
                    .retrieve()
                    .bodyToMono(GithubRepository[].class);

            Mono<GithubCommit[]> commitsMono = webClient.get().uri("/repos/leesoo7595/Airbnb-Project/commits")
                    .retrieve()
                    .bodyToMono(GithubCommit[].class);

            reposMono.doOnSuccess(ra -> {
                Arrays.stream(ra).forEach(r -> {
                    System.out.println("repo : " + r.getUrl());
                });
            }).subscribe();

            commitsMono.doOnSuccess(ca -> {
               Arrays.stream(ca).forEach(c -> {
                   System.out.println("commits : " + c.getSha());
               });
            }).subscribe();

            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        };
    }

}


