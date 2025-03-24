```sql
    <entry key="selectAllMenu">
        SELECT
            menu_code
            ,menu_name
            ,menu_price
            ,category_name
            ,IF(orderable_status = 'Y', '주문가능', '주문불가') AS orderable_status
        FROM
            tbl_menu m
                LEFT JOIN tbl_category c ON c.category_code = m.category_code
    </entry>
```
