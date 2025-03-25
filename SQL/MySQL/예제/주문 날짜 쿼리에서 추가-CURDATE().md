```sql
    <entry key="insertOrder">
        INSERT VALUE
            tbl_order_menu
            (
                order_date
                ,order_time
                ,total_order_price
            )
        VALUES
        (
            DATE_FORMAT(  CURDATE(), '%y/%m/%d' ) 
            ,DATE_FORMAT( CURDATE(), '%H:%i:%s' )
            ,?
        )
    </entry>
```
