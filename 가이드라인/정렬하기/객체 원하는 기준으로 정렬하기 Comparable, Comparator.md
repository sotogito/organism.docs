#### Comparator - getter 필요
- 오름차순
```java
cars.sort(Comparator.comparingInt(Car::getPosition));

Collections.sort(cars, Comparator.comparingInt(Car::getPosition));
```

- 내림차순
```java
cars.sort(Comparator.comparingInt(Car::getPosition).reversed()); 

Collections.sort(cars, Comparator.comparingInt(Car::getPosition).reversed()); 
```

- 최대 & 최소
```java
Car maxCar = Collections.max(cars, Comparator.comparingInt(Car::getPosition)); 
Car minCar = Collections.min(cars, Comparator.comparingInt(Car::getPosition)); 
```

- String 정렬
```java
cars.sort(Comparator.comparing(Car::getName)); //오름차순
cars.sort(Comparator.comparing(Car::getName).reversed()); //내림차순
```
- String 최대 & 최소
```java
// 최대값 (사전순 마지막) 
Car maxCar = Collections.max(cars, Comparator.comparing(Car::getName)); 
// 최소값 (사전순 첫 번째) 
Car minCar = Collections.min(cars, Comparator.comparing(Car::getName)); 
```
#### Comparable로 재정의하여
- String의 경우도 똑같다.

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

- 오름차순
```java
cars.sort(null); 
Collections.sort(cars); 
```

- 내림차순
```java
cars.sort(Comparator.reverseOrder());
Collections.sort(cars, Comparator.reverseOrder());
```

- 최대 & 최소
```java
Car maxCar = Collections.max(cars); 
Car minCar = Collections.min(cars);
```



---

```
- 하나하나 확인하기
```java
Car maxCar = cars.get(0);  
for(int i = 1; i < cars.size(); i++){  
    Car car2 = cars.get(i);    
    if(maxCar.compare(maxCar,car2) < 0){        
	    maxCar = car2;    
	    }
	}  
return maxCar;
```

|**특징**|**`Comparator` 사용**|**`Comparable` 구현**|
|---|---|---|
|**클래스 구현 필요**|없음|`compareTo` 메서드를 반드시 구현해야 함|
|**정렬 기준 정의**|외부에서 정렬 기준을 제공 (`Comparator` 전달)|클래스 내부에서 기본 정렬 기준 설정 (`compareTo` 구현)|
|**유연성**|정렬 기준을 동적으로 변경 가능|정렬 기준을 변경하려면 클래스 내부 코드를 수정해야 함|
|**호출 방식**|`cars.sort(Comparator)` 또는 `Collections.sort(cars, Comparator)`|`cars.sort(null)` 또는 `Collections.sort(cars)`|
|**사용 예제**|`Comparator.comparingInt(Car::getPosition)`|`compareTo` 메서드 구현|

#### `comparing`과 `comparingInt`의 차이**

|**특징**|**`Comparator.comparing`**|**`Comparator.comparingInt`**|
|---|---|---|
|**대상 필드 타입**|`Object` 타입 필드 (참조 타입)|기본형 타입 (primitive `int`)|
|**박싱/언박싱**|자동으로 **박싱/언박싱** 작업이 수행됨|박싱/언박싱 작업 없음, 더 효율적|
|**성능**|기본형 사용 시 **추가적인 오버헤드 발생**|기본형 필드 비교를 위해 **더 빠르게 작동**|
|**사용 대상**|`Integer`, `String`, 기타 참조 타입 필드|`int`와 같은 기본형 필드|
