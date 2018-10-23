package org.isooproject;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@RestClientTest(SampleServiceImpl.class)
public class SampleServiceTest {

    @Autowired
    SampleService sampleService;

    // RestTemplate이 이쪽 서버로 프록시형태로 기능(/foo)을 전달
    // 즉, 굳이 진짜 서버를 안띄워도 된다.
    @Autowired
    MockRestServiceServer server;

    @Test
    public void fooTest() {
        // RestServer MockUp
        server.expect(requestTo("/foo"))
            .andRespond(withSuccess("isooproject", MediaType.TEXT_PLAIN ));

        String name = sampleService.getName();
        Assertions.assertThat(name).isEqualTo("isooproject");
    }

}
