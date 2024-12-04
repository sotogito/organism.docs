
- NumberMachine : 랜덤 번호 생성 인터페이스
- RandomNumberMachine : 랜덤 번호 생성 @Override
- Maker : 랜덤 번호 생성 후 알맞는 자료형 반환

`@FunctionalInterface` : 만약 인터페이스가 하나의 추상 메서드만 가지고 있을 때 사용한다.
### NumberMachine 인터페이스

``` java
public interface NumberMachine {
    int **generate()**;
}
```

### RandomNumberMachine 랜덤 번호생성

``` java
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberMachine implements NumberMachine {

    private static final int MIN = 0;
    private static final int MAX = 1;

    @Override
    public int **generate()** {
        return Randoms.pickNumberInRange(MIN, MAX);
    }
}
```

### Controller에서 `인터페이스=new 객체;` 생성

``` java

private Maker createMaker(){
			NumberMachine numberMachine = new RandomNumberMachine();
			return new Maker(numberMachine);
}

```

### Maker 최종 랜덤 생성 반환

``` java
public class Maker {

    private final NumberMachine numberMachine;

    public BridgeMaker(NumberMachine numberMachine) {
        this.numberMachine = numberMachine;
    }

   
    public List<Intger> makeNumberList(int size) {
        List<String> result = new ArrayList<>();

        for(int i = 0; i<size; i++){
            int number = numberMachine.generate();
            result.add(number);
        }
        return result;
    }
    
}
```

---

- 만약 `List<Lotto>`를 위와같이 구현한다면
    
    ```
    public interface NumberMachine {
        List<Integer> generate();
    }
    
    public class RandomNumberMachine implements NumberMachine {
        private static final int MIN = 0;
        private static final int MAX = 7;
        private static final int SIZE = 6;
    
        @Override
        public List<Integer> generate() {
            return Randoms.pickNumberInRange(MIN, MAX, SIZE);
        }
    }
    
    public class Maker {
        private final NumberMachine numberMachine;
    
        public Maker(NumberMachine numberMachine) {
            this.numberMachine = numberMachine;
        }
    
        public List<Lotto> makeNumberList(int size) {
    				List<Lotto> result = new ArrayList<>();
    				
    				for(int i = 0; i<size; i++){
                Lotto lotto = new lotto(numberMachine.generate());
    						result.add(lotto);
            }
        }
    }
    
    // 사용 예시
    NumberMachine numberMachine = new RandomNumberMachine();
    Maker maker = new Maker(numberMachine);
    List<Integer> newRandomNumber = maker.makeNumberList();
    ```