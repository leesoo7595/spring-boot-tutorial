package org.isooproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;

@SpringBootApplication
public class Application {

    @Bean
    public ConfigurableWebBindingInitializer initializer() {
        ConfigurableWebBindingInitializer initializer = new ConfigurableWebBindingInitializer();
        ConfigurableConversionService conversionService = new FormattingConversionService();
        // conversionService에 새로만든 LibraryConverter 추가
        conversionService.addConverter(new LibraryConverter());
        // initializer에 ConversionService를 셋팅하기
        initializer.setConversionService(conversionService);
        return initializer;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
