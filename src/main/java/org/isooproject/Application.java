package org.isooproject;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ApplicationRunner runner(JdbcTemplate jdbcTemplate){
        return new ApplicationRunner() {

            @Override
            public void run(ApplicationArguments args) throws Exception {
                Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM Customers", Integer.class);
                System.out.println("count : " + count);
            }
        };
    }

}


