CASCADE.All : 부모시 자식도
orphanRemoval : 자식이 부모에서 벗어나면 자동 삭제

#### 저장 : 부모에만 등록하면 됨 - CASCADE
```java
Parent parent = em.find(Parenr.class, parentId);
parent.addChild(newChild);
```

#### 삭제 : 부모에서만 제거 - orphanRemoval
```java
Parent parent = em.find(Parenr.class, parentId);
parent.getChildren().remove(removeObject);
```


