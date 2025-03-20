1. 애플리케이션과 데이터베이스 간의 연동에서 발생될 수 있는 취약점
2. 공격자가 악의적으로 조작된 쿼리를 삽입해 데이터베이스 정보를 불법적으로 조적할 수 있는 공격 기법
3. 사용자 입력값에 SQL문을 직접 삽입해 query를 완성시켜 조회되도록함

```sql
 String query = "SELECT * FROM employee WHERE emp_id = '" + inputEmpId + "'";
```
만약 위와같은 쿼리에서 사용자의 inputEmpId입력이 단순한id가 아니라sql문이면 실제로 동작하게 된다.  
그래서 이를 막고자 PreparedStatement를 사용한다.  
