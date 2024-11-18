- 선언
```java
Pattern pattern = Pattern.compile(정규식);
```

- Pattern.matches
```java
boolean result = Pattern.matches(정규식, 비교할 문자열); 
```
	전체 문자열이 완벽하게 일치해야한다.

- Pattern 정규식에 input데이터 Matcher 생성하기
```java
Matcher matcher = Pattern.compile(정규식).matcher(input);
```
	matcher.matches() 
		만약 input이 정규식과 다르다면 false이다.

