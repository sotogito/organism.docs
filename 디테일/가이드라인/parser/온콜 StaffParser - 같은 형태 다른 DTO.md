```java
public static WeekdayStaffsDto parseWeekday(String input){  
    return new WeekdayStaffsDto(parse(input));  
}  
  
public static WeekendStaffsDto parseWeekend(String input){  
    return new WeekendStaffsDto(parse(input));  
}  

//List<String>이라는 공통 자료형을 넘겨줌
private static List<String> parse(String input){  
    List<String> result = new ArrayList<>();  
    input = input.trim();  
  
    String[] split = input.split(",");  
  
    for (String s : split) {  
        result.add(s.trim());  
    }  
    return result;  
}
```