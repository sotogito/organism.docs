#### GET
```js
fetch('/api/boards/1', { //fetch('/api/boards/1') -> method를 생략하여 작성해도 된다.
  method: 'GET'
})
  .then(response => {
    if (!response.ok) throw new Error('상세 조회 실패');
    return response.json();
  })
  .then(data => {
    
  })
  .catch(error => alert(error.message));

```

#### POST
```js
fetch('/api/boards', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify({
    title: document.getElementById('title').value,
    content: document.getElementById('content').value
  })
})
  .then(response => {
    if (!response.ok) throw new Error('등록 실패');
    return response.json();
  })
  .then(data => {
    alert('등록 성공: ' + data.msg);
    document.getElementById('regist_form').reset();
  })
  .catch(error => alert(error.message));

```


| 항목           | `GET` 방식                                        | `POST` 방식                                   |
| ------------ | ----------------------------------------------- | ------------------------------------------- |
| 목적           | 데이터 조회 (읽기)                                     | 데이터 생성/등록 (쓰기)                              |
| 데이터 전송 방식    | URL 쿼리스트링 (`?key=value`)로 전송                    | 요청 본문(body)에 담아 전송                          |
| `fetch()` 설정 | `fetch(url)` 또는 `fetch(url, { method: 'GET' })` | `fetch(url, { method: 'POST', body: ... })` |
| `body` 사용 여부 | ❌ 사용 불가 (`GET`은 body 지원 안 함)                    | ✅ 사용 가능 (JSON, FormData 등 전송 가능)            |
| 서버 처리 방식     | `@RequestParam` / `@PathVariable`               | `@RequestBody` / `@ModelAttribute` 등        |
