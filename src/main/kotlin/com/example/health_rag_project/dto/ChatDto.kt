package com.example.health_rag_project.dto

//DTO(Data Transfer Object) : 백엔드에서 요청/응답에 사용되는 데이터 구조

data class ChatRequest(
    val message: String
)

data class ChatResponse(
    val reply: String
)