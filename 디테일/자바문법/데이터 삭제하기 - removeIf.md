```java
리스트.removeIf(result -> result.isSame로직(삭제데이터));
```


---
#### 잘못된 구현
```java
for (PairResult result : pairResults) { 
	if(result.isSameMissionType(pairResult)){
		 pairResults.remove(result); 
	} 
}
```
리스트를 for-each문을 돌리면서 삭제하게 되면 동시성 문제로 예외가 발생한다.
.ConcurrentModificationException`