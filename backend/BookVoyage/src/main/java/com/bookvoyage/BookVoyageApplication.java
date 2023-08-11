package com.bookvoyage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BookVoyageApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookVoyageApplication.class, args);
    }

}
