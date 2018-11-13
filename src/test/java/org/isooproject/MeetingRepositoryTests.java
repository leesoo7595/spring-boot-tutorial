package org.isooproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataMongoTest
public class MeetingRepositoryTests {

    @Autowired
    MeetingRepository meetingRepository;

    @Test
    public void findByLocation() {
        // Given
        Meeting meeting = new Meeting();
        meeting.setTitle("new Meeting");
        meeting.setLocation("redmond");
        meetingRepository.save(meeting);

        Meeting mongoMeeting = new Meeting();
        meeting.setTitle("mongo study");
        meeting.setLocation("seattle");
        meetingRepository.save(mongoMeeting);

        // When
        List<Meeting> result = meetingRepository.findByLocation("seattle");

        // Then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result).contains(mongoMeeting);
    }
}
