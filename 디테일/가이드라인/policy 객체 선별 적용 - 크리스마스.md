- PolicyFinder
유효검사를 통해 적용이 가능한 이벤트만 반환한다.
```java
public class EventPlanner {
    private final List<Discount> events;
    private final Gift giftEvent;
    private final Gift badgeGiftEvent;

    public EventPlanner() {
        this.events = new ArrayList<>();
        giftEvent = new GiftEvent();
        badgeGiftEvent = new BadgeEvent();
        init();
    }

    //note discount만, 적용 날짜만 판단하여 반환
    public List<Event> getApplicableDateEvents(Schedule schedule) {
        List<Event> result = new ArrayList<>();

        for (Event event : events) {
            if (event.isValidDate(schedule)) {
                result.add(event);
            }
        }
        return result;
    }

    public Optional<Event> getGiftEvent(Schedule schedule) {
        if (giftEvent.isValidDate(schedule)) {
            return Optional.of(giftEvent);
        }
        return Optional.empty();
    }

    public Optional<Event> getBadgeGiftEvent(Schedule schedule) {
        if (badgeGiftEvent.isValidDate(schedule)) {
            return Optional.of(badgeGiftEvent);
        }
        return Optional.empty();
    }


    private void init() {
        Discount discount1 = new ChristmasDDayDiscount();
        Discount discount2 = new WeekdayDiscount();
        Discount discount3 = new WeekendDiscount();
        Discount discount4 = new SpecialDiscount();

        events.add(discount1);
        events.add(discount2);
        events.add(discount3);
        events.add(discount4);
    }


}
```

- Service
Result 객체를 생성하고, finder에서 가져온 policy 객체를 기반으로 apply 시킨다.
```java
    public EventPlan applyEvent(Schedule schedule, Cart cart, Wallet wallet) {
        EventPlan eventPlan = new EventPlan(schedule, cart, wallet);
        EventApplyDto dto = new EventApplyDto(schedule, cart, wallet, eventPlan);

        if (!wallet.canEvent()) {
            return eventPlan;
        }

        for (Event event : eventPlanner.getApplicableDateEvents(schedule)) {
            event.apply(dto);
        }

        Optional<Event> giftEvent = eventPlanner.getGiftEvent(schedule);
        if (giftEvent.isPresent()) {
            Event gift = giftEvent.get();
            gift.apply(dto);
        }

        Optional<Event> badgeGiftEvent = eventPlanner.getBadgeGiftEvent(schedule);
        if (badgeGiftEvent.isPresent()) {
            Event badge = badgeGiftEvent.get();
            badge.apply(dto);
        }

        return eventPlan;
    }
```