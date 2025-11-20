package com.example.health_rag_project.controller


import com.example.health_rag_project.dto.ChatRequest
import com.example.health_rag_project.dto.ChatResponse
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