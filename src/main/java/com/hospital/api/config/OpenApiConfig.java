package com.hospital.api.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

import io.swagger.v3.oas.models.OpenAPI;

import io.swagger.v3.oas.models.info.Info;

import java.util.Collections;


@Configuration
@OpenAPIDefinition()
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("${application-description}") String appDescription,
                                 @Value("${application-version}")  String appVersion) {
        return new OpenAPI()
                .info(new Info()
                        .title("Hospital API")
                        .version(appVersion)
                        .contact(getContact())
                        .description(appDescription)
                        .termsOfService("https://swagger.io/terms/")
                       // .license(getLicense())
                );
    }
    private Contact getContact() {
        Contact contact = new Contact();
        contact.setEmail("info@gmail.com");
        contact.setName("Hospital Management System");
       // contact.setUrl("https://www.book.com");
        contact.setExtensions(Collections.emptyMap());
        return contact;
    }

    private License getLicense() {
        License license = new License();
        license.setName("Apache License, Version 2.0");
        license.setUrl("http://www.apache.org/licenses/LICENSE-2.0");
        license.setExtensions(Collections.emptyMap());
        return license;
    }
}
