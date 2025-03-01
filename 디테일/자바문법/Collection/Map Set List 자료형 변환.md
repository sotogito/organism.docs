배열은 그냥 toArray();적으면 됨

- Set → List
    
    1. 리스트 생성 + addAll
    
    ```java
            List<String> list1 = new ArrayList<>();
    	        list.addAll(list);
    ```
    
    1. 리스트 바로 생성 & List.copyof(set)`
    
    ```java
    List<String> list = new ArrayList<>(stringSet);
    
     List<String> list = List.copyOf(stringSet); //불변
    ```
    
    1. 반복자 Iterator - 순회목적, 값변경 불가, 단방향, 일회성
    
    ```java
    Iterator<String> iterator = set.iterator();
    ```
    
- Map → List
    
    1. 리스트 생성
    
    ```java
    List<String> keyList = new ArrayList<>(map.keySet()); //key
    
    List<Integer> valueList = new ArrayList<>(map.values()); //value
    
    List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet()); //entry
    ```
    
- Map → Set
    
    1. EntrySet
    
    ```java
     Set<Map.Entry<String,Object>> entrySet = map.entrySet();
    ```
    
1. keySet
    ```java
 Set<String> keySet = stu2.keySet();
```


---
### Map → Set

- KeySet 생성하기

```java
 Set<key자료형> keySet = map.keySet();
```

- EntrySet생성하기
```java
Set<Map.Entry<key, value>> entries = map.entrySet();
```