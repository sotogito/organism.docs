1. view에서 post로 요청을 보낸다.
2. 컨트롤러에서 POST 요청으로 데이터를 처리한다
3. redirect를 사용하여 결과 페이지로 이동한다.
4. GET 요청으로 결과 페이지를 새로 로드한다.

다음과 같은 방식은
- 새로 고침을 하더라도 데이터가 중복으로 제출되지 않도록 보장한다.
- view에서 요청은 post고 컨트롤러에서 연산후 새로운 페이지를 get해줘야하기 때문에 리다이렉트 해줘야한다. 리다이렉트를 해주지 않을 경우 브라우저는 post요청타입을 기억하기 때문에 사용자가 새로고침을 할때마다 데이터가 다시 로직에 들어간다.

```
@PostMapping("/modify.do")  
public String modifyBookList() {  
    /**  
     * 수정을 post하는 url은 modify.do이고 처리후 띄우는 jsp는 redirect     */    return "redirect:/book/detail.do?no=x";  
}
```
헌데 수정을 하고 book/detail.do?no=x로 url을 띄울거면 애초에 PostMapping값을 똑같이 설정하면 안될까? 왜  /modify.do로 사용하고 리다이렉트할까?
- 폼 데이터가 서버에 전달될 때 수정작업을 처리하는 url을 지정하기 위해서이다. 그래서 사용자에게는 보이지 않는다.

- /modify.do는 서버로 요청할 url인 것이다.