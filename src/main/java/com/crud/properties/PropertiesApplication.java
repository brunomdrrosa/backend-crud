package com.crud.properties;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableAutoConfiguration(exclude = ErrorMvcAutoConfiguration.class)
@OpenAPIDefinition(
    info =
        @Info(
            title = "Properties API",
            version = "1.0.0",
            description =
                "Application made for creating, listing, updating and deleting properties in a Postgres Database."))
public class PropertiesApplication {

  public static void main(String[] args) {

    SpringApplication.run(PropertiesApplication.class, args);
    System.out.println();
  }
}
