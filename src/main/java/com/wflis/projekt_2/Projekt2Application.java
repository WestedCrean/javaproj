package com.wflis.projekt_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories({"com.wflis.projekt_2.repositories"})
@ComponentScan({"com.wflis.projekt_2.controllers"})
public class Projekt2Application {

    public static void main(String[] args) {
        SpringApplication.run(Projekt2Application.class, args);
    }
}
