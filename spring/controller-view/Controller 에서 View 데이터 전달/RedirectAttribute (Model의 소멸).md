- model은 forward된 페이지 에서만 사용 가능하다. (redirect 안됨) 예를들어 수정후 성고 실페의 결과를 사용자에게 출력하기 위해 Model에 addAttriute해서 보내도 메시지를 사용할 수 없다. 
- 왜냠 Model은 requestScope이기 때문에 곧바로 포워딩하는 페이지에서만 사용 가능ㅎ다,. 
- 즉. redirect로 다른 컨트롤러가 재실행(이미 get이 매핑되어있는 url로)이 되는 순간 Model은 소멸된다.
- 즉 중간에 다른 매핑url을 거쳐간다면 원본의 Model은 최종 view에서 소멸되어 사용할 수 없다.
- Spring MVC는 **하나의 HTTP 요청(request)** 당  
**하나의 `Model` 객체를 생성해서 뷰 렌더링 시점까지 유지** 
$$
(controller -> view) : Model = 1:1
$$


그럼어덯게해결? -> RedirectAttribute


"redirect 이후에도 데이터를 전달해야 할 경우"에만 쓰는 거야.







