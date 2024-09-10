package com.onioncoders.grandmasfood.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Poject Grandma's food API" ,version = "1.0",description = "Basic documentation for the API")
)
public class OpenApiConfig {


}
