```java
return List.of(리스트요소직접담기);
```

```java
return List.copyOf(리스트);
```

```java
Collections.unmodifiableList(list);
```

| **방법**                             | **설명**                                  | **특징**                                      |
| ---------------------------------- | --------------------------------------- | ------------------------------------------- |
| List.of(...)                       | Java 9 이상에서 직접 불변 리스트를 생성               | 완전 불변, null 불허용, 요소 추가/삭제/수정 불가             |
| List.copyOf(existingList)          | 기존 컬렉션의 요소를 복사하여 불변 리스트를 생성             | 원본은 그대로이며, 복사된 리스트는 완전 불변                   |
| Collections.unmodifiableList(list) | 기존 리스트를 수정할 수 없도록 감싸는 불변 뷰를 반환          | 원본 리스트가 변경되면 뷰에도 반영되므로 완전한 불변은 아님           |
| Guava ImmutableList.of(...)        | Google의 Guava 라이브러리에서 제공하는 완전 불변 리스트 생성 | 완전 불변, null 불허용, 성능 및 안정성이 우수 (외부 라이브러리 필요) |
