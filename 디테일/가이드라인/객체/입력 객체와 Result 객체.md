- 입력 객체 
	- 로직에 필요한 사용자가 입력한 객체
	- 가장 작은 단위의 객체이다.
- Result 객체
	- 로직 결과 생성된 데이터
	- 출력물에 필요한 데이터이다.
	- eventDetails
	- giftMenu
	- badge

---
만약 크리스마스 문제에서 입력 객체는 다음과 같이 생겨난다.
- Schedule : 방문 날짜 저장
- Cart : 주문 목록 저장
- Wallet : 지불해야할 금액 저장

이 3객체는 EventPlan결과를 생성하기까지 필요하다.
- Schedule : 이벤트 적용 가능 날짜인가?
- Cart : 이벤트 적용시 필요한 메뉴 데이터 반환
- Wallet : 총 지불 금액으로 데이터 생성

#### 옳은 구현 방법
EventPlan은 하나의 데이터 결과로 List<EventPlan은>의 형식으로 저장되어야할 수 도 있다. 때문에 이 데이터 하나에 관련 데이터를 추가해야한다.
- 방문 날짜
- 주문 목록
- 지불 총 금액
- 이벤트 디테일
- 증점품
- 배지

밑에서 3개는 로직으로 생성되는 새로운 데이터이다.
위에서 3개는 사용자의 입력으로 생성된 데이터이다.

이를 하나의 EventPlan에 다 저장해두어야한다.

단, 입력 객체는 저장된 EventPlan에서 행동하지 않는다,
EventPlan 안에서는 저장의 용도로만 존재한다,

예를들어 EventPlan의 이벤트 디테일의 데이터를 생성하기 위해 Schedule과 Cart의 객체가 필요하다면 이 객체를 EventPlan내부에서 활용하지 않는다.
컨트롤러에서 단독적인 Schedule, Cart 객체를 통해 사용한다. 
그래야 복잡해지지 않는다.

입력 객체는 순수한 객체 그 자체로 행동하도록한다.


```java
package christmas.domain;  
  
import christmas.domain.event.Event;  
import christmas.domain.event.Gift;  
import christmas.domain.restaurant.MenuItem;  
import christmas.domain.user.Cart;  
import christmas.domain.user.Schedule;  
import christmas.domain.user.Wallet;  
import java.util.HashMap;  
import java.util.Map;  
  
public class EventPlan {  
    private final Schedule schedule;  
    private final Cart cart;  
    private final Wallet wallet;  
    private final Map<Event, Integer> eventDetails;  
    private final Map<MenuItem, Integer> giftMenu;  
    private Badge badge;  
  
    public EventPlan(Schedule schedule, Cart cart, Wallet wallet) {  
        this.schedule = schedule;  
        this.cart = cart;  
        this.wallet = wallet;  
        this.eventDetails = new HashMap<>();  
        this.giftMenu = new HashMap<>();  
        badge = Badge.NOTHING;  
    }  
  
    public void setBadge(Badge badge) {  
        this.badge = badge;  
    }  
  
    public void addGiftMenu(MenuItem giftMenu, int quantity) {  
        this.giftMenu.put(giftMenu, quantity);  
    }  
  
    public Map<MenuItem, Integer> getGiftMenu() {  
        return giftMenu;  
    }  
  
    public void addAppliedEvent(Event event, int amount) {  
        eventDetails.put(event, amount);  
    }  
  
    public int getTotalDiscountAmountWithGift() {  
        int total = 0;  
        for (Map.Entry<Event, Integer> entry : eventDetails.entrySet()) {  
            total += entry.getValue();  
        }  
        return total;  
    }  
  
    public int calculateDiscountAmount() {  
        int total = 0;  
        for (Map.Entry<Event, Integer> entry : eventDetails.entrySet()) {  
            Event event = entry.getKey();  
            if (event instanceof Gift) {  
                continue;  
            }  
            total += entry.getValue();  
        }  
        return total;  
    }  
  
    public Badge getBadge() {  
        return badge;  
    }  
  
    public Map<Event, Integer> getDiscountEvents() {  
        return eventDetails;  
    }  
  
    public Schedule getSchedule() {  
        return schedule;  
    }  
  
    public Cart getCart() {  
        return cart;  
    }  
  
    public Wallet getWallet() {  
        return wallet;  
    }  
  
}
```