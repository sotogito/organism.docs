- 초기화
```java
private void initRanks() {  
    for (Rank rank : Rank.values()) {  
        ranks.put(rank, 0);  
    }  
}
```
	초기화된 Map은 Enum 클래스에서 반환하도록 설계한다.

- value값 누적 더하기
```java
public void addAllMatchedRank(List<Rank> matchedResults) {  
    for (Rank rank : matchedResults) {  
        ranks.merge(rank, 1, Integer::sum);  
    }  
}
```