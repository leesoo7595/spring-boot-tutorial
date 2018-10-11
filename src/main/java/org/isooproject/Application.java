package org.isooproject;

import org.isooproject.hello.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
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
        application.addListeners(new MyListener());
        // spring 5 부터는 서블릿 & 리액티브 두가지로 나눠지면서 해당을 선택할 수 있게 된다.
//        application.setWebApplicationType(WebApplicationType.NONE);
//        application.setApplicationContextClass();
        application.run(args);
//        SpringApplication.run(Application.class, args);
    }
}
