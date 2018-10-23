package org.isooproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BookController {

    @GetMapping("/foo")
    public String getFoo() {
        return "isooproject";
    }

    @GetMapping("/flux")
    public Flux<String> flux() {
        return Flux.just("a", "b", "c");
    }

    @GetMapping("/mono")
    public Mono<String> mono() {
        return Mono.just("mono");
    }
}