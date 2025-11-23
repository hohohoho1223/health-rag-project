package com.example.springboot_ai.config

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.ai.openai.api.OpenAiApi
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class OpenAiConfig {
    private val logger = KotlinLogging.logger {}

    @Value("\${spring.ai.openai.api-key}")
    private lateinit var apiKey: String

    @Bean
    fun openAiApi(): OpenAiApi {
        logger.debug { "OpenAI API 클라이언트 초기화" }
        return OpenAiApi.builder()
            .apiKey(apiKey)
            .build() //반환된 객체들을 스프링 컨테이너에 등록
    }
}