# Health RAG Project (Kotlin + Spring Boot)


- [kotlin 언어 + springboot] 조합으로  
  **OpenAI API 호출 → 답변 받는 기본 챗봇 시스템**을 구현하며  
  Spring Boot의 흐름(Controller → Service → DTO)을 이해하는 것을 목표로 함

## 구현 기능 목록

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

### 4. RAG기능 구현
- [x] RAG Controller API 구현\
  - PDF 파일 업로드
  - 사용자 질의 + 문서 검색 + 답변 생성
- [x] 문서 임베딩 (EmbeddingService) 구현
- [x] 벡터 저장소 (InMemoryDocumentVectorStore) 구현
- [x] 예외 처리 (DocumentProcessingException) 설정
- [x] DTO 계층 정리
  - DocumentUploadResponseDto 
    - 문서 업로드 후 생성된 documentId, chunk 개수 포함
  - DocumentSearchResultDto 
    - 검색된 문서 조각 및 유사도 점수 목록 포함
  - RagQueryResponseDto 
    - 최종 LLM 답변 + 참고로 사용된 문서 데이터 포함
  - ApiResponseDto (공통 응답 포맷)
    - 모든 API 응답을 통일된 구조(success/data/error)로 전달

### 5. 환경 변수 및 설정
- [x] `application.properties` 에 OpenAI API Key 설정 
- [x] `spring.ai.openai.model=gpt-4o-mini` 기본 모델 설정  
  - Swagger에서 별도 모델 입력 시 해당 값이 우선 적용됨

### 6. 프로젝트 구조 정리
- Controller  
  - 요청 처리, DTO 입력/출력, ApiResponse 포맷 반환
- Service  
  - Prompt 구성, OpenAI 호출, ChatResponse 생성 및 반환
- DTO  
  - 요청(Request)/응답(Response) 구조 정의


## 개발 환경 (Environment)

- JDK 21
- Kotlin 2.0
- Spring Boot 3.5.x
- Gradle 8.x (Kotlin DSL)
- IntelliJ IDEA (Ultimate)

