- 정규식으로 특정 양식 삭제하기
```java
String value = input.replaceAll("//(.)\\\\n", "");
```

- 정규식으로 숫자 삭제하기
```java
String result = input.replaceAll("\\d+", "");
```

- 정규식으로 문자 제거하기
```java
String result = input.replaceAll("[a-zA-Z]", "");
```

- 정규식으로 특수문자 제거하기
```java
String result = input.replaceAll("[^a-zA-Z0-9]", "");
```