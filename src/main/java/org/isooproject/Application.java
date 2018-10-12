package org.isooproject;

import org.isooproject.hello.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class Application {

    @Autowired
    HelloService helloService;

    @Bean
    public ExitCodeGenerator exitCodeGenerator() {
        return () -> 42;
    }

    @RequestMapping("/")
    String home() {
        return helloService.getMessage();
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.addListeners(new MyListener());
        ConfigurableApplicationContext run = application.run(args);

        System.exit(SpringApplication.exit(run));

    }
}
