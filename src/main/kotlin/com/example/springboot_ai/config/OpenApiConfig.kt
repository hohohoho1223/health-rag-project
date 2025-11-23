package com.example.springboot_ai.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun springOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Spring AI API")
                    .version("1.0")
                    .description("Spring AI를 활용한 챗봇 API 입니다!")
            )
    }
}