UPDATE  
SET  
WHERE
```xml
    <update id="updateMenu" parameterType="com.sotogito.dto.MenuDto">
        UPDATE
            tbl_menu
        SET
            menu_name = #{menuName}
          , menu_price = #{menuPrice}
          , category_code = #{categoryCode}
        WHERE
            menu_code = #{menuCode}
    </update>
```
