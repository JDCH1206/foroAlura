package jdch.foro.foroAlura.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("ForoAlura-JDCH API")
                        .description("API Rest de la aplicación ForoAlura, que contiene las funcionalidades CRUD de Tópicos, Respuestas, Usuarios, Cursos y perfiles, además de métodos para crear y eliminar")
                        .contact(new Contact()
                                .name("Equipo Backend")
                                .email("juan120647@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://JDCH.ForoAlura/api/licencia")));
    }
}
