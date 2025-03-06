- Calendar는 추상 클래스이며 직접 객체 생성이 불가능하다.

```java
  Calendar gregorianCalendar = new GregorianCalendar();
```

```java
    int year = 2022;
    int month = 10;		//월은 0 ~ 11월로 사용하기 때문에 8은 9월을 의미한다.
    int dayOfMonth = 8;
    int hour = 16;
    int min = 42;
    int second = 0;

    Calendar birthDay = new GregorianCalendar(year, month, dayOfMonth, hour, min, second);
```

- 날짜 시간정보를 가지는 Date인스턴스
```java
    Calendar calendar = Calendar.getInstance();
    Date date = new Date(calendar.getTimeInMillis());

    Date date2 = new Date(new GregorianCalendar(year, month, dayOfMonth, hour, min, second).getTimeInMillis());
```
