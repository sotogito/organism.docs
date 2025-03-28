복잡한 타입의 연관관계로 1:N 포함관계(has-many) 를 매핑
---
```java
public class OrderDto {
    private int orderCode;
    private String orderDate;
    private String orderTime;
    private int totalOrderPrice;

    // 1:N - has-many
    private List<OrderMenuDto> orderMenuList;
}
```
- 한번에
```xml
    <resultMap id="orderResultMap" type="OrderDto">
        <id     column="order_code"        property="orderCode"/>
        <result column="order_date"        property="orderDate"/>
        <result column="order_time"        property="orderTime"/>
        <result column="total_order_price" property="totalOrderPrice"/>

        <collection property="orderMenuList" ofType="OrderMenuDto">
            <result column="menu_code"    property="menuCode"/>
            <result column="order_amount" property="orderAmount"/>
        </collection>
    </resultMap>
```
- 분리
```xml
    <resultMap id="orderMenuResultMap" type="OrderMenuDto">
        <result column="menu_code"    property="menuCode"/>
        <result column="order_amount" property="orderAmount"/>
    </resultMap>

    <resultMap id="orderResultMap" type="OrderDto">
        <id     column="order_code"        property="orderCode"/>
        <result column="order_date"        property="orderDate"/>
        <result column="order_time"        property="orderTime"/>
        <result column="total_order_price" property="totalOrderPrice"/>
        <collection property="orderMenuList" resultMap="orderMenuResultMap"/>
    </resultMap>
```
---
```sql
    <select id="testResultMapCollection" parameterType="_int" resultMap="orderResultMap">
        SELECT
            o.order_code
          , o.order_date
          , o.order_time
          , o.total_order_price
          , om.order_code
          , om.order_amount
        FROM
            tbl_order o
                JOIN tbl_order_menu om ON om.order_code = o.order_code
        WHERE
            o.order_code = #{orderCode}
    </select>
```
