| 목적    | 메서드      | URL                | 설명          |
| ----- | -------- | ------------------ | ----------- |
| 전체 조회 | `GET`    | `/api/boards`      | 게시글 목록 가져오기 |
| 상세 조회 | `GET`    | `/api/boards/{id}` | 특정 게시글 가져오기 |
| 등록    | `POST`   | `/api/boards`      | 게시글 생성      |
| 수정    | `PUT`    | `/api/boards/{id}` | 게시글 전체 수정   |
| 일부 수정 | `PATCH`  | `/api/boards/{id}` | 게시글 일부 수정   |
| 삭제    | `DELETE` | `/api/boards/{id}` | 게시글 삭제      |
1. 자원은 URI로 표시하고, 행위는 HTTP Method로 표시함  
2. URI의 계층 구분은 슬래시(/)로 하고, 마지막엔 슬래시(/)를 표시하지 않음  
3. 소문자만 사용하고, 밑줄(_) 대신 하이픈(-)을 사용함  
4. 특정 파일 포맷의 경우 확장자를 생략함. 대신 Accept 헤더에 지정함  
5. <mark style="background: #FFB86CA6;">동작이나 행위를 의미하는 단어를 사용하지 않음 </mark> 
   /user/regist, /user/list, /user/detail, /user/modify, /user/remove 등을 지양함  
6. 가급적이면 명사를 사용. 동사를 지양함  
7. 쿼리 스트링 방식이 아닌 경로 변수 방식을 사용함  
   8) 쿼리 스트링 : /users?userId=1  
   9) 경로 변수   : /users/1