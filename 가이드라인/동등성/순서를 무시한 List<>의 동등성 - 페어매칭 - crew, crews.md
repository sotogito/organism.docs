- crew
```java
public class Crew {  
    private final Course course;  
    private final String name;

    @Override  
    public boolean equals(Object o) {  
        if (this == o) {  
            return true;  
        }  
        if (o == null || getClass() != o.getClass()) {  
            return false;  
        }  
        Crew crew = (Crew) o;  
        return Objects.equals(name, crew.name) && Objects.equals(course, crew.course);  
    }  
  
    @Override  
    public int hashCode() {  
        return Objects.hash(name, course);  
    }  
  
}
```

- CrewPair
```java
public class PairCrew {  
    private final List<Crew> crews;

@Override  
public boolean equals(Object o) {  
    if (this == o) {  
        return true;  
    }  
    if (o == null || getClass() != o.getClass()) {  
        return false;  
    }  
    PairCrew that = (PairCrew) o;  
    return crews.size() == that.crews.size() &&  
            new HashSet<>(crews).containsAll(that.crews) &&  
            new HashSet<>(that.crews).containsAll(crews);  
}  
  
@Override  
public int hashCode() {  
    return Objects.hash(crews);  
}
```

PairCrew pairCrew1 = new PairCrew(crewList1);  
PairCrew pairCrew2 = new PairCrew(crewList2);
#### 1. 리스트가 같은 기준?
`List<Crew> crewList1 = List.of(crew1, crew2);`  
`List<Crew> crewList2 = List.of(crew1, crew2);`
리스트가 같다는 기준은 뭘까 바로
1. 내용물이 같을 때
2. 순서가 같을 때
위의 두가지가 충족되어야 같다.
즉 위의 리스트는 동등성이 정의된 crew과 순서가 같기 때문에 동일하다.
만약 순서가 변경되면 둘은 다르다.

#### 2. PairCrew가 같은 기준?
PairCrew pairCrew1 = new PairCrew(new Array.List(List.of(crew1, crew2)));  
PairCrew pairCrew2 = new PairCrew(new Array.List(List.of(crew1, crew2));

내용물, 순서가 같으면 리스트도 같겠다, 
그럼 `List<Crew>`를 가지고 있는 PairCrew객체도 동일할까?
-> <mark style="background: #FFB86CA6;">아니다.</mark>
**PairCrew은 왜냐면 객체이기 때문이다.**

$Expected :pairmatching.domain.pair.PairCrew@2e385cce<수키피 : 숲깊이>$
$Actual   :pairmatching.domain.pair.PairCrew@2ddc9a9f<수키피 : 숲깊이>$

두 객체의 주소를 보면 다르다. 
두 객체는 **서로 다른 인스턴스**로 간주된다.

<mark style="background: #FFF3A3A6;">내용물이 같으면 동일한 객체로 처리하기 위해서는 반드시 equals의 정의가 필요하다.</mark>

위에가 같다는 말은 Number이라는 객체에 int 값이 같다고 같은 객체가 되는것과 같은 맥락이다. 
`Number n1 = new Number(5);` 
`Number n2 = new Number(5);`
위의 둘은 equals로 정의가 되지 않으면 동등하지 않다.

즉!! equals로 위의 예시 코드와 같이 PairCrew의 동등성을 정의해줘야한다.


---

```java
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairMember pairMember = (PairMember) o;
        int count = 0;
        for(Crew crew : crews) {
            if(pairMember.crews.contains(crew)) {
                count ++;
            }
        }
        return count == crews.size();
    }
```