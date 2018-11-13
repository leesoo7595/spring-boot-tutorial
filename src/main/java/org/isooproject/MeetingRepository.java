package org.isooproject;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import reactor.core.publisher.Flux;

import java.util.List;


public interface MeetingRepository extends ReactiveMongoRepository<Meeting, String> {

    Flux<Meeting> findByLocation(String location);

}
