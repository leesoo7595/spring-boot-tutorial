package org.isooproject.hello;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class HelloService {

    public String getMessage() {
        return "Hello, Spring boot!";
    }

//    @PostConstruct
//    public void init() {
//        throw new RuntimeException("Intended Exception!");
//    }
}
