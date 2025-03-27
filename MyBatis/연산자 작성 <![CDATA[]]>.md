```xml
    <select id="selectMenuCountBelowPrice" parameterType="_int" resultType="_int">
        <![CDATA[
            SELECT
                COUNT(*)
            FROM
                tbl_menu
            WHERE
                menu_price <= #{menuPrice}
        ]]>
    </select>
```
- XML 파서가 <, &, > 같은 특수문자를 "태그"나 "엔티티"로 해석하지 않게 하는 용도이다.
