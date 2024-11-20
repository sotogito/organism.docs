- String 특수문자 들어있는지
```java
private static void validateContainSpecialCharacters(String value) {  
    Matcher matcher = Pattern.compile("[!@#$%^&*().?\":{}|<>]").matcher(value);  
    if (matcher.find()) {  
        throw new IllegalArgumentException();  
    }  
}
```

- 양식에 맞게 작성했는지
- 특수 문자가 몇개 포함되어있는지
```java
    private static int countContains(String orderForm, String delimiter) {
        char delimiterChar = delimiter.charAt(0);
        return (int) orderForm.chars()
                .filter(c -> c == delimiterChar)
                .count();
    }
```

```java
    private static void validateNoHyphen(String splitCommaValue) {
        int containCount = countContains(splitCommaValue,",");
        if (containCount != 1) {
            throw new IllegalArgumentException();
        }
    }
```