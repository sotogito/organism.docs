
```java
public enum Coin { 
	COIN_500, // ordinal() = 0 
	COIN_100, // ordinal() = 1 
	COIN_50, // ordinal() = 2 
	COIN_10; // ordinal() = 3
	
	private final int amount;
```

`List<Coin> coins = new ArrayList<>(List.of(Coin.values()));`

- 오름차순 & 내림차순 정렬
```java
coins.sort(Comparator.comparingInt(Coin::getAmount)); //오름차순
coins.sort(Comparator.comparingInt(Coin::getAmount).reversed()); //내림차순
```

- 특정 필드 최대& 최소
```java
Coin maxCoin = Collections.max(coins, Comparator.comparingInt(Coin::getAmount));
Coin minCoin = Collections.min(coins, Comparator.comparingInt(Coin::getAmount));
```

- 상수화 순서로 최대 & 최소
```java
Coin minCoin = Collections.min(coins); // ordinal() = 0 맨 위의 값
Coin maxCoin = Collections.max(coins); //ordinal() = 3
```

---
Enum은 EnumMap에 넣으면 선언된 순서대로 value값이 들어가듯, Comparable이 정의되어있다.  
즉 Comparable-  compareTo로 재정의 <mark style="background: #FF5582A6;">해줄 수 없다.</mark>❌