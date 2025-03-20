### setString에서 추가 - 추천
```sql
String query = "SELECT * FROM employee WHERE emp_name LIKE ?";

ps = conn.prepareStatement(query);
ps.setString(1, input + "%"); 
rs = ps.executeQuery();
```

### CONCAT 활용
```sql
String query = "SELECT * FROM employee WHERE emp_name LIKE CONCAT(?, '%')";

ps = conn.prepareStatement(query);
ps.setString(1, input);
rs = ps.executeQuery();
```
단
- ?는 단독으로 사용되어야 하며, SQL 내부에서 직접 문자열을 연결할 수 없음.
- 이렇게 하면 SQL 실행 시 에러가 발생할 가능성이 높음.
