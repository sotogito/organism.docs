```
-- 19. 모든 구매 고객의 이름과 총구매액(price * amount)과 구매횟수를 조회하시오. 구매 이력이 없는 고객은 총구매액과 구매횟수를 0으로 조회하고, 고객번호 오름차순으로 정렬하시오.
-- 고객명  총구매액  구매횟수
-- 박지성  116000     3
-- 김연아  19000      2
-- 장미란  62000      3
-- 추신수  86000      2
-- 박세리  0          0
```

#### 풀이1
```sql
SELECT
    cust_name
    ,IFNULL(SUM(price * amount),0)
    ,COUNT(amount)
FROM
    tbl_order o
        RIGHT JOIN tbl_customer c ON c.cust_id = o.cust_id
        LEFT JOIN tbl_book b ON b.book_id = o.book_id
GROUP BY
    cust_name
;
```
원래 처음에는 tbl_customer만 RIGHT로 남겨줬다. 왜냐면 고객의 열을 모두 다 출력한다고 가정하면 당연히 구매 내역이 없는 사용자도 출력될거라고 생각했는데, 아니었다.

```sql
SELECT
    cust_name
    ,COUNT(amount)
FROM
    tbl_order o
        RIGHT JOIN tbl_customer c ON c.cust_id = o.cust_id
GROUP BY
    cust_name
;
```
내가 알고있는게 아닌가싶어서 다시 작성해보니 내가 생각한대로 구매하지 않은 사용자도 출력되었다.  
- RIGHT JOIN을 사용했기 때문에 tbl_book에 있는 모든 책을 포함하고,
- tbl_order에 해당 책의 주문이 없으면 order_id는 NULL이 되었다.
  
그런데 왜 위에서는 출력이 안되는걸까  
일단 조인 후 조합의 형태를 생각해봐야한다. 
그리고 조인도 순차적으로 조합을 만든다는 것을 기억해야한다1~!~!`1  

1. RIGHT JOIN tbl_customer : 모든 고객을 기준으로 조인된다, 즉 주문이 없는 고객도 포함된다.
2. JOIN tbl_book : 근데 여기서 그냥 INNDER JOIN이라 다시 tbl_order의 행이 기준이 된다. - 주문이 없는 고객이 제거된다.
#### 그럼 여기서 또하나 의문점을  JOIN tbl_book에게 LEFT 테이블은 누구일까?
바로 첫번째 조인의 조합의 결과 RIGHT JOIN tbl_customer c ON c.cust_id = o.cust_id -> 이것으로 만들어진 사용자 행을 남긴 tbl_customer + tbl_order 조합이다.  

### 순차적으로 조합된다면 그럼 JOIN 순서를 조심하자
```sql
        JOIN tbl_book b ON b.book_id = o.book_id
        RIGHT JOIN tbl_customer c ON c.cust_id = o.cust_id
```
1. JOIN tbl_book 그냥 INNER조인으로 공통된 컬럼의 조합만 생성한다.
2. RIGHT JOIN tbl_customer 가장 마지막에 위치한 조인으로 최종적으로 tbl_customer행을 남긴다.
