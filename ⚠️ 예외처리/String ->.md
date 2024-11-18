- String 특수문자 들어있는지
```java
private static void validateContainSpecialCharacters(String value) {  
    Matcher matcher = Pattern.compile("[!@#$%^&*().?\":{}|<>]").matcher(value);  
    if (matcher.find()) {  
        throw new IllegalArgumentException();  
    }  
}
```