기본 조인은 조인하는 두 테이블이 서로 데이터가 공통적으로 존재할 때 매칭된다,
### LEFT JOIN
- 왼쪽 테이블의 행을 기본적으로 반환한다.
- 만약 오른쪽 테이블에 매칭되는 테이블이 없다면 그냥 null을 출력한다
```sql
	tbl_buy b
		left join tbl_user u on u.user_no = b.user_no
```
여기서 왼쪽 테이블은 tbl_buy가 된다.