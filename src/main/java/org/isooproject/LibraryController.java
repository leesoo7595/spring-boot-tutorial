package org.isooproject;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
public class LibraryController {

    // 1. String 형태인 id에 Library 형태의 library를 넣는다
    // 2. 어떻게 넣는가?
    // 3. Converter, Formatter
    @GetMapping("/bs/{id}")
    public LibraryResource namedLibrary(@PathVariable("id") Library library) {
        if (library.getId() == 100) {
            throw new LibraryException();
        }

        // resource를 새로 만들고!
        LibraryResource resource = new LibraryResource();
        resource.setName(library.getId() + "번째 도서관 입니다.");
        resource.add(new Link("http://localhost:8080/bs/" + library.getId()));

        // link를 만들어서 resource에 추가해주면 !
        Link link = linkTo(LibraryController.class).slash("bs").slash(library.getId()).withSelfRel();
        resource.add(link);
        return resource;
    }
}
