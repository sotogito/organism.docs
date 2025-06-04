```java
public void select() {
	int menuCode = 1;
	
	Menu foundedMenu1 = entityManager.find(Menu.class, menuCode);
	Menu foundedMenu2 = entityManager.find(Menu.class, menuCode);
}
```

- 조회된 Entity가 영속성 컨텍스트에 저장 - 관리대상
- 같은 @Id로 조회한다면 동일성(=\=)을 보장함


#### 조회 순서
1. EntityManager가 find기능 제공
2. EntityManager가 일단 영속성 컨텍스트에게 MenuCode가 있나 물어봄
3. <mark style="background: #FFF3A3A6;">1차 캐시 확인</mark> : menuCode를 pk로 하여 영속성 컨텍스트의 1차 캐시 공간을 확인함
4.  <mark style="background: #FFF3A3A6;">DB 확인</mark> : EntityManager가 내부적으로 Hibernate의 구현체를 호출하여  Hibernate가 쿼리 만들고 JDBC를 사용하여 DB 쿼리를 날림
5. 결과 받아옴
6. 객체 생성
7. 1차 캐시에 저장
8. 영속 상태로 전환 후 반환