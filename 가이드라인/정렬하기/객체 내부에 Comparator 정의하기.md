- 이유
	- 예를들어 Coin Enum에서 내림차순 정렬된 리스트를 반환한다고하면, Enum 내부에서 반환하면 된다. 하지만 특정 coin데이터만 들어있는 리스트가 내부에 있을 경우 정렬하는 기준을 객체 내부에 가지고 있으면 깔끔하다.
	- Comparable를 사용하면 한가지 필드릐 기준으로 정렬하지 못한다. 하지만 내부에 선언해두면 필드를 원하는 정렬 기준으로 정렬할 수 있다.

- Comparator 정의로 사용된 getter은 private로 선언한다.
#### Enum
```java
public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10),
    COIN_1000(1000);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    // 오름차순 Comparator
    public static final Comparator<Coin> BY_VALUE_ASC = Comparator.comparingInt(Coin::getAmount);

    // 내림차순 Comparator
    public static final Comparator<Coin> BY_VALUE_DESC = Comparator.comparingInt(Coin::getAmount).reversed();
}

```

- 오름차순
``` java
List<Coin> coins = new ArrayList<>(List.of(Coin.values()));

coins.sort(Coin.BY_VALUE_ASC); // amount 기준 오름차순 정렬
```

- 내림차순
```java
List<Coin> coins = new ArrayList<>(List.of(Coin.values()));

coins.sort(Coin.BY_VALUE_DESC); // amount 기준 내림차순 정렬 
```

---
### 객체
```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Car {
    private final String name;
    private final int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    // Comparator: speed 기준 오름차순
    public static final Comparator<Car> BY_SPEED_ASC = Comparator.comparingInt(Car::getSpeed);

    // Comparator: speed 기준 내림차순
    public static final Comparator<Car> BY_SPEED_DESC = Comparator.comparingInt(Car::getSpeed).reversed();

    // Comparator: name 기준 오름차순
    public static final Comparator<Car> BY_NAME_ASC = Comparator.comparing(Car::getName);

    // Comparator: name 기준 내림차순
    public static final Comparator<Car> BY_NAME_DESC = Comparator.comparing(Car::getName).reversed();
}

```

```java
public List<Product> getSortedProducts() {  
    List<Product> sortedProducts = new ArrayList<>(products);  
    sortedProducts.sort(Product.QUANTITY_UP);  
    return sortedProducts;  
}
```