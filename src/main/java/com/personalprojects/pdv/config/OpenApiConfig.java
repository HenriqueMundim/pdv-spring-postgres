package com.personalprojects.pdv.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                        title = "Pdv application",
                        version = "v1",
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
public class OpenApiConfig {
}
