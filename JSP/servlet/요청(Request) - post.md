### index.html
```html
<form action="/servlet/request" method="post">
  <fieldset>
    이름: <input type="text" name="name"> <br>
    나이: <input type="number" name="age"> <br>
    취미:
    <input type="checkbox" name="hobby" value="sports"> 운동
    <input type="checkbox" name="hobby" value="reading"> 독서
    <input type="checkbox" name="hobby" value="movie"> 영화
    <br>

    <input type="submit" value="POST 방식으로 요청">
  </fieldset>
</form>
```
- 경로는 절대 경로를 권장한다.

### RequestServlet.java
```java
package com.sotogito.servlet.section02.http_request;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

/// urlmapping : /request

@WebServlet("/request")
public class RequestServlet extends HttpServlet{

    //http://localhost:8080/servlet/request?name=%E3%85%82%E3%85%88%E3%84%B7&age=123&hobby=sports&hobby=reading&hobby=movie
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LifeCycleServlet doGet\n");

        System.out.println("contextPath : " + req.getContextPath());
        System.out.println("URI : " + req.getRequestURI());     //URI : /servlet/request
        System.out.println("URL : " + req.getRequestURL());     //URL : http://localhost:8080/servlet/request

        String name = req.getParameter("name");
        System.out.println(name);
        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println(age);
        String[] hobbyList = req.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbyList));
    }


    //http://localhost:8080/servlet/request
    @Override /// url에 데이터가 보여지지 않음
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LifeCycleServlet doPost");
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        System.out.println(name);
        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println(age);
        String[] hobbyList = req.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbyList));
    }
    
}
```
- doPost() 메서드 실행
- POST 방식의 요청일 경우
- 파라미터들이 HTTP 본문body에 담겨 넘어오기 때문에 별도의 인코딩 처리 필요
- 파라미터 추출 전에 인코딩 처리하는 setCharacterEncoding() 메서드 실행
