#### Integer
```java
@Override
public int compareTo(객체 o) {
    return Integer.compare(this.변수, o.변수);
}
```

#### String
```java
@Override
public int compareTo(객체 o) {
    return this.변수.compareTo(o.변수);
}
```

#### Double, Float
```java
@Override
public int compareTo(객체 o) {
    return Double.compare(this.변수, o.변수);
}
```

#### Boolean
- false < true
```java
@Override
public int compareTo(객체 o) {
    return Boolean.compare(this.변수, o.변수); 
}
```

#### LocalDate, LocalDateTime - 날짜
```java
@Override
public int compareTo(객체 o) {
    return this.변수.compareTo(o.변수); 
}
```

#### 내림차순
- 기본 정렬은 오름차순이다.
```java
@Override
public int compareTo(객체 o) {
    return -this.변수.compareTo(o.변수); 
}
```
- 또는 정렬시 `Comparator.reverseOrder()` 를 사용한다.

#### 복합 조건
