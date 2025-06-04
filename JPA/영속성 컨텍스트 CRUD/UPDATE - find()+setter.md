```java
public void update() {
	int menuCode = 2;  
	String menuNameToChange = "갈치스무디";
	
	Menu menu = entityManager.find(Menu.class, menuCode); //영속성 조회
	
	EntityTransaction transaction = entityManager.getTransaction();  
	transaction.begin();
	
	try {  
    menu.setMenuName(menuNameToChange); /// 1차 캐시에서 변경
    transaction.commit(); /// db 변경,    
} catch (Exception e) {  
    transaction.rollback();  
}
}
```
- 영속성 엔티티를 수정
- 영속성 조회 후 setter로 수정
- dirty checking- 만약 스냅샷과 비교하여 수정 사항이 없을경우 db 접근 안함

#### 순서
1. 엔티티매니저가 find로 찾아옴(개시->db) + menu는 영속적으로 컨텍스트(1차 캐시)에 저장
2. EntityTransaction 생성 및 시작
3. 1차 캐시에 있는 영속성 엔티티의 필드를 setter로 변경
4. db에 접근
5. <mark style="background: #FFF3A3A6;">엔티티의 모들 필드를 영속성 엔티티 기준으로 업데이트함</mark>
6. 1차 캐시에 있는 엔티티와 db의 동기화