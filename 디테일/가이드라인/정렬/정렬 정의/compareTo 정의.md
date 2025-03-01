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
    compareToIgnoreCase() //대소문자 구분 무시함
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
```java
@Override
public int compareTo(객체 o) {
    int 첫번째_비교결과 = 첫번째_필드_비교;
    if (첫번째_비교결과 != 0) {
        return 첫번째_비교결과; // 첫 번째 필드가 다르면 바로 반환
    }
    return 두번째_필드_비교; // 첫 번째 필드가 같을 때 두 번째 필드를 비교
}
```


---
##### compareTo의 원리
- this.변수 < o.변수
	- 음수 반환 <mark style="background: #FF5582A6;">-1</mark>
	- 앞으로 정렬
- this.변수 == o.변수
	- <mark style="background: #FF5582A6;">0</mark>반환
- this.변수 > o.변수
	- 양수 반환 <mark style="background: #FF5582A6;">+1</mark>
	- 뒤로 정렬

#### 복합 조건 예시
- 예시
	- 이름(오름차순) -> 나이(내림차순)
```java
    @Override
    public int compareTo(Person o) {
        // 첫 번째 조건: 이름 (오름차순)
        int nameComparison = this.name.compareTo(o.name);
        if (nameComparison != 0) {
            return nameComparison;
        }

        // 두 번째 조건: 나이 (내림차순)
        return -Integer.compare(this.age, o.age);

```

 - 3개
```java
@Override
public int compareTo(Person o) {
    int result = this.firstField.compareTo(o.firstField); // 첫 번째 필드 비교
    if (result != 0) return result;

    result = Integer.compare(this.secondField, o.secondField); // 두 번째 필드 비교
    if (result != 0) return result;

    return this.thirdField.compareTo(o.thirdField); // 세 번째 필드 비교
}

```