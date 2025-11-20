package com.example.springboot_ai.controller

import com.example.springboot_ai.dto.ChatRequest
import com.example.springboot_ai.dto.ChatResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/chat")
class ChatController {

    @PostMapping("/echo")
    fun echo(@RequestBody req: ChatRequest):  ChatResponse{
        return ChatResponse(
            reply = "백엔드가 받은 메세지는 다음과 같음: ${req.message}"
        )
    }
}