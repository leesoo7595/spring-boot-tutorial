package org.isooproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SampleControllerTest {

    // 설정 파일을 달고 있는 inner class를 만들 경우, static을 붙여줘야한다.
//    @TestConfiguration
    // 메인 설정으로 등록되게해서 그 안에 있는 빈을 제외하고 아무것도 없음. -> componentscan이 없다.
    // 밖에 있는 SampleController를 빈으로 찾지 못한다.
    // 베이스패키지 기준으로 Application.class를 찾는다 -> SampleController를 찾을 수 있게됨
    @Configuration
    @ComponentScan(basePackageClasses = Application.class)
    static class TestConfig {

        @Bean
        public String myBean() {
            return "myBean";
        }
    }

    @Autowired
    MockMvc mockMvc;

    @Autowired
    String myBean;

    @Autowired
    SampleController sampleController;

    @Test
    public void testFoo() throws Exception {
        assertThat(mockMvc).isNotNull();
        mockMvc.perform(get("/foo"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello"))
                .andDo(print());
    }
}
