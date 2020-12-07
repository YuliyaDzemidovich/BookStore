package org.example.config;

import org.example.TempBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public TempBean getTempBean() {
        return new TempBean();
    }
}
