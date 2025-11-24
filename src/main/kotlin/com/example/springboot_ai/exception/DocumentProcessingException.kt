package com.example.springboot_ai.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException


//문서 처리 도중 발생하는 다양한 오류를 처리하기 위한 공통 예외 클래스
class DocumentProcessingException(message: String, cause: Throwable? = null) :
    ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, message, cause)