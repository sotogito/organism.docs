IoC : Inversion of Control : 개발자가 아닌 프레인워크가 프록르ㅐㅁ의 흐름을 전반적으로 제어함

- 스프링이 관리하는 객체(Bean)들이 담겨있는 공간
- 기본적으로 Bean을 등록하면 싱글톤이 적용 (scope = "singleton")
- 개발에 필요한 객체들을 Bean으로 등록하여 사용하면 됨
	보통
	1. Controller
	2. Service
	3. Repository