package org.isooproject.hello;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getMessage() {
        return "Hello, Spring boot!";
    }
}
