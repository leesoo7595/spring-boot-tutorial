package org.isooproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleControllerTest {
// 랜덤포트로 웹어플리케이션컨텍스트 띄우기 (진짜 웹어플리케이션컨텍스트가 띄워진닷!)
    @LocalServerPort
    int port;

    // webflux 기반으로만 쓸 수 있는 아이..
    @Autowired
    WebTestClient webTestClient;

//    @MockBean
//    SampleService sampleService;

    @Test
    public void testFooWithWebTestClient() {
//        given(sampleService.getName()).willReturn("Mock");

        webTestClient.get().uri("/foo").exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Remote Service");
    }

}
