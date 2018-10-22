package org.isooproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class SampleJsonTest {

    @Autowired
    JacksonTester<Sample> sampleJsonTester;

    @Autowired
    JacksonTester<Person> personJsonTester;

    @Test
    public void testJson() throws IOException {
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
