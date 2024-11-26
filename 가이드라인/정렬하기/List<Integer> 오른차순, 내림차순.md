`List<Integer> result = new ArrayList<>();`

#### 오름 차순 1,2,3,4,5
```java
result.sort(null);

Collections.sort(result);
```

#### 내림 차순 5,4,3,2,1
```java
result.sort(Comparator.reverseOrder());

Collections.sort(result, Comparator.reverseOrder());
```