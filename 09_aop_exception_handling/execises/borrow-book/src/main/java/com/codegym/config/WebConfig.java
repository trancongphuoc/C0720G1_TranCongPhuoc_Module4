package com.codegym.config;

import com.codegym.aspect.BookLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public BookLogger createLogger() {
        return new BookLogger();
    }
}
