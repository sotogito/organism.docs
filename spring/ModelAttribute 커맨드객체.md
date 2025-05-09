```java
@PostMapping("/regist3.do")  
public String memberRegist3(MemberDto member) {  
    log.debug("member: {}", member);  
  
    return "redirect:/";  
}
```
- 전달되는 파라미터들을 바로 객체의 필드에 담고자 할 경우 사용
- 파라미터명(name)을 담고자하는 DTO의 필드명과 동일하게 작성해야됨
``` jsp
<form action="${contextPath}/member/regist3.do" method="POST">  
  이름 : <input type="text" name="name"><br>  
  나이 : <input type="number" name="age"><br>  
  주소 : <input type="text" name="address">  
  <button type="submit">등록</button>  
</form>
```
```java
public class MemberDto {  
  
    private String name;  
    private int age;  
    private String address;  

}
```


<form action="${contextPath}/member/regist3.do" method="POST">  
  이름 : <input type="text" name="name"><br>  
  나이 : <input type="number" name="age"><br>  
  주소 : <input type="text" name="address">  
  <button type="submit">등록</button>  
</form>

- REST API 시대에 `@RequestBody`가 대세이긴 함
    
- 하지만 웹 애플리케이션이나 관리자 페이지처럼 **서버 렌더링 중심**인 경우엔 여전히 `@ModelAttribute` 많이 씀