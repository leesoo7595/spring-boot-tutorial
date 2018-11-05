package org.isooproject.book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @GetMapping("/foo")
    public String getFoo() {
        return "isooproject";
    }

}