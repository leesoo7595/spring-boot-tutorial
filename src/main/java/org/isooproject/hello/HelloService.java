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

    // properties value를 가져다 쓰는 방
    @Value("${name}")
    String name;

    public String getMessage() {
        return "hello, " + name;
    }
}
