### Application
```java
        System.out.println("""
                1. 메뉴명으로 키워드 검색
                2. 카테고리명으로 검색
                >>입력:""");
        String condition = switch (Integer.parseInt(sc.nextLine())) {
                                        case 1 -> "name";
                                        case 2 -> "category";
                                        default -> null;
                                    };

        System.out.println("검색어");
        String searchValue = sc.nextLine();

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("condition", condition);
        searchMap.put("value", searchValue);
```
검색 키워드를 입력받고 메뉴명or카테고리명으로 검색 결과를 반환한다.
### menu-mapper
```xml
    <select id="selectMenuByNameOrCategory1" parameterType="map" resultMap="menuResultMap">
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
            <if test="condition == 'name'">
                menu_name LIKE CONCAT('%',#{value},'%')
            </if>
            <if test="condition == 'category'">
                 category_name = #{value}
            </if>
        AND orderable_status = 'Y'
        ORDER BY
            menu_code DESC
    </select>
```
- FROM : 만약 카테고리 이름으로 검색할 경우는 tbl_cateogry와 JOIN해야하기 때문에 만약 검색 키워드가 카테고리일 경우 조인문이 실행될 수 있도록 한다.
- WHERE : if문을 중첩하여 사용하여 검색 키워드에 따라 조건절이 추가될 수 있도록 한다.
