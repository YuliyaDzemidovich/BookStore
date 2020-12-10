package org.example.config;

import org.example.TempBean;
import org.example.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // for testing only
    @Bean (name = "tempBean")
    public TempBean getTempBean() {
        return new TempBean();
    }

    @Bean (name = "bookDao")
    public BookDao getBookDao() {
        return new BookDao();
    }
}
