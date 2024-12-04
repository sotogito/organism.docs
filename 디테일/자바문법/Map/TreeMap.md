- 이진트리를 기반한다.
- HashMap보다는 느리지만 정렬에서 유리하다.
- <mark style="background: #D2B3FFA6;"> Key값을 기준으로 정렬을 유지하는 자료구조이다.</mark>
	- 기본 자료형 기본 정렬 - **오름차순**
		- Integer, Double : 값
		- String : 유니코드
	- 객체 정렬
		- <mark style="background: #FFF3A3A6;">compareTo로 정의 필요</mark>
		- *정의하지 않을 경우 예외가 터진다.*
---
#### 선언
```java
TreeMap<Integer,String> map = new TreeMap<>();
```

#### 순서에 따른 값 뽑아내기
- key 반환
```java
map.get(1);

map.firstKey(); //첫번째 key 반환
map.lastKey(); //마지막 key 반환
```

- Entry 반환
```java
map.firstEntry();  //첫번째 [key-value]를 반환
map.lastEntry(); //마지막 [key-value]를 반환
```
⁇ Entry 반환이란? 최소 키와 그 키에 해당하는 값(value)을 포함하는 `Map.Entry` 객체를 반환
`Map.Entry<Integer, String> firstEntry = map.firstEntry();`
`System.out.println(firstEntry.getKey());   // 출력: 1`
`System.out.println(firstEntry.getValue()); // 출력: One`

#### 내림차순 정렬 - (기본은 오른차순임)
- <mark style="background: #FFF3A3A6;">Comparator.reverseOrder() 사용</mark>
```java
TreeMap<Integer, String> downMap = new TreeMap<>(Comparator.reverseOrder());
```
- 람다식
```java
TreeMap<Integer, String> downMap = new TreeMap<>((a, b) -> b - a);
```

- descendingMap()
	- 보통 출력할때만 사용.
```java
NavigableMap<Integer, String> downMap = upMap.descendingMap();
```
