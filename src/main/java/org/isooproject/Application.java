package org.isooproject;

import org.isooproject.hello.HelloService;
import org.isooproject.hello.IsooprojectProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * --SPRING_APPLICATION_JSON={"foo":"bar"}
 */
@RestController
@SpringBootApplication
public class Application {

    @Autowired
    HelloService helloService;

    @Autowired
    Environment environment;

    // 아래처럼 달면 역참조(?)로 빈을 등록하고 값을 꺼내오는 것이 가능하다.(Binding)
    @Bean
    @ConfigurationProperties("isooproject")
    public IsooprojectProperties isooprojectProperties() {
        return new IsooprojectProperties();
    }

    @RequestMapping("/")
    String home() {
        System.out.println(environment.getProperty("isooproject.pojoList[0].name"));
        System.out.println(environment.getProperty("isooproject.name"));
        System.out.println(environment.getProperty("isooproject.work-for"));
        return helloService.getMessage();
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.addListeners(new MyListener());
        application.run(args);

    }
}
