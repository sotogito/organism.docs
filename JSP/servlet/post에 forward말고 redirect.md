get 같은 경우는 요청에 대한 응답을 forward로 해도 된다. 그게 맞다  
하지만 받아온 데이터를 처리한 후 응답 페이지를 띄우는 post의 경우에는 forwrad로 보내면 안된다. 

이는 브라우저가 알고있는 처리 method방식과,  
새로고침 이슈 때문이다.  

#### GET
- 테이터 요청 ( 조회_)
- 데이터가 url에 쿼리스트링으로 붙음
- url에 정보가 노출됨
- 검색, 목록 조회 등
#### POST
- 데이터 전송/ 처리 (등록, 수정)
- 데이터가 요청 본문에 담겨 전송 <form action="/login" method="post">
- 회원가입, 글쓰기, 로그인 등

  
즉, 간단히 말해보자면 get은 읽기용이고 post는 쓰기 용이다.  

위에 언급했듯 post는 body html본문에 method를 정의해둔다. 
그래서 서버로 데이터를 전송하고 서버에서 응답을 새로운 html로 전달할 경우 브라우저의 url은 변경되지않는다.  
forward로 화면은 변경되지만 브라우저의 반환 형태는 여전히 post이다.
```java
  req.getRequestDispatcher("/board/boardList.html").forward(req, resp);
```
```html
  <h2>게시글등록 페이지</h2>

  <form action="/servlet/board/regist" method="post">
    제목 : <input type="text" name="title">
    내용 : <textarea name="content"></textarea><br><br>

    <button type="submit">글등록</button>
  </form>
```
post결과를 서버에서 forward로 /board/boardList.html응답해도 화면만 변경될뿐 url은 변경되지 않음  
이 경우의 가장 큰 문제점은 만약 사용자가 그 상태에서 새로고침을한 경우 다시 결과가 서버로 요청된다는 말이다.  
즉 중복되어 등록되어버린다.  
왜냐면 브라우저는 지금 보고있는 화면이 어떤 요청에 대한 응답인지(post) 기억하기 때문이다.  
 화면이 forwrad된 html로 변경되었지만 브라우저의 입장에서는 여전히 "POST /board/regist"에 대한 응답을 지금 보고 있는 것과 마찬가지다.  

 ### 그래서 redirect
 
redirect 는 Status가 302. 즉, 임시저장이다.