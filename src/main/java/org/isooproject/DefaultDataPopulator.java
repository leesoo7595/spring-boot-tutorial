package org.isooproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DefaultDataPopulator implements ApplicationRunner {

    @Autowired
    MeetingRepository meetingRepository;

    @Autowired
    PersonRepository personRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Person person = new Person();
        person.setEmail("leesoo@email.com");
        person.setName("leesoo");
        person.setJoined(new Date());
        personRepository.save(person);

        personRepository.findByEmail("leesoo@email.com");

        Meeting meeting = new Meeting();
        meeting.setTitle("new meeting");
        meeting.setLocation("Seoul");
        meetingRepository.save(meeting);

    }
}
