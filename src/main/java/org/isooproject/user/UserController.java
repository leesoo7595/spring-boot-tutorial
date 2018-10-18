package org.isooproject.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    /**
     * "main" -> ViewResolver -> View.* -> ContentNegotiatingViewResolver -> View
     *
     * {"name":"leesoo"}
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "Hello Spring MVC";
    }
}
