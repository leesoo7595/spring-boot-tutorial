package org.isooproject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SampleControllerTest {
// 랜덤포트로 웹어플리케이션컨텍스트 띄우기 (진짜 웹어플리케이션컨텍스트가 띄워진닷!)
    @LocalServerPort
    int port;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    WebApplicationContext wac;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void testFoo() throws Exception {
        System.out.println("==============PORT=============");
        System.out.println(port);

        assertThat(mockMvc).isNotNull();
        mockMvc.perform(get("/foo"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello"))
                .andDo(print());
    }

    @Test
    public void testFooWithRestTemplate() {
        String body = this.testRestTemplate.getForObject("/foo", String.class);
        assertThat(body).isEqualTo("Hello");
    }

}
