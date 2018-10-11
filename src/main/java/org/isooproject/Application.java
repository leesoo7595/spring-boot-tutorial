package org.isooproject;

import org.isooproject.hello.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class Application {

    @Autowired
    HelloService helloService;

    @RequestMapping("/")
    String home() {
        return helloService.getMessage();
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.setBanner(new MyBanner());
        application.run(args);
//        SpringApplication.run(Application.class, args);
    }
}
