## JSP에서 페이지 가공시 사용할 데이터 담기 => JSP 내장객체 ##
#### application (ServletContext) -------------------------잘안씀
   1) 한 애플리케이션당 단 1개 존재하는 객체
   2) 애플리케이션에 유지할 데이터 담기
   3) 애플리케이션 종료 전까지 애플리케이션 전역에서 데이터 사용 가능
#### session (HttpSession)---------------씀
   1) 한 브라우저당 1개 존재하는 객체
   2) 브라우저에 유지할 데이터 담기
   3) 브라우저 종료 전|서버 종료 전까지 jsp/servlet 단에서 데이터 사용 가능
    -> 사용자가 로그인해서 세션이유지되는동안 데이터가 살아있음
#### request (HttpServletRequest)---------------------------많이씀
   1) 한 요청당 1개 존재하는 객체
   2) 해당 요청에 대한 응답페이지에 사용할 데이터 담기
   3) forward에 의해 해당 request가 전달된 Servlet, JSP에서만 데이터 사용 가능
    -> 하나의요청에서만 사용 가능 (forward해도 유지)
#### pageContext
   1) 한 jsp당 1개 존재하는 객체
   2) 해당 페이지에 필요한 데이터를 해당 페이지에서 담을 수 있음
   3) jsp에서 담고 해당 jsp에서만 사용 가능

## Serlvet에서 해당 객체 접근 방법
1) ServletContext     : request.getServletContext()
2) HttpSession        : request.getSession()
3) HttpServletRequest : 매개변수로 이미 존재
4) PageContext      : 접근 불가

## 해당 객체들의 공통메소드
1) Attribute 담기  : .setAttribute("attributename", 담고자하는데이터)
2) Attribute 꺼내기   : .getAttribute("attributename") - Object로 꺼내짐
3) Attribute 제거하기 : .removeAttribute("attributename")

---
```java
        ///  request Scope에 attribute 담기
        req.setAttribute("classRoom", "2강의장");
        req.setAttribute("student", new PersonDto("홍길동", 20, "남자"));

        /// session Scope에 attribute 담기
        HttpSession session = req.getSession();
        session.setAttribute("teacher", new PersonDto("김말순", 36, "여자"));

        /// application Scope attribute 담기
        ServletContext application = req.getServletContext();
        application.setAttribute("academy", "ssg");
```
```jsp
  <%
    String classRoom = (String) request.getAttribute("classRoom");
    PersonDto student = (PersonDto) request.getAttribute("student");
    
    PersonDto teacher = (PersonDto) session.getAttribute("teacher");
    
    String academy = (String) application.getAttribute("academy");
  %>
```
