package com.example.springboot_ai.controller

import com.example.springboot_ai.service.ChatService
import org.springframework.web.bind.annotation.*
import io.github.oshai.kotlinlogging.KotlinLogging
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse as SwaggerResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/api/chat")
@Tag(name = "Chat API", description = "OpenAI API를 활용한 채팅기능")
class ChatController(
    private val chatService: ChatService
) {

    private val logger = KotlinLogging.logger {}

    @SwaggerResponse(
        responseCode = "200",
        description = "OK",
        content = [Content(schema = Schema(implementation = ApiResponse::class))]
    )
    @PostMapping("/query")
    fun sendMessage(
        @Parameter(description = "채팅 요청 객체", required = true)
        @RequestBody request: ChatRequest
    ): ResponseEntity<ApiResponse<Map<String, Any>>> {
        logger.info { "Chat API 요청 받음: model=${request.model}" }

        val systemMessage = "너는 신체 움직임 관련해서 정보를 주는 역할이야"

        val response = chatService.openAiChat(
            userInput = request.query,
            systemMessage = systemMessage,
            model = request.model
        )
        logger.debug { "LLM 응답 생성" }
        if (response == null) {
         return ResponseEntity.ok(
             ApiResponse(
                 success = false, error = "응답 없음")
         )
        }
        return ResponseEntity.ok(
            ApiResponse(
                success = true,
                data = mapOf("answer" to response.result.output.text)
            )
        )
    }

    data class ChatRequest(
        val query: String,
        val model: String = "gpt-4o-mini"
    )

    data class ApiResponse<T>(
        val success: Boolean, //null 값 허용 안함
        val data: T? = null, // null 값 허용
        val error: String? = null //null 값 허용
    )
}