package org.isooproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> rount() {
        return route(GET("/book").and(accept(MediaType.APPLICATION_JSON)),
                req -> {
                    Book book1 = new Book();
                    book1.setIsbn("1123");
                    book1.setTitle("isooproject");

                    Book book2 = new Book();
                    book2.setIsbn("2234");
                    book2.setTitle("springboot");

                    Flux<Book> books = Flux.just(book1, book2);

                    return ok().contentType(MediaType.APPLICATION_JSON).body(books, Book.class);
                });
    }
}


