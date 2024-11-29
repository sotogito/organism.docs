<mark style="background: #FFF3A3A6;">따로 -`Comparator`클래스로 비교하기 위해서는 비교값의 getter이 필요하다.</mark>

```java
public class 객체-Comparator implements Comparator<객체> {
```
#### Integer
```java
@Override
public int compare(객체 o1, 객체 o2) {
    return Integer.compare(o1.변수, o2.변수); // 오름차순
}
```

#### String
```java
@Override
public int compare(객체 o1, 객체 o2) {
    return o1.변수.compareTo(o2.변수); // 사전순 정렬
}
```

#### Double, Float
```java
@Override
public int compare(객체 o1, 객체 o2) {
    return Double.compare(o1.변수, o2.변수); // 오름차순
}
```

#### Boolean
- false < true
```java
@Override
public int compare(객체 o1, 객체 o2) {
    return Boolean.compare(o1.변수, o2.변수);
}
```

#### LocalDate, LocalDateTime - 날짜
```java
@Override
public int compare(객체 o1, 객체 o2) {
    return o1.변수.compareTo(o2.변수); // 오름차순
}
```

#### 내림차순
- 기본 정렬은 오름차순이다.
```java
@Override
public int compare(객체 o1, 객체 o2) {
    return -Integer.compare(o1.변수, o2.변수); // 내림차순
}
```

#### 복합 조건
```java
@Override
public int compare(객체 o1, 객체 o2) {
    int 첫번째_비교결과 = o1.첫번째_필드.compareTo(o2.첫번째_필드);
    if (첫번째_비교결과 != 0) {
        return 첫번째_비교결과; // 첫 번째 필드가 다르면 결과 반환
    }
    return Integer.compare(o1.두번째_필드, o2.두번째_필드); // 두 번째 필드 비교
}
```

---
#### 람다식으로 Comparator 정의
```java
Comparator<객체> comparator = (o1, o2) -> -Double.compare(o1.get변수(), o2.get변수());
```

#### getter 참조를 사용한 Comparator
- 오름차순
```java
Comparator<객체> comparator = Comparator.comparing(객체::get변수);
```
- 내림차순
```java
Comparator<객체> comparator = Comparator.comparing(객체::get변수).reversed();
```