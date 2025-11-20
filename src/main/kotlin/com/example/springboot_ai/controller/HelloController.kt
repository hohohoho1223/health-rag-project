package com.example.springboot_ai.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/hello")
    fun hello(): String = "안녕하세요! 서버 정상 동작 확인 되었습니다!"
}