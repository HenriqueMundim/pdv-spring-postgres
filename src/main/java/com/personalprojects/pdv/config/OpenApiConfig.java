package com.personalprojects.pdv.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                        title = "Pdv application",
                        version = "1.0",
                        summary = "Application using Java 17 and Spring Boot 3.2.5",
                        description = "Application to register a user and products, you can order product and pay for then",
                        contact = @Contact(name = "Henrique Matos", email = "henriquemundimmatos@gmail.com", url = "https://www.linkedin.com/in/henriquemmatos/"),
                        license = @License,
                        termsOfService = "",
                        extensions = {}
                ),
        tags = {},
        servers = {},
        security = {},
        extensions = {},
        externalDocs = @ExternalDocumentation()
)
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI configuration() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement()
                        .addList("bearerAuth"))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .name("bearerAuth")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                        )
                );
    }
}
