package org.isooproject.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HelloService {

    @Autowired
    IsooprojectProperties isooprojectProperties;

    public String getMessage() {

        return "hello, " + isooprojectProperties.getName() + " "
                + isooprojectProperties.getPojoList().size() + " "
                + isooprojectProperties.getWorkFor() + " "
                + isooprojectProperties.getWhereToGo() + " "
                + isooprojectProperties.getFooBar();
    }
}
