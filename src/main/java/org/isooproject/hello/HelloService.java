package org.isooproject.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HelloService {

    @Autowired
    ApplicationArguments arguments;

    @Value("${hello}")
    String[] helloValues;

    /**
     * CLI : java -jar target/spring-boot-1.0-SNAPSHOT.jar --hello=hello --hello=world
     * --hello=Hello -hello=World => {"Hello", "World"} => "Hello, World"
     * @return
     */
    public String getMessage() {
//        List<String> helloValues = arguments.getOptionValues("hello");
//        String collect = helloValues.stream().collect(Collectors.joining(","));
//        return collect;
        return Arrays.stream(helloValues).collect(Collectors.joining(", "));

    }
}
