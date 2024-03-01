package com.example.calculatorapplication.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
            contact = @Contact(
                    name = "Calculator API Team",
                    email = "linda.boateng@amalitech.com",
                    url = "To be hosted soon"),
            description = "OpenApi documentation for Calculator Application",
            title = "Calculator Application",
            version = "1.0",
            termsOfService = "Terms of Service"),
    servers = {
      @Server(description = "Local ENV", url = "http://localhost:5000"),
      @Server(description = "PRE_PROD ENV", url = "To be hosted soon")
    })
public class OpenApiConfig {}
