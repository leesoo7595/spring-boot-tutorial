package org.isooproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {

    // 1. String 형태인 id에 Library 형태의 library를 넣는다
    // 2. 어떻게 넣는가?
    // 3. Converter, Formatter
    @GetMapping("/bs/{id}")
    public Library visitLibrary(@PathVariable("id") Library library) {
        return library;
    }
}
