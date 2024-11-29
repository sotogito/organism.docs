#### 선언
```java
Map<Integer,String> map = new HashMap<>();
```

#### 값 추가
```java
map.put(key값,value값);
```

#### 값 삭제
```java
map.remove(1); //key값 1 삭제
map.clear(); //모두 삭제
```

#### 순회 - 출력
```java
for(Map.Entry<Integer,String> entry : map.entrySet()) {
	System.out.println(entry.getKey());
	System.out.println(entry.getValue());
}
```

```java
for (int i : map.keySet()) {
	key : i
	valur : map.get(i);
}
```

```java
Iterator<Integer> keys = map.keySet().iterator();
while(keys.hasNext()){
    key = keys.next();
    value = map.get(key);
}
```

#### Integer 값 조정하기
- 더하기
```java
map.merge(key값, 더할값, Integer::sum);  
```

```java
map.put(key값, map.get(key값)+더할값);
```

 ⚠️ 만약 존재하지 않는 key의 값을 증기시킬 경우에 `NullPointerException` 이 발생한다.
 getOrDefault를 사용하여 대비한다.  
 ```java
map.put(key값, map.getOrDefault(key값,0)+1);
```
- key가 존재할 경우 ⭕️ : 기존값 +1
- key가 존재하지 않을 경우 ❌ : 0(초기값) +1 

#### 특정 key 포함 유무 - boolean
```java
boolean isExist = map.containsKey(key값);
```

#### Map이 같은지 확인 - boolean
```java
boolean isSame = map1.equals(map2);
```