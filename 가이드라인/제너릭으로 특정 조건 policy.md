상황 : 자동차의 이동 조건을 판단할때 정수가 아닌 다른 요소도 고려한다.

#### Policy 인터페이스
```java
public interface MoveCarPolicy<T> {  
    boolean canMoveCar(Car car, T value);  
}
```

#### 인터페이스 impl
```java
public class MoveCarPolicyImpl implements MoveCarPolicy<Integer> {  
    private final static int MOVE_CRITERIA = 4;  
  
    @Override  
    public boolean canMoveCar(Car car, Integer randomNumber) {  
        return randomNumber >= MOVE_CRITERIA;  
    }  
  
}
```
- 반드시 자료형을 선언해준다.

#### 사용하는 클래스
```java
private final MoveCarPolicy<Integer> moveCarPolicy;
```