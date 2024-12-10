#### 선언
```java
Map<Integer,String> map = new HashMap<>();
```

#### Key로 Value 찾기
```java
String 찾은valuee값 = map.get(key 값);
```

#### Value로 Key 찾기
- `Map`에서 Value를 기준으로 Key를 찾으려면 **전체를 순회**해야함
```java
        for (Map.Entry<String, String> entry : map.entrySet()) {
        }
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

#### Map 인덱스로 순회하기
- 애초에 Map은 인덱스로 값을 조회할 수 없다. 때문에 Entry의 형태가 필요하다.
```java
List<Map.Entry<키, 밸류>> entryList = new ArrayList<>(맵.entrySet());

Map.Entry<LocalDate, Staff> entry = entryList.get(i);  
LocalDate date = entry.getKey();  
Staff staff = entry.getValue();
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


---

#### Key, Value값 변경하기
- Key 변경하기 : 삭제 후 새로운 key 넣기
```java
if (map.containsKey("oldKey")) { 
	String value = map.remove("oldKey"); //value값을 반환함
	map.put("newKey", value); 
}
```
- value 변경하기 : 새로운 value로 덮어씌우기
```java
map.put("key", "newValue");
```

