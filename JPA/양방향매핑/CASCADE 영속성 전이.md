
``` java
@ManyToOne
private Parent parent;
```

```java
@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
private List<child> children;
```

- JPA에서 엔티티를 저장할 때 연관된 모든 엔티티는 영속 상태여야한다.
- cascade는 영속성 전이로 parent엔티티가 영속화가 되면 child도 자동으로 영속성 상태를 전파해주는 것이다.

---
양방향 매핑일 경우 **저장 직후 부모 객체에서 자식 목록을 바로 써야 할 때** 동기화를 조심해야한다.

```
Parent parent = parentRepository.findById(1L).orElseThrow();
Child child = new Child();

child.setParent(parent);
parent.getChildren().add(child);

childRepository.save(child); // ❌ 아직 parent에는 저장 안 됨!
parentRepository.save(parent); // 직접 저장해야 함
```

둘 다 저장하기 위해서는 영속성 상태로 만들기 위해서 각각 접근해 주었어야했다.  
만약 CASCADE 제약을 걸어둘 경우에는 CASCADE 제약조건을 걸어둔 엔티티의 변경에도 동기화가 된다.

```java
Parent parent = parentRepository.findById(1L).orElseThrow();
Child child = new Child();

child.setParent(parent);
parent.getChildren().add(child); // ✅ 자바 객체 일관성 맞추기

parentRepository.save(parent); // ✅ 자식까지 자동 저장됨
```
보통 부모에 제약조건을 걸어두어 부모에서 변경을 하면 자식도 자동으로 저장이 된다.  
부모 -> 자식으로 영속성 전이.




만약 자식만 단순히 db에 추가하려면 자식repo.save()해주면 됨. 이건 CASCADE 제약 조건 없이도 가능
```java
Parent parent = parentRepository.findById(1L).orElseThrow();
Child child = new Child();
child.setParent(parent);

// parent.getChildren().add(child); ❌ 안 함
childRepository.save(child);
```


| 기준                             | 설명                |
| ------------------------------ | ----------------- |
| `cascade` 있는 쪽                 | "저장 책임"을 가짐       |
| `@OneToMany` 쪽에 `cascade`가 있으면 | **부모만 save 하면 됨** |
| `@ManyToOne` 쪽만 있고 cascade 없음  | **자식만 save 해야 함** |
| 단방향 관계 + cascade 없음            | 양쪽 다 직접 save 해야 함 |