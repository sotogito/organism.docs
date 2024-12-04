```java
public enum Restaurant {  
    RESTAURANT;  
  
    private final static EnumMap<Category, List<MenuItem>> menus = new EnumMap<>(Category.class);  
  
    public CategoryMenuDto findByMenuName(String menuName) {  
        for (Category category : Category.values()) {  
            List<MenuItem> menuItems = menus.get(category);  
            for (MenuItem menuItem : menuItems) {  
                if (menuItem.isSame(menuName)) {  
                    return new CategoryMenuDto(category, menuItem);  
                }  
            }  
        }  
        throw new IllegalArgumentException("존재하지 않는 메뉴입니다.");  
    }  
  
    public MenuItem findMenuByCategoryAndMenuName(Category category, String menuName) {  
        List<MenuItem> menuItems = menus.get(category);  
        for (MenuItem menuItem : menuItems) {  
            if (menuItem.isSame(menuName)) {  
                return menuItem;  
            }  
        }  
        throw new IllegalArgumentException("존재하지 않는 메뉴입니다.");  
    }  
  
    static {  
        menus.put(Category.APPETIZER, new ArrayList<>(List.of(  
                new MenuItem("양송이수프", 6000),  
                new MenuItem("타파스", 5500),  
                new MenuItem("시저샐러드", 8000))));  
  
        menus.put(Category.MAIN, new ArrayList<>(List.of(  
                new MenuItem("티본스테이크", 55000),  
                new MenuItem("바비큐립", 54000),  
                new MenuItem("해산물파스타", 35000),  
                new MenuItem("크리스마스파스타", 25000))));  
  
        menus.put(Category.DESSERT, new ArrayList<>(List.of(  
                new MenuItem("초코케이크", 15000),  
                new MenuItem("아이스크림", 5000))));  
  
        menus.put(Category.DRINK, new ArrayList<>(List.of(  
                new MenuItem("제로콜라", 3000),  
                new MenuItem("레드와인", 60000),  
                new MenuItem("샴페인", 25000))));  
    }  
  
    @Override  
    public String toString() {  
        StringBuilder printout = new StringBuilder();  
  
        for (Category category : Category.values()) {  
            List<MenuItem> menuItems = menus.get(category);  
            printout.append(String.format("<%s>\n", category.getName()));  
            String menus = String.join(", ", menuItems.toString());  
            menus = menus.replace("[", "");  
            menus = menus.replace("]", "");  
            printout.append(menus);  
            printout.append("\n");  
            printout.append("\n");  
        }  
        return printout.toString();  
    }  
  
  
}
```