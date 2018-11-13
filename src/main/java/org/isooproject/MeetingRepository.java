package org.isooproject;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.repository.CrudRepository;

public interface MeetingRepository extends CrudRepository<Meeting, String> {


}
