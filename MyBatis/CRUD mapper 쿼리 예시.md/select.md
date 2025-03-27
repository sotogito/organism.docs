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
```java
    public List<String> selectMenuNameList(SqlSession sqlSession) {
        return sqlSession.selectList("MenuMapper.selectMenuNameList");
    }
```
---

- ResultMap
```xml
    <resultMap id="menuResultMap" type="com.sotogito.dto.MenuDto">
        <id       column="menu_code"        property="menuCode"/>
        <result  column="menu_name"         property="menuName"/>
        <result  column="menu_price"        property="menuPrice"/>
        <result  column="category_code"     property="categoryCode"/>
        <result  column="orderable_status"  property="orderableStatus"/>
    </resultMap>
```
```xml
    <select id="selectOrderableMenuList" resultMap="menuResultMap">
        SELECT
            menu_code
          , menu_name
          , menu_price
          , category_code
          , orderable_status
        FROM
            tbl_menu
        WHERE
            orderable_status = 'Y'
    </select>
```

```java
    public List<MenuDto> selectOrderableMenuList(SqlSession sqlSession) {
        return sqlSession.selectList("MenuMapper.selectOrderableMenuList");
    }
```


---
- 비추
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
```java
    public List<MenuDto> selectOrderableMenuList(SqlSession sqlSession) {
        return sqlSession.selectList("MenuMapper.selectOrderableMenuList");
    }
```
