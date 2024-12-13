- 가장 상위에 있는 클래스의 자료형이 Map이여야한다.

#### 1. Staffs가 없는 유형 - EnumMap<WorkType, List<Staff.>>
- Staff
``` java
public class Staff implements Comparable<Staff> {  
    private final String name;  
    private WorkType workType;  
    private LocalDate workDate;
```

- StaffGroup
```java
public class StaffGroup {  
    private final EnumMap<WorkType, List<Staff>> staffs;
```
1. <mark style="background: #FFF3A3A6;">단순히 조회와 반환일 경우 </mark>
2. Staffs의 복잡한 유효검사가 필요하지 않을 경우

#### 2. Staffs가 있는 EnumMap - EnumMap<WorkType, Staffs>
- <mark style="background: #FFF3A3A6;">Staffs 상태에서 행동이 다양한 경우</mark>
- Staffs 상태에서 검증이 필요한 경우
- <mark style="background: #FFF3A3A6;">WorkType에 따라 Staffs의 행동이 다를 경우</mark>

	- Staff : 이름+근무유형+근무 시간을 저장
	- Staffs : 근무유형 + 해당 순서의 Staff를 반환한다.
	- StaffGroup : 근무 유형에 따른 Staffs를 찾고 Staff반환을 요청한다.
#### 3. StaffGroup가 List<Staffs.>
- History가 아닌 이상은 추천하지 않는다.

---
Staff
- 온콜 날짜가 배정 된 후에도 사용하는 객체
```java
public class Staff implements Comparable<Staff> {  
    private final String name;  
    private WorkType workType;  
    private LocalDate workDate;
```

#### Staffs
- 평일, 주말 근무자는 근무 상태만 다를 뿐 상태와 행동이 동일하여 같은 객체를 사용한다.
```java
public class Staffs {  
    private final List<Staff> staffs;
```

#### StaffGroup (StaffFinder)
- WorkType타입으로 Staff를 찾아 반환한다.
```java
public class StaffGroup {  
    private final EnumMap<WorkType, Staffs> staffs;
```