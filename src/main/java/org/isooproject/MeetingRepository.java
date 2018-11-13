package org.isooproject;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface MeetingRepository extends PagingAndSortingRepository<Meeting, String> {

    List<Meeting> findByLocation(String location);

}
