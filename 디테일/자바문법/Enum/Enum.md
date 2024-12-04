- 데이터로 Enum 값을 반환하는 static find 변수를 활용한다.
- 가져온 Enum 변수로 get해와서 사용한다.
- 이렇게 구현하면 finder와 getter로만으로 쉽게 확장 가능하다.
	- input값으로 Answer반환,  input값으로 index반환, 이 두가지 기능이 있다면 메서드를 각각 생성하지 말고 finder로 인스턴스를 반환하고 getter를 사용하면 된다.
```java
  
private final String answer;  
private final int randomNumber;  
private final int index;  
  
BridgeLocation(String answer, int randomNumber, int index) {  
    this.answer = answer;  
    this.randomNumber = randomNumber;  
    this.index = index;  
}  
  
public String getAnswer() {  
    return answer;  
}  
  
public int getIndex() {  
    return index;  
}  
  
public static BridgeLocation find(String input) {  
    for (BridgeLocation state : BridgeLocation.values()) {  
        if (state.answer.equals(input)) {  
            return state;  
        }  
    }  
    throw new IllegalArgumentException("존재하는 위치가 없습니다.");  
}
```
