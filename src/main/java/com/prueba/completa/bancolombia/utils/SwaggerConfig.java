package com.prueba.completa.bancolombia.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI customOpenAPI(){

        Contact contact=new Contact();
        contact.setEmail("danielfelopezrendon@gmail.com");
        contact.setName("Daniel López");
        return new OpenAPI()
        .info(new Info()
        .title("Mi API GENERICA")
        .version("1.0")
        .description("Parametrizacion de documentacion Api")
        .contact(contact));

    }
}
