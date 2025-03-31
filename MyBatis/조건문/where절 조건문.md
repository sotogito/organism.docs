```java
        Scanner sc = new Scanner(System.in);
        System.out.println("검색 기능 사용? 예 아니오");

        int menuCode = 0;
        if("예".equals(sc.nextLine())){
            System.out.println("검색할 메뉴 번호");
            menuCode = Integer.parseInt(sc.nextLine());
        }
```
- 사용자에게 검색 기능 사용 여부를 입력받고 만약 검색 기능이 활성화가 되면 menuCode는 0이아닌 다른 값이 들어간다.

```xml
    <select id="selectMenuByCodeOrSearchAll" parameterType="_int" resultMap="menuResultMap">
        SELECT
            menu_code
          , menu_name
          , menu_price
          , category_code
          , orderable_status
        FROM
            tbl_menu
        <where>
            <if test="menuCode != 0">
                menu_code = #{menuCode}
            </if>
        </where>
    </select>
```
---
```xml
    <select id="selectMenuByNameOrCategory3" parameterType="map" resultMap="menuResultMap">
        SELECT
            menu_code
          , menu_name
          , menu_price
          , category_code
          , orderable_status
        FROM
            tbl_menu
        <where>
            <if test="name != null and name !=''">
                 menu_name LIKE CONCAT('%', #{name}, '%')
            </if>-->
            <if test="category != null">
                OR category_code = #{category}
            </if>
        </where>
    </select>
```
- 메뉴로만OR카테고리로만OR둘다OR둘다아닌경우

```xml
        <trim prefix="WHERE" prefixOverrides="AND|OR"> <!--만약 and or이 앞에 있으면 지우고 where작성-->
            <if test="name != null and name !=''">
                menu_name LIKE CONCAT('%', #{name}, '%')
            </if>
            <if test="category != null">
                OR category_code = #{category}
            </if>
        </trim>
```
