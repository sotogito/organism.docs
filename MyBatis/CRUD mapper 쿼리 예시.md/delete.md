DELETE  
WHERE
```xml
    <delete id="deleteMenu" parameterType="_int">
        DELETE
        FROM
            tbl_menu
        WHERE
            menu_code = #{menuCode}
    </delete>
```
