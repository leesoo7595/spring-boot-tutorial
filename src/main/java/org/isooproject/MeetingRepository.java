package org.isooproject;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface MeetingRepository extends Neo4jRepository<Meeting, Long> {


}
