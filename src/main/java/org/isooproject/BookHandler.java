package org.isooproject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Controller
public class BookHandler {

    public Mono<ServerResponse> allBooks(ServerRequest request) {
        Book book = new Book();
        book.setIsbn("1123");
        book.setTitle("isooproject");

        Mono<Book> mono = Mono.just(book);

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(mono, Book.class);
    }
}
