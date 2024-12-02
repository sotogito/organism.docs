#### Enum
```java

public enum Singleton {
    INSTANCE;

    private final List<String> items = new ArrayList<>();

    public void addItem(String item) {
        items.add(item);
    }

    public List<String> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void clearItems() {
        items.clear();
    }
}
```

#### 사용
```java
Singleton singleton = Singleton.INSTANCE;


Singleton.INSTANCE.clearItems();
```