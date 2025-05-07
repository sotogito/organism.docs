##### for문으로 개수 새기

```java
    public int getMatchedCount(final Lotto randomLotto) {
        int result = 0;

        for (Integer userLottoNumber : numbers) {
            if (randomLotto.numbers.contains(userLottoNumber)) {
                result += 1;
            }
        }
        return result;
    }
```


##### Set으로 교집합 확인
```java
public int countMatchingElements(List<Integer> list1, List<Integer> list2) {
    Set<Integer> set = new HashSet<>(list1); // 첫 번째 리스트를 HashSet으로 변환
    set.retainAll(list2); // 교집합 계산
    return set.size(); // 교집합의 크기 반환
}
```
