package org.isooproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleWebMvcTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    // RANDOM_PORT로 진짜 서버를 띄운 후 테스트
    @Test
    public void testFoo() throws Exception {
        String response = testRestTemplate.getForObject("/foo", String.class);
        assertThat(response).isEqualTo("isooproject");
    }

}
