```xml
    <update id="updateMenu" parameterType="map">
        UPDATE
            tbl_menu
        <set>
            <if test="name != null and name != ''">
                menu_name = #{name},
            </if>
            <if test="category != null and category != ''">
                category_code = #{category},
            </if>
            <if test="orderable != null and orderable != ''">
                orderable_status = #{orderable}
            </if>
        </set>
        WHERE
            menu_code = #{code}
    </update>
```
- <trim>
```xml
<trim prefix="SET" suffixOverrides=",">
            <if test="name != null and name != ''">
                menu_name = #{name},
            </if>
            <if test="category != null and category != ''">
                category_code = #{category},
            </if>
            <if test="orderable != null and orderable != ''">
                orderable_status = #{orderable}
            </if>
        </trim>
```
