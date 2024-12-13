```java
List<String> week = new ArrayList<>(List.of("월", "화", "수", "목", "금", "토", "일"));  
  
int startIndex = week.indexOf("목");  
int totalCount = 31;  
  
for (int i = 0; i < totalCount; i++) {  
    int index = startIndex % week.size();  
    System.out.println(week.get(index));  
    startIndex++;  
}
```

시작요일로 하여 31번 순회한다.