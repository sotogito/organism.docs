| 방법                                                   | 설명                     | 사용 용도                        |
| ---------------------------------------------------- | ---------------------- | ---------------------------- |
| **1. `try-catch` 블록**                                | 자바 기본 예외 처리            | 아주 구체적인 예외 제어가 필요할 때         |
| **2. `@ExceptionHandler`**                           | 컨트롤러 단위 예외 처리          | 특정 컨트롤러 내부에서만 처리하고 싶을 때      |
| **3. `@ControllerAdvice` / `@RestControllerAdvice`** | **전역(Global)** 예외 처리   | 모든 컨트롤러에 공통 적용 (실무에서 가장 일반적) |
| 4. ResponseStatusException                           | 예외를 **즉시 HTTP 상태로 변환** | 단순한 에러 응답을 빠르게 처리할 때         |
| 5. HandlerExceptionResolver 구현                       | Spring 예외 처리 전략 커스터마이징 | 고급 커스터마이징 필요 시 (거의 안 씀)      |
- 보통 @RestControllerAdvice + 사용자정의예외 + @ExceptionHandler 사용