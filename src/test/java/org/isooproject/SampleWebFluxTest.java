package org.isooproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockito.BDDMockito.given;

// SampleController만 테스트할 때 그것만 빈으로 만들어줌
// @WebMvcTest(SampleController.class)
// 디폴트는 모든 컨트롤러를 빈으로 만들어줌
@RunWith(SpringRunner.class)
@WebFluxTest
public class SampleWebFluxTest {

    @Autowired
    WebTestClient webTestClient;

    //SpyBean 같은 경우 원래있는 빈을 감싸서 쓰는 것이기 때문에, 빈이 없는 관계로 쓰지 못한다.
    //@Service는 빈으로 등록해주지 않기때문에(@WebMvcTest) 따로 MockBean으로 등록해주어야한다.
    @MockBean
    SampleService sampleService;

    @Test
    public void testFoo() throws Exception {
        // MockBean인 sampleService 설정
        given(sampleService.getName()).willReturn("isooproject");

        webTestClient.get().uri("/foo").exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("isooproject");
    }
}
