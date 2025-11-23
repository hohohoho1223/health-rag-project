# Health RAG Project (Kotlin + Spring Boot)

## 우아한테크코스_프리코스_프로젝트

- [kotlin 언어 + springboot] 조합으로  
  **OpenAI API 호출 → 답변 받는 기본 챗봇 시스템**을 구현하며  
  Spring Boot의 흐름(Controller → Service → DTO)을 이해하는 것을 목표로 한다.

## 구현 기능 목록 (우테코 스타일 Todo List)

### 1. 개발환경 세팅
- [x] Spring Boot 프로젝트 생성 (Kotlin, Gradle)

### 2. 기본 API 구축
- [x] `/hello` API 구현 (서버 정상 동작 확인)
- [x] `ChatRequest`, `ChatResponse` DTO 생성
- [x] `/api/chat/echo` API 구현 (입력 메시지 → 그대로 응답 하는지)

### 3. OpenAI API 연동
- [x] `OpenAiConfig.kt` 생성  
  - OpenAI API Key 로딩  
  - `OpenAiApi`, `OpenAiChatModel` Bean 등록
- [x] `ChatService.kt` 구현  
  - Prompt 구성(SystemMessage + UserMessage)  
  - 모델 호출 및 ChatResponse 생성  
  - 예외 발생 시 null 반환 처리
- [x] `/api/chat/query` 엔드포인트 구현   
  - ApiResponse 포맷으로 JSON 응답  
  - Swagger로 테스트 가능


## 개발 환경 (Environment)

- JDK 21
- Kotlin 2.0
- Spring Boot 3.5.x
- Gradle 8.x (Kotlin DSL)
- IntelliJ IDEA (Ultimate)

