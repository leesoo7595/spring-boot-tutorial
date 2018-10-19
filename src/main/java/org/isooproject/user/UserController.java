package org.isooproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    HttpMessageConverters converters;

    /**
     * "main" -> ViewResolver -> View.* -> ContentNegotiatingViewResolver -> View
     *
     * {"name":"leesoo"}
     * @return
     */
    @RequestMapping("/")
    public String index() {
        converters.getConverters().forEach(c ->
            System.out.println("::::::::::" + c.getClass()));

        return "Hello Spring MVC";
    }

    @GetMapping("/user")
    public User currentUser() {
        User user = new User();
        user.setAge(20);
        user.setName("leesoo");
        user.setHeight(160);
        return user;
    }
}
