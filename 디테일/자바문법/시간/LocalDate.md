#### 현재 시간
```java
LocalDate today = LocalDate.now();
```
출력 결과: `2024-05-01`

#### 날짜지정
```java
LocalDate date = LocalDate.of(2024, 5, 1);
```

#### 문자열로 생성
```java
LocalDate date = LocalDate.parse("2024-05-01");
```

---
#### 년 가져오기
```java
LocalDate date = LocalDate.of(2024, 5, 1); 
int year = date.getYear();
```
#### 월 가져오기
```java
int month = date.getMonthValue(); // 숫자로 월 가져오기 (예: 5)
Month monthEnum = date.getMonth(); // Month enum으로 가져오기 (예: MAY)
```

#### 해당 월의 마지막 일 가겨오기
```java
int lastDay = yearMonth.lengthOfMonth();
```
#### 일 가져오기
```java
int day = date.getDayOfMonth();
```

#### 요일 계산하기
```java
DayOfWeek dayOfWeek = date.getDayOfWeek();
```
출력 형태 : `WEDNESDAY`

#### 요일 숫자로 가져오기
```java
int dayOfWeekNumber = date.getDayOfWeek().getValue();
```
<mark style="background: #FFF3A3A6;">1(월) ~ 7(수)</mark>

---
#### 날짜 더하기
```java
LocalDate nextYear = date.plusYears(1); //연도
LocalDate nextMonth = date.plusMonths(1); //월
LocalDate nextDay = date.plusDays(1); //일
```

#### 날짜 빼기
```java
LocalDate previousYear = date.minusYears(1); //연도
LocalDate previousMonth = date.minusMonths(1); //월
LocalDate previousDay = date.minusDays(1); //일
```

---
#### 날짜 비교하기
- 이전 날짜인가
```java
LocalDate date1 = LocalDate.of(2024, 5, 1);
LocalDate date2 = LocalDate.of(2024, 6, 1);

boolean isBefore = date1.isBefore(date2);
System.out.println(isBefore); // true
```
- 이후 날짜인가
```java
boolean isAfter = date2.isAfter(date1);
```
- 같은 날짜인가
```java
boolean isEqual = date1.isEqual(date2);
```

---
#### 날짜 커스텀 포맷
```java
import java.time.format.DateTimeFormatter;

LocalDate date = LocalDate.of(2024, 5, 1);
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

String formattedDate = date.format(formatter);
System.out.println(formattedDate); // 2024/05/01
```
기본 : `2024-05-01`

