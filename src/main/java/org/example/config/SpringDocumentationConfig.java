package org.example.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for customizing "OpenAPI/Swagger" documentation.
 */
@Configuration
public class SpringDocumentationConfig {

    /**
     * Method for customizing "OpenAPI" documentation.
     * @return an instance with configured API information
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("File Download and Upload API")
                        .version("1.0")
                        .description("API for downloading and uploading files"));
    }
}