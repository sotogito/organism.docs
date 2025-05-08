자바방식으로 어노테이션 방식과는 다르게 Bean으로 사용할 클래스에 직접적으로 어노테이션을 붙이는 것이 아니라 별도의 설정 클래스에서 빈을 명시적으로 등록한다. 


|특징|**자바 방식** (Java Config)|**어노테이션 방식** (Annotation Config)|
|---|---|---|
|**설정 방식**|Java 코드에서 **`@Configuration`**, **`@Bean`** 사용|클래스에 **`@Component`**나 **`@Service`** 등 어노테이션 사용|
|**빈 등록**|**수동으로 설정**: `@Bean`을 사용해 빈 등록|**자동으로 빈 등록**: `@ComponentScan`을 통해 자동 등록|
|**의존성 주입**|**명시적으로 `@Bean`에 의존성 주입**|**자동으로 `@Autowired` 주입**|
|**복잡성**|**코드가 길어질 수 있음**: 수동 설정 필요|**간단함**: 어노테이션만으로 자동 설정|
|**유지보수**|**코드 기반**이라 유연하고 수정이 용이|**자동 설정**이므로 관리가 더 쉬움|
|**사용 예**|복잡한 설정을 **자바 코드**로 관리해야 할 때|**간단한 애플리케이션**, **자동 빈 등록**이 필요한 경우|

자바방식은 어노테이션보다 더 명시적이고 코드 기반의 설정을 선호할 때 사용된다. 보통 복잡한 설정이 필요한 경우나 구체적인 빈 설정이 필요할 때 유용하다.

### 자바
```java
@Configuration // 설정 클래스임을 나타냄
public class AppConfig {

    @Bean // 이 메서드의 반환값이 빈으로 등록됨
    public MemberService memberService(MemberRepository memberRepository) {
        return new MemberServiceImpl(memberRepository);
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemberRepository();
    }
}
```

### 어노테이션
```java
@Component
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public void serve() {
        // 서비스 로직
    }
}
```