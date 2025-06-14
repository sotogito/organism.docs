|항목|`@DiscriminatorColumn` 방식|enum 수동 분기 방식|
|---|---|---|
|DB 접근 횟수|1번 (자동 자식 조회)|2번 (수동 자식 조회)|
|자식 객체 타입 구분|자동|수동 (if, switch 등)|
|유지보수|용이|복잡 (타입마다 분기문, 코드 중복 증가)|
|설계 방식|JPA 상속 매핑 권장 방식|데이터 기반 수동 분기 방식|

---


일단 내가 원하는 구조가 다음과 같다.  
Card라는 엔티티에 알림이 일대일로 매핑이 되어야한다.  
알림의 종류는 다르고 알림의 조율에 따라서 상태와 행동이 다르기 때문에 SINGLE_TABLE이 아니라 JOINED로 해준 캐이스이다.

부모 알림 엔티티에 pk를 생성하고 알림 타입을 생성하면  
알림 종류 자식들이 부모의 pk를 fk로 갖는 형태이다.  

그럼 카드에서는 알림의 타입에 따라서 분기처리하여 조인시킬tbl을 선택하고 join으로 결과를 가쟈오면 된다.  


| id  | enabled | notification_type |
| --- | ------- | ----------------- |
| 1   | true    | TIME              |
| 2   | true    | LOCATION          |
- tbl_notification

| notification_id | time     |
| --------------- | -------- |
| 1               | 08:00:00 |
- tbl_nofit_time

| notification_id | location |
| --------------- | -------- |
| 2               | 삼성역      |
- tbl_notif_location

---
이것을 가장 정석대로 하여 엔티티를 설계해본다면 아래와 같다.
```
@Entity
@Table(name = "tbl_notification")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "notification_type")
public abstract class Notification extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notif_id")
    private Long id;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;


    public abstract NotificationType getType();

}
```

```
@Entity
@Table(name = "tbl_notif_location")
@DiscriminatorValue("LOCATION")
public class LocalNotif extends Notification {

    private final static double DEFAULT_TRIGGER_RADIUS_KM = 5.0;

    private String location;

    @Override
    public NotificationType getType() {
        return NotificationType.LOCATION;
    }

}
```

```
@Entity
@Table(name = "tbl_notif_time")
@DiscriminatorValue("TIME")
public class TimeNotif extends Notification {

    private LocalTime time;

    @Override
    public NotificationType getType() {
        return NotificationType.TIME;
    }

}
```
여기서 내가 마음에 안들었던것은 바로 컬럼의 값을 지정하는 방식이다. String 으로 직접 넣어줘야한다는 점에서 위험성이 크다고 생각했다.  
그래서 Enum 상수로 처리하는 방법을 찾아냈다.

### ENUM discriminator + 자식 생성자에서 타입 지정 - 근데사실별로인방법이다.
1. 부모 엔티티에서 `@DiscriminatorColumn` 설정을 지우고, `@Enumerated` 필드를 생성한다.
2. 부모 엔티티에 해당Enum 값을 받는 생성자를 작성한다.
3. 자식 엔티티의 생성자에 notification_type으로 저장할 값을 super생성자로 명시적으로 넘겨준다.

#### (부모) Notification
```java
@NoArgsConstructor  
  
@Entity  
@Table(name = "tbl_notification")  
@Inheritance(strategy = InheritanceType.JOINED)  
public abstract class Notification extends BaseTimeEntity {  
  
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)  
    @Column(name = "notif_id")  
    private Long id;  
  
    @Enumerated(EnumType.STRING)  
    @Column(name = "notification_type", nullable = false)  
    private NotificationType type;  
  
    @Column(name = "is_active", nullable = false) //todo 알림은 상태의 확장 가능성이 있나?  
    private boolean isActive;  
  
    public Notification(NotificationType type) {  
        this.type = type;  
    }  
  
    public abstract NotificationType getType();  
  
}
```

####  (자식-1) TimeNotif
```java
@NoArgsConstructor  
  
@Entity  
@Table(name = "tbl_notif_time")  
public class TimeNotif extends Notification {  
  
    @Column(name = "time", nullable = false)  
    private LocalTime time;  
  
    @Builder  
    public TimeNotif(LocalTime time) {  
        super(NotificationType.TIME);  
        this.time = time;  
    }  
  
    @Override  
    public NotificationType getType() {  
        return NotificationType.TIME;  
    }  
  
}
```

#### (자식-2) LocationNotif
```java
@NoArgsConstructor  
  
@Entity  
@Table(name = "tbl_notif_location")  
public class LocalNotif extends Notification {  
  
    private final static double DEFAULT_TRIGGER_RADIUS_KM = 5.0;  
  
    @Column(name = "location")  
    private String location;  
  
    @Builder  
    public LocalNotif(String location) {  
        super(NotificationType.LOCATION);  
        this.location = location;  
  
    }  
  
    @Override  
    public NotificationType getType() {  
        return NotificationType.LOCATION;  
    }  
  
}
```



```java
TimeNotif notif = new TimeNotif();


TimeNotif notif = TimeNotif.builder()
    .time(LocalTime.of(8, 0))
    .build();
```
객체를 생성할때는 자식 엔티티 내부에 부모 알림 타입을set해주는 구문을 지정했기 때문에 그냥 저렇게 생성하면 된다.  
타입 지정 생성자에 직접 빌더를 지정해주었기 때문에 빌더패턴도 문제없이 사용할 수 있다.(만약 클래스 위에 빌더를 작성할 경우네는 그냥 기본인 NoArgsConstructor로 들어가기 때문에 직접 생성자에 지정을 해워야한다.)

# 근데 위의 방식의 문제점은

Notification n = em.find(Notification.class, 1L);
// 실제 DB에선 TimeNotif인지 LocationNotif인지 모르지만
// JPA가 DTYPE을 보고 알아서 TimeNotif나 LocationNotif로 캐스팅해줌  

- `"TIME"` → `TimeNotif` 클래스
- `"LOCATION"` → `LocalNotif` 클래스

```
Notification n = em.find(Notification.class, id);
if (n instanceof TimeNotif time) {
    // 바로 사용
}

```
만약 이 로직이 있다고 가정했을때 DiscriminatorColumn 컬럼 방식을 사용하면 바로 사용할수 있는데 enum 방식을 사용할 경우에는 한번 더 db에 pk를 가지고 접근하여 찾아와야한다.

```
if (n.getType() == NotificationType.TIME) {
    TimeNotif time = em.find(TimeNotif.class, 1L); // ❗ 자식 테이블에 다시 조회
}
```

상수처리하고싶어 시도는 해봤지만 jpa가 만들어놓은 기능에서 멀저지고 원초적으로 돌아가는 방식인거 같아 다시 @DiscriminatorValue을 사용하기로 결심했다.