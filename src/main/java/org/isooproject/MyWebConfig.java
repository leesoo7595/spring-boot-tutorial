package org.isooproject;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    // addConverter에 새로만든 LibraryConverter 추가
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new LibraryConverter());
    }
}
