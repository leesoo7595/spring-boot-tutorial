package org.isooproject;

import org.isooproject.hello.HelloService;
import org.isooproject.hello.IsooprojectProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * --SPRING_APPLICATION_JSON={"foo":"bar"}
 */
@RestController
@SpringBootApplication
@EnableConfigurationProperties(IsooprojectProperties.class)
public class Application {

    @Autowired
    HelloService helloService;

    // Bean으로 등록되어있으면 바로 environment로 들어감
    // @EnableConfigurationProperties(IsooprojectProperties.class) 없어도 들어간닷
    // 위에 Bean 등록 안되어있을때 쓰면
    @Autowired
    Environment environment;

    @RequestMapping("/")
    String home() {
        System.out.println(environment.getProperty("isooproject.pojoList[0].name"));
        System.out.println(environment.getProperty("isooproject.name"));
        return helloService.getMessage();
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.addListeners(new MyListener());
        application.run(args);

    }
}
