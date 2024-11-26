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

- value값 누적 빼기,차감하기
```java
EnumMap.put(key값, EnumMap.get(key값) - 빼고싶은값);
```

#### 순서 반대로 Map 만들기
```java
EnumMap<Coin, Integer> enumMap = new EnumMap<>(Coin.class); 

LinkedHashMap<Coin, Integer> reversedMap = new LinkedHashMap<>();

for (int i = Coin.values().length - 1; i >= 0; i--) {
	Coin key = Coin.values()[i]; reversedMap.put(key, enumMap.get(key)); 
}
```