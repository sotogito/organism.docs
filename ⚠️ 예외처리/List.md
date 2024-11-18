### List Integer

- Set 사용해서 중복 검사
```java
private void validateLottoDuplicate(List<Integer> numbers) {  
    Set<Integer> numbersSet = new HashSet<>(numbers);  
    if (numbersSet.size() != numbers.size()) {  
        throw new IllegalArgumentException();  
    }  
}
```
