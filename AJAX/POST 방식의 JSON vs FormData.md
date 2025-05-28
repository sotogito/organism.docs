GET 조회의 방식의 경우에는 거의 JSON 방식을 사용한다.  
POST는 크게 2가지 방법으로 나뉜다.
#### JSON
```js
fetch('/api/register', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify({
    title: '제목',
    content: '내용'
  })
});
```

```java
@PostMapping("/api/register")
public void register(@RequestBody BoardDto dto) { ... }
```
- `@RequestBody`로 JSON을 파싱해서 받음
#### FormData
```js
const formData = new FormData();
formData.append('title', '제목');
formData.append('content', '내용');
formData.append('file', fileInput.files[0]);

fetch('/board/regist', {
  method: 'POST',
  body: formData
});
```

```java
@PostMapping("/board/regist")
public void regist(@ModelAttribute BoardDto dto,
                   @RequestParam MultipartFile file) { ... }
```
- `ModelAttribute`, `@RequestParam`, `MultipartFile`로 받음

|항목|JSON 방식 (`application/json`)|FormData 방식 (`multipart/form-data`)|
|---|---|---|
|전송 타입|JSON 문자열 (`Content-Type: application/json`)|`multipart/form-data` (브라우저가 자동 설정)|
|데이터 구성|JS 객체 → JSON.stringify()로 문자열화|`FormData` 객체에 필드와 값 추가|
|파일 전송|❌ 지원 안 함 (별도 처리 필요)|✅ 파일 전송 (`append('file', file)`) 가능|
|서버에서 받는 방법|`@RequestBody` (Spring 기준)|`@ModelAttribute`, `@RequestParam`, `MultipartFile`|
|사용 예시|API 요청, JSON API, REST|폼 전송, 파일 업로드, 간단한 데이터 조합|
|직관성/가독성|✅ 구조화된 JSON|❌ 문자열처럼 보임 (개발자 입장에서 복잡할 수 있음)|