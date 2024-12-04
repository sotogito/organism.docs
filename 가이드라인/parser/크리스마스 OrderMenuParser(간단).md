# 메뉴-수량,메뉴-수량

```java
public class OrderMenuParser {  
  
    public static List<OrderItemDto> parse(String input) {  
        if (input == null || input.isEmpty()) {  
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");  
        }  
  
        List<OrderItemDto> result = new ArrayList<>();  
  
        String[] splitOrder = input.split(",");  
  
        for (String order : splitOrder) {  
            String[] menuAndQuantity = order.trim().split("-");  
  
            if (menuAndQuantity.length != 2) {  
                throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");  
            }  
  
            String menu = menuAndQuantity[0];  
            int quantity = changeNumber(menuAndQuantity[1]);  
  
            result.add(new OrderItemDto(menu, quantity));  
        }  
        return result;  
    }  
  
    private static int changeNumber(String quantity) {  
        try {  
            return Integer.parseInt(quantity);  
        } catch (NumberFormatException e) {  
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");  
        }  
    }  
  
}
```