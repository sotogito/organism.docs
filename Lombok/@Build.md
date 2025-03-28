```java
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CategoryDto {

    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;

}
```

```java
        CategoryDto category = CategoryDto.builder()
                .categoryName(categoryName)
                .refCategoryCode(refCategoryCode)
                .build();
```

- 가독성
- 안정성(불변 가능)
- 필드 많을 때 유리
