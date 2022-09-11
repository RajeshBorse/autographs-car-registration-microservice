package com.module.autographs.carregistration.microservice;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class AutographsCarRegistrationApplication {

    private static final Logger logger = LogManager.getLogger(AutographsCarRegistrationApplication.class);


    public static void main(String[] args) {

        SpringApplication.run(AutographsCarRegistrationApplication.class, args);
        logger.info("Autographs Car Registration Microservices");

    }

    @Bean
    public OpenAPI openApiConfig() {
        return new OpenAPI().info(apiInfo());
    }

    public Info apiInfo() {
        Info info = new Info();
        info.title("Autograph Car Registration Microservices API").description("Live Code System Swagger Open API").version("v1.0.0");
        return info;
    }

}
