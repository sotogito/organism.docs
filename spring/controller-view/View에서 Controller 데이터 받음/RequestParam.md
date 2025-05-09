#### RequestParam
```java
@PostMapping("/regist2.do")  
public String memberRegist2(@RequestParam String name,  
                            @RequestParam(defaultValue = "0") int age, 
                            @RequestParam(value = "address") String add) {  
  
    log.debug("이름{} 나이{} 주소{}", name, age, add);  
  
    return "redirect:/";  
}
```
- 만약 요청 값(name) 과 파라미터명이 같다면 value 명시가 생략이 가능. `@RequestParam int age`
- value 없이 바로 값 작성 가능 `@RequestParam("address")`
- 어노테이션도 생략 가능하지만 명시하는 것이 안전함 `String name`
* 만약 입력하지 않을 경우 빈문자열로 반환된다.  age의 경우는 입력값이 없을 경우  Integer.parseInt하는 과정에서 400 오류가 뜬다.  때문에 기본값(defaultValue) 을 작성해줘야한다.

- 폼 전송 방식에서 주로 사용
- 쿼리 스트링 (`?name=홍길동&age=20`) 또는 폼 필드 전송 시 사용
- 간단한 값들 받을 때 적합 (문자열, 숫자 등)
