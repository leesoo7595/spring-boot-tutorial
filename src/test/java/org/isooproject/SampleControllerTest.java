package org.isooproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleControllerTest {
// 랜덤포트로 웹어플리케이션컨텍스트 띄우기 (진짜 웹어플리케이션컨텍스트가 띄워진닷!)
    @LocalServerPort
    int port;

    // webflux 기반으로만 쓸 수 있는 아이..
    @Autowired
    WebTestClient webTestClient;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void testFooWithRestTemplate() {
        String body = this.testRestTemplate.getForObject("/foo", String.class);
        assertThat(body).isEqualTo("Hello");
    }

    @Test
    public void testFooWithWebTestClient() {
        webTestClient.get().uri("/foo").exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hello");
    }

}
