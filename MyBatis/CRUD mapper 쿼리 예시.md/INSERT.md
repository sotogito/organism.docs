INSERT INTO  
VALUES
```xml
    <insert id="insertMenu" parameterType="com.sotogito.dto.MenuDto">
        INSERT INTO
            tbl_menu
            (
              menu_name
            , menu_price
            , category_code
            , orderable_status
            )
        VALUES
            (
              #{menuName}
            , #{menuPrice}
            , #{categoryCode}
            , #{orderableStatus}
            )
    </insert>
```
