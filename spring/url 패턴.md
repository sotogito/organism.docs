#### REST 방식 개발
1. FE, BE를 완벽하게 분리
2. 백엔드에서는 요청에 따라 페이지 forwarding 또는 redirect가 아닌 요청에 필요한 데이터(자원, 리소스)만을 응답함
3. url 패턴 : <mark style="background: #D2B3FFA6;">리소스(자원) 중심</mark>, 복수형 명사로 표현
	- 조회(GET)     : /books/1
	- 생성(POST)   : /books/1 
	- 수정(PUT)      : /book/1
	- 삭제(DELETE) : /book/1  
	
(url이 get과 중복되어도 요청 방식이 달라서 가능)
#### REST 방식 개발 X
1. FE, BE 함께 개발 - 모노리틱 아키텍처
2. 백엔드에서는 요청에 따라서 로직을 실행하고 forwarding 또는 redirect를 진행
3. url 패턴 : <mark style="background: #D2B3FFA6;">행동 중심</mark>, 동사형으로 표현
	- /login.do
	- /getUserList.do
	- /user_list.do
	- ***/user/modify.do*** 

- 조회요청(페이지이동) : \*.page
- 추가/수정/삭제요청(데이터변경) : \*.do