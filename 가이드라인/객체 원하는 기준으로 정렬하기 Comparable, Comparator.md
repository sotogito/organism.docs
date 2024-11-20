
- Comparable - compareTo
비교하고자 하는 객체의 변수를 정의한다.
```java
public class Car implements Comparable<Car> {  
    private final String name;  
    private int position;

	@Override  
	public int compareTo(Car other) {  
	    return Integer.compare(this.position, other.position);  
	}
```

```java
public class Cars {  
    private final List<Car> cars;
    
	private Car getMaximumPositionCar(){
		return Collections.max(cars); //최대
		return Collections.min(cars) //최소
		return Collections.sort(cars) //오름차순
		return Collections.reverseOrder(cars)//내림차순
		 
		
	}
 
}
```


- Comparator + get
get함수를 정의하여 좀 더 간단히 구현 가능하다.
```java
return Collections.max(cars, Comparator.comparingInt(Car::getPosition)); 
```
