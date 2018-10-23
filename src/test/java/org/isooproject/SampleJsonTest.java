package org.isooproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

// SpringTest가 아니다.
// SpringApplicationContext를 사용하지 않지만, JsonTester를 써야할 경우
public class SampleJsonTest {

    JacksonTester<Sample> sampleJsonTester;

    JacksonTester<Person> personJsonTester;

    @Before
    public void setup() {
        // application context를 만들지 않고 돌려서 빠른 방법.
        // initFields 메소드로 sampleJsonTester를 인스턴스화시킨다.
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    public void testJson() throws IOException {
        assertThat(personJsonTester).isNotNull();

        Sample sample = new Sample();
        sample.setName("leesoo");
        sample.setNumber(100);

        JsonContent<Sample> sampleJson = this.sampleJsonTester.write(sample);
        assertThat(sampleJson)
                .hasJsonPathStringValue("@.name")
                .extractingJsonPathStringValue("@.name").isEqualTo("leesoo");

        assertThat(sampleJson)
                .hasJsonPathNumberValue("@.number")
                .extractingJsonPathNumberValue("@.number").isEqualTo(100);
    }
}
