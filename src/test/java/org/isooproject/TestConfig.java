package org.isooproject;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {
// inner class에 있을 때만 해당 class에 Bean등록을 해주고,
// 외부에 있을 땐 자동으로 해주지 않는다.
// 그래서 다른 클래스에서 아래 Bean을 찾을때 TestConfig 클래스을 Import어노테이션으로 주입시켜줘야한다.
    @Bean
    public String myBean() {
        return "myBean";
    }
}
