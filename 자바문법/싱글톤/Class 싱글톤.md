#### 싱글톤 클래스
```java
public class 클래스{
	private static 클래스 singleton = new 클래스();

	private 클래스(){
	}

	public static 클래스 getInstance(){
		return singleton;
	}
}
```


#### 사용
```java
클래스 obj1 = 클래스.*getInstance()*;
```