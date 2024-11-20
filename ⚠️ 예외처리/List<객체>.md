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