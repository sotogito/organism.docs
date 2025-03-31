- 검색 키워드에 따라 검색 결과를 반환한다. 
- if-else문과 동일한 동작을 한다.
### menu-mapper
```xml
      <select id="selectMenuByNameOrCategory2" parameterType="map" resultMap="menuResultMap">
        SELECT
            menu_code
          , menu_name
          , menu_price
          , m.category_code
          , orderable_status
        FROM
            tbl_menu m
            <if test="condition == 'category'">
                JOIN tbl_category c ON c.category_code = m.category_code
            </if>
        WHERE
        <choose>
            <when test="condition == 'name'">
                 menu_name LIKE CONCAT('%',#{value},'%')
            </when>
            <otherwise>
                 category_name = #{value}
            </otherwise>
        </choose>
        AND  orderable_status = 'Y'
        ORDER BY
            menu_code DESC
    </select>
```
when은 if문 otherwise는 else문이라고 생각하면 된다.
