SELECT  
FROM
```xml
    <select id="selectMenuNameList" resultType="string"><!--java.lang.String-->
        SELECT
            menu_name
        FROM
            tbl_menu
    </select>
```

```xml
    <select id="selectOrderableMenuList" resultType="com.sotogito.dto.MenuDto">
        SELECT
            menu_code            AS menuCode
          , menu_name            AS menuName
          , menu_price           AS menuPrice
          , category_code        AS categoryCode
          , orderable_status     AS orderableStatus
        FROM
            tbl_menu
        WHERE
            orderable_status = 'Y'
    </select>
```
