#### 현재 시간
```java
LocalDateTime now = LocalDateTime.now();
```
출력 결과: `2024-05-01T12:34:56`

#### 날짜지정
```java
LocalDateTime dateTime = LocalDateTime.of(2024, 5, 1, 12, 30, 45);
```

#### 문자열로 생성
```java
LocalDateTime dateTime = LocalDateTime.parse("2024-05-01T12:30:45");
```

---
#### 데이터 가져오기
```java
int year = dateTime.getYear();           // 연도
int month = dateTime.getMonthValue();    // 월 (숫자)
	Month monthEnum = dateTime.getMonth();   // 월 (Month enum)
int day = dateTime.getDayOfMonth();      // 일

int hour = dateTime.getHour();           // 시
int minute = dateTime.getMinute();       // 분
int second = dateTime.getSecond();       // 초
```

#### 요일 계산하기
```java
DayOfWeek dayOfWeek = dateTime.getDayOfWeek();

int dayOfWeekNumber = dateTime.getDayOfWeek().getValue(); //요일 숫자로
```
---
#### 날짜 더하기
```java
LocalDateTime nextYear = dateTime.plusYears(1);       // 연도 +1
LocalDateTime nextMonth = dateTime.plusMonths(1);     // 월 +1
LocalDateTime nextDay = dateTime.plusDays(1);         // 일 +1

LocalDateTime nextHour = dateTime.plusHours(1);       // 시 +1
LocalDateTime nextMinute = dateTime.plusMinutes(1);   // 분 +1
LocalDateTime nextSecond = dateTime.plusSeconds(1);   // 초 +1
```

#### 날짜 빼기
```java
LocalDateTime previousYear = dateTime.minusYears(1);       // 연도 -1
LocalDateTime previousMonth = dateTime.minusMonths(1);     // 월 -1
LocalDateTime previousDay = dateTime.minusDays(1);         // 일 -1

LocalDateTime previousHour = dateTime.minusHours(1);       // 시 -1
LocalDateTime previousMinute = dateTime.minusMinutes(1);   // 분 -1
LocalDateTime previousSecond = dateTime.minusSeconds(1);   // 초 -1
```

---
#### 날짜 비교하기
- 이전 날짜인가
```java
boolean isBefore = dateTime.isBefore(LocalDateTime.of(2024, 6, 1, 12, 0));
System.out.println(isBefore); // true
```
- 이후 날짜인가
```java
boolean isAfter = dateTime.isAfter(LocalDateTime.of(2024, 4, 1, 12, 0));
System.out.println(isAfter); // true
```
- 같은 날짜인가
```java
boolean isEqual = dateTime.isEqual(LocalDateTime.of(2024, 5, 1, 12, 30, 45));
```

---
#### 날짜 커스텀 포맷
```java
import java.time.format.DateTimeFormatter;

LocalDateTime dateTime = LocalDateTime.of(2024, 5, 1, 12, 30, 45);
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

String formattedDateTime = dateTime.format(formatter);
System.out.println(formattedDateTime); // 2024/05/01 12:30:45
```
기본 : `2024-05-01`

#### 날짜 시간 변경하기
```java
LocalDateTime modifiedDateTime = dateTime.withYear(2025)
                                          .withMonth(12)
                                          .withDayOfMonth(25)
                                          .withHour(18)
                                          .withMinute(45)
                                          .withSecond(0);
System.out.println(modifiedDateTime); // 2025-12-25T18:45:00
```
---
#### 특정 시간대 날짜 가져오기
```java
import java.time.ZoneId;

LocalDateTime currentTimeInSeoul = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
System.out.println(currentTimeInSeoul);
```
