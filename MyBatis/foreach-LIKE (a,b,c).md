#### List를 넘길 경우
```xml
    <delete id="deleteMenu" parameterType="list">
        DELETE
        FROM tbl_menu
        WHERE
            menu_code IN
            <foreach collection="list" item="code" open="(" separator="," close=")">
                #{code}
            </foreach>
    </delete>
```
- for(String code : codeList)와 동일하다.
- collection에 자료형인 list를 작성해주면 된다.

### map을 넘긴 경우
```xml
    <delete id="deleteMenu" parameterType="map">
        DELETE
        FROM tbl_menu
        WHERE
        menu_code IN
        <foreach collection="deleteMenuCodes" item="code" open="(" separator="," close=")">
            #{code}
        </foreach>
    </delete>
```
- collection에 KEY값을 작성한다.
