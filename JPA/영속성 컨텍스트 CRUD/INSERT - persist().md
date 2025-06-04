```java
public void insert() {
	Menu newMenu = Menu.builder()  
        .menuName("아아")  
        .menuPrice(2000)  
        .categoryCode(4)  
        .orderableStatus("Y")  
        .build();

	EntityTransaction transaction = entityManager.getTransaction();  
	transaction.begin();

	try {  
	    entityManager.persist(newMenu); ///1차 캐시에 담음  
		  //entityManager.flush(); db에 명시적으로 commit전에 일단 담음 -> commit전이라 rollback가능
	    transaction.commit(); /// db에 담음  
	} catch (Exception e) {  
	    transaction.rollback();  
	}
}
```
- 트랜잭션을 지원하는 쓰기 지연 가능
- transaction.commit(); = ntityManager.flush(); + commit();

#### persist()
비영속 상태의 객체를 영속 상태로 전환 시키는 메서드

#### 순서
1. 비영속 Menu객체 생성
2. EntityTransaction 생성 및 시작
3. emtityManager가 persist()호출 - 1차 캐시에 담음
4. EntityTransaction 커밋 = db에 쿼리날리고 커밋함 (컨텍스트-db 동기화)

