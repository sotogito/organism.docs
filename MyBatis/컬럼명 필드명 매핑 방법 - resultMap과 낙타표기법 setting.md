- resultMap 을 더 권장
---
### resultMap
- mapper.xml
```xml
    <resultMap id="menuResultMap" type="com.sotogito.dto.MenuDto">
        <id      column="menu_code"         property="menuCode"/>
        <result  column="menu_name"         property="menuName"/>
        <result  column="menu_price"        property="menuPrice"/>
        <result  column="category_code"     property="categoryCode"/>
        <result  column="orderable_status"  property="orderableStatus"/>
    </resultMap>

    <select id="selectMenuByCode" parameterType="_int" resultMap="menuResultMap">
        SELECT
            menu_code
          , menu_name
          , menu_price
          , category_code
          , orderable_status
        FROM
            tbl_menu
        WHERE
            menu_code = #{menuCode}
    </select>
```
### mapUnderscoreToCamelCase
- mybatis-config.xml
- 자동으로 컬럼명이 낙타표기법 필드명 스타일로 적용된다 (menu_code -> menuCode)
```xml
<configuration>
    <settings>
        <setting name="mapUnderscoreToCamelCase" value="True"/>
    </settings>

.
.
.
```
- mapper.xml
```xml
    <select id="selectMenuByCode" parameterType="_int" resultType=""com.sotogito.dto.MenuDto>
        SELECT
            menu_code
          , menu_name
          , menu_price
          , category_code
          , orderable_status
        FROM
            tbl_menu
        WHERE
            menu_code = #{menuCode}
    </select>
```

- 작은 프로젝트거나 컬럼명 = 필드명 거의 일치 → 낙타표기법 자동 매핑 설정 추천
- 컬럼명과 필드명이 다르거나 조인, 복잡한 매핑이 많음 → resultMap 추천
