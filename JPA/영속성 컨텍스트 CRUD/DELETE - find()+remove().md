```java
public void delete() {  
    int menuCode = 14;  
  
    Menu menu = entityManager.find(Menu.class, menuCode); ///1차 캐시에 저장 + 영속 상태 진입  
  
    EntityTransaction transaction = entityManager.getTransaction();  
    transaction.begin();  
  
    try {  
        entityManager.remove(menu); /// 해당 엔티티를 삭제 예약 상태로 표시, 영속성 컨텍스트에서 해당 엔티티를 삭제 대기 큐에 등록  
        /// 여기까지는 DB에 DELETE 쿼리가 전혀 실행되지 않음 -> 쓰기 지연        transaction.commit(); ///내부적으로 flush()가 자동 호출, DB삭제  
    } catch (Exception e) {  
        transaction.rollback();  
    }  
}
```
- remove메서드를 호출하는 순간 영속성 컨텍스트에서 제거
