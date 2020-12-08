package com.codegym.config;

import com.codegym.aspect.UserLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public UserLogger checkLog() {
        return new UserLogger();
    }
}
