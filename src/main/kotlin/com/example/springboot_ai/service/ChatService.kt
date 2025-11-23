package com.example.springboot_ai.service

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.ai.chat.messages.SystemMessage
import org.springframework.ai.chat.messages.UserMessage
import org.springframework.ai.chat.model.ChatResponse
import org.springframework.ai.chat.prompt.ChatOptions
import org.springframework.ai.chat.prompt.Prompt
import org.springframework.ai.openai.OpenAiChatModel
import org.springframework.ai.openai.api.OpenAiApi
import org.springframework.stereotype.Service


@Service
class ChatService(
    private val openAiApi: OpenAiApi
) {
    private val logger = KotlinLogging.logger {}
    fun openAiChat(
        userInput: String,
        systemMessage: String,
        model: String = "gpt-4o-mini"
    ): ChatResponse? {
        logger.debug { "OpenAI 챗 호출 시작 - 모델: $model" }
        logger.debug { "chatService openAiChat() 호출됨. userInput=${userInput}, systemMessage=${systemMessage}, model=${model}" }
        try {
            // 메시지 구성
            val messages = listOf(
                SystemMessage(systemMessage),
                UserMessage(userInput)
            )

            // 챗 옵션 설정
            val chatOptions = ChatOptions.builder()
                .model(model)
                .build()

            // 프롬프트 생성
            val prompt = Prompt(messages, chatOptions)

            // 챗 모델 생성 및 호출
            val chatModel = OpenAiChatModel.builder()
                .openAiApi(openAiApi)
                .build()

            return chatModel.call(prompt)
        } catch (e: Exception) {
            logger.error(e) { "OpenAI 챗 호출 중 오류 발생: ${e.message}" }
            return null // 예외가 발생하면 null을 반환하도록 설정
        }
    }
}