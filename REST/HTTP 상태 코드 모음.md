| 상태 코드 | HttpStatus 값 (Spring)              | 의미                    | REST에서의 용도             |
| ----- | ---------------------------------- | --------------------- | ---------------------- |
| `200` | `HttpStatus.OK`                    | 요청 성공                 | 일반적인 GET 응답            |
| `201` | `HttpStatus.CREATED`               | 자원 생성 성공              | POST로 리소스 생성 시         |
| `202` | `HttpStatus.ACCEPTED`              | 요청 수락, 아직 처리 전        | 비동기 큐 등에 활용            |
| `204` | `HttpStatus.NO_CONTENT`            | 성공했지만 응답 본문 없음        | DELETE 후 응답, 간단한 성공 응답 |
| `301` | `HttpStatus.MOVED_PERMANENTLY`     | 영구 리디렉션               | URL 변경 안내              |
| `302` | `HttpStatus.FOUND`                 | 임시 리디렉션               | 로그인 후 리디렉션             |
| `304` | `HttpStatus.NOT_MODIFIED`          | 변경 없음 (캐시 사용)         | ETag / 캐시 유효 시         |
| `400` | `HttpStatus.BAD_REQUEST`           | 잘못된 요청                | 유효성 검사 실패, 파라미터 누락 등   |
| `401` | `HttpStatus.UNAUTHORIZED`          | 인증 필요                 | 로그인 안 된 요청             |
| `403` | `HttpStatus.FORBIDDEN`             | 권한 없음                 | 로그인 했지만 권한 부족          |
| `404` | `HttpStatus.NOT_FOUND`             | 자원 없음                 | 없는 ID 등 잘못된 경로         |
| `409` | `HttpStatus.CONFLICT`              | 요청 충돌                 | 중복된 자원 생성 시            |
| `422` | `HttpStatus.UNPROCESSABLE_ENTITY`  | 처리 불가 (형식은 맞지만 의미 오류) | 유효성은 통과했지만 비즈니스 로직 거부  |
| `500` | `HttpStatus.INTERNAL_SERVER_ERROR` | 서버 내부 오류              | 예외 발생, 시스템 장애          |
| `503` | `HttpStatus.SERVICE_UNAVAILABLE`   | 서버 사용 불가              | 점검, 과부하 등으로 임시 중지      |
