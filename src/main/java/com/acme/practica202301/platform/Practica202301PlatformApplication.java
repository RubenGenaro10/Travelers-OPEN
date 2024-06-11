package com.acme.practica202301.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Practica202301PlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(Practica202301PlatformApplication.class, args);
    }

}
