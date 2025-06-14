#### 고아객체 ORPHAN
부모 엔티티와 연관관계가 끊어진 자식 엔티티

#### OrphanRemovel
- 부모 엔티티의 컬렉션에서 자식 엔티티의 참조만 제거하면 자식 엔티티도 자동으로 삭제됨
- 즉, 더이상 부모 엔티티에서 참조되지 않을 때 자식을 db에서 삭제
- 영속성 컨테이너에 남아있지 않아야 삭제
- `@OneToOne`, `@OneToMany`에만 사용할 수 있다.

|설정|동작|설명|
|---|---|---|
|`orphanRemoval = false` (기본값)|자식 객체를 리스트에서 제거해도 DB에 **남아 있음**|`delete` 쿼리 안 나감|
|`orphanRemoval = true`|자식 객체를 리스트에서 제거하면 DB에서도 **삭제됨**|`delete` 쿼리 나감|

```java
@OneToMany(mappedBy = "parent", orphanRemoval = true)
private List<Child> children = new ArrayList<>();
```

```java
parent.getChildren().remove(child); // DB에서 child도 삭제됨 (orphanRemoval = true일 경우)
```
원래는 em.flush()을 해줘야만 db로 delete쿼리를 남긴다.