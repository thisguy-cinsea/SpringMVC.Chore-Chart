package com.github.thisguy_cinsea;

import com.github.thisguy_cinsea.model.UserInterface;
import com.github.thisguy_cinsea.service.UserService;
import com.github.thisguy_cinsea.utils.jdbc.JdbcConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        JdbcConfigurator.initialize();
        SpringApplication.run(MainApplication.class, args);
    }
}
