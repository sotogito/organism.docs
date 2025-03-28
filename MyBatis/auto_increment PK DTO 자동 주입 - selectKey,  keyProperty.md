- 이전의 방식
1. 새로운 카테고리 INSERT
2. 새로운 카테고리 정보 SELECT
3. 가져온 카테고리 코드를 MenuDto에 넣고 신 메뉴 INSERT

- selectKey, useGeneratedKeys+keyProperty
1. 새로운 카테고리 + 새로운 메뉴 정보를 가진 DTO를 넘김
2. mapper에서 지정된 DTO의 필드에 auto_increment PK처리된 컬럼의 값을 지정해서 담음
---
### DTO 구조
- CategoryDto
```java
public class CategoryDto {
    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;
}
```
- MenuDto : CategoryDto를 하위로 갖는다 (has-a)
```java
public class MenuDto {
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;

    private CategoryDto category;
}
```
---
### menu-mapper.xml
#### selectKey
```xml
    <insert id="insertCategory" parameterType="MenuDto">-->
        <selectKey keyProperty="categoryCode" order="AFTER" resultType="_int"> 밑에 INSERT문이 실행 되고 실행되는 SELECT문
            SELECT LAST_INSERT_ID()-->
        </selectKey>-->
        INSERT INTO-->
            tbl_category-->
            (-->
              category_name-->
            , ref_category_code-->
            )-->
        VALUES-->
            (-->
              #{category.categoryName} 넘겨진 menudto의 필드
            , #{category.refCategoryCode}-->
            )-->
    </insert>-->
```
#### useGeneratedKey + keyProperty
- userGeneratedKeys : 생성된 키값을 활용할 건지 여부를 지정하는 속성(기본값 : false)
- keyProperty       : 생성 키값을 어떤 프로퍼티 담을 건지 지정하는 속성
  1. 새로운 카테고리 INSERT
```xml
    <insert id="insertCategory" parameterType="MenuDto"
            useGeneratedKeys="true" keyProperty="categoryCode">
        INSERT INTO
            tbl_category
            (
              category_name
            , ref_category_code
            )
        VALUES
            (
              #{category.categoryName} <!--넘겨진 menudto의 필드-->
            , #{category.refCategoryCode}
            )
    </insert>
```
useGeneratedKeys="true" keyProperty="categoryCode">이게 무슨소리냐면  

INSERT에서 DB가 자동 생성한 PK를 MenuDto의 categoryCode에 자동으로 주입해달라 라는 뜻이다.  
그럼 MenuDto에 새롭게 추가한 카테고리코드가 들어간 상태인것이다.
2. 똑같은 MenuDto로 새로운 메뉴 INSERT
```xml
    <insert id="insertMenu" parameterType="MenuDto">
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
MenuDto의 필드로 CategoryDto가 있기 때문에 동일한 DTO를 사용하여 처리한다.
---
### MenuMapper
```
    int insertCategory(MenuDto menu);
    int insertMenu(MenuDto menu);
```
여기서 내가 생각했던것과 달랐던 것은 insertCategory의 반환값이 int라는 점이다.  
insertCategory로직에서 categoryCode가 업데이트된 MenuDto를 만든다면 MenuDto를 반환할수는 없는걸까>?  
그게 안되는 이유는 다음과 같다.
1. 기본적으로 MyBatis INSERT는 row 수(int)를 반환한다.
2. 만약 된다 하더라도 서비스 측에서 성공적으로 insert가 되었는지 확인하기 어렵다.
그래서 어차피 넘겨준 객체를 계속 사용할거라는 점 + insert결과를 확인할 수 있다는 점에서 매개변수와 반환타입은 위 코드가 맞다.
---
### MenuService
```java
    public int insertCategoryAndMenu(MenuDto menu) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        int categoryInsertResult = menuMapper.insertCategory(menu);
        int insertMenuResult = menuMapper.insertMenu(menu);

        int result = 0;
        if(categoryInsertResult >0 && insertMenuResult >0) {
            result = 1;
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result;
    }
```
둘 중 하나라도 실패하면 트랜잭션이 실패하는 것이기 때문에 하나의 메서드에서 처리해준다.
