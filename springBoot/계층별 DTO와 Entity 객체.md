- Request, Response : 클라이언트와 Controller간의 연결
- 그냥DTO : controller - service 의 연결

- service - repository : Entity

```
[Client] ⇄ [Controller] ⇄ [Service] ⇄ [Repository] ⇄ [DB]
     ↑           ↑             ↑             ↑
 RequestDTO   RequestDTO     Entity       Entity
 ResponseDTO  ResponseDTO
```

| 계층 간 관계                  | 사용되는 객체                          | 설명                                                  |
| ------------------------ | -------------------------------- | --------------------------------------------------- |
| **Client → Controller**  | ✅ `Request DTO`                  | 클라이언트 요청 파라미터 수신용 (`@RequestBody`, `@RequestParam`) |
| **Controller → Service** | ✅ `Request DTO` 또는 `Command DTO` | Service에 넘길 전달 객체 (필요시 변환)                          |
| **Service → Repository** | ✅ `Entity` 또는 `Domain 객체`        | 실제 DB와 매핑되는 객체 (JPA Entity 등)                       |
| **Repository → Service** | ✅ `Entity` 또는 도메인                | DB에서 꺼낸 값                                           |
| **Service → Controller** | ✅ `Response DTO`                 | 응답용 데이터 구조                                          |
| **Controller → Client**  | ✅ `Response DTO`                 | JSON 형태로 응답됨                                        |
