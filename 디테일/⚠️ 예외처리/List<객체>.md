### 반드시 .equals() 로 비교하기 (==안됨)

- 객체

```java
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; 
        if (o == null || getClass() != o.getClass()) return false; 
        Car car = (Car) o; 
        return Objects.equals(name, car.name); 
    }
        @Override
    public int hashCode() {
        return Objects.hash(name);
    }
```

- 2개 필드 이상
```java
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Crew crew = (Crew) o;
    return Objects.equals(name, crew.name) &&
           Objects.equals(course, crew.course);
}

@Override
public int hashCode() {
    return Objects.hash(name, course); // 둘 다 포함해 안전하게 해시 생성
}

```


- 객체 중복 유효검사
``` java
    public static boolean hasDuplicates(List<Car> cars) {
        Set<Car> carSet = new HashSet<>();
        for (Car car : cars) {
            if (!carSet.add(car)) {
                throw new IllegalArgumentException("중복된 값이 있어요.");
            }
        }
    }
```