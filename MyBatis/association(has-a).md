- 복잡한 타입의 연관관계로 1:1 포함관계(has-a)를 매핑
---
```java
public class MenuDto {
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;

    /// 메뉴가 가지는 카테고리 정보를 담기 위한 dto
    /// 1:1관계 - has a
    private CategoryDto category;
}
```
1. 바로 하나의 resultMap에 작성
```xml
    <resultMap id="menuResultMap3" type="MenuDto">  상위DTO
        <id     column="menu_code"  property="menuCode"/>
        <result column="menu_name"  property="menuName"/>
        <result column="menu_price" property="menuPrice"/>

        <association property="category" javaType="CategoryDto"> 필드 DTO
            <id     column="category_code"     property="categoryCode"/>
            <result column="category_name"     property="categoryName"/>
            <result column="ref_category_code" property="refCategoryCode"/>
        </association>
    </resultMap>
```
3. CategoryDto 매핑시키는 resultMal이 존재할 경우
```xml
    <resultMap id="categoryResultMap" type="CategoryDto">
        <id     column="category_code"     property="categoryCode"/>
        <result column="category_name"     property="categoryName"/>
        <result column="ref_category_code" property="refCategoryCode"/>
    </resultMap>

    <resultMap id="menuResultMap3" type="MenuDto">
        <id     column="menu_code"  property="menuCode"/>
        <result column="menu_name"  property="menuName"/>
        <result column="menu_price" property="menuPrice"/>
        <association property="category" resultMap="categoryResultMap"/>
    </resultMap>
```
