- 전달받은 요청과 응답을 바로 처리하지 않고 다음 servlet으로 전달하는 것

---
회원가입 페이지를 띄우는 
```java
@WebServlet("/first-step")
public class FirstStepServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("첫번째 목적지(경유지) 도착");

        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println("name=" + name + ", age=" + age);


        /// 현재 servlet에서 다른 servlet으로 이동 : forwarding (RequestDispatcher) /Dispatcher:보내는 사람
        RequestDispatcher rd = req.getRequestDispatcher("/second-step"); /// 서블릿 -> 서블릿
        rd.forward(req, resp); //mybatis에서 트랜젝션을 위하여 sqlSession넘겨주는거마냥 req,resp를  같이 넘겨줘야됨
        //단 url은 first-step, 클라이언크는 중간에 이동된 forward를 알 수 없음
    }
```
```java
@WebServlet("/second-step")
public class SecondStepServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("두번째 목적지 도착");

        /// 포워딩으로 첫번째 목적지에서 req, resp전달 했음
        System.out.println("name" + req.getParameter("name"));
        System.out.println("age" + req.getParameter("age"));

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<script>");
        out.println("alert('최종목적지도착')");
        out.println("</script>");
        out.flush();
        out.close();
    }
```

---
만약 회원가입 정적 페이지를 사용하자 요청하나다고 가정해보자 
```html
<a href="/servlet/member/memberRegist.html">회원가입 페이지로 이동(비권장)</a><br>
```
바로 html파일에 접근했을 경우 url은 다음과 같다. => -http://localhost:8080/servlet/member/memberRegist.htm
보이는 것과 같이 URL에
1. 디렉토리 구조가 유출된다.
2. html파일명이 유출된다.
그래서 사용자가 url파일을 조작하여 외부에서 접근할 가능성이 있다.

이럴때 사용하는 것이 포워딩이다.
1. servlet으로 요청을 받는다.
2. servlet에서 정적 html로 forward를 보낸다.
이렇게 되면 사용자에게는 매핑된 url값이 보이고, 실제 디렉토리나 html파일명이 유출되지 않는다.
```html
<a href="/servlet/registForm.me">회원가입페이지-servlet거치는 케이스(권장)</a>
```
```java
@WebServlet("/registForm.me")
public class MemberRegistFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /// 단순페이지(/member/memberRegist.html) 이동,
        /// url은 /registForm.me라고 찍히고 띄우는 건 html파일
        req.getRequestDispatcher("/member/memberRegist.html").forward(req, resp); ///서블릿 -> HTML
    }
```
```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<h1>회원가입페이지</h1>
</body>
</html>
```
