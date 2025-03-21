### Statement : SQL 쿼리 실행
- 데이터베이스에 SQL 쿼리를 실행하기 위해 사용되는 객체
  예를 들어, 데이터 조회 (SELECT), 데이터 삽입 (INSERT), 데이터 삭제 (DELETE) 등을 할 때 SQL 문을 실행하는 역할
- 정적 sql문을 직접 실행하고 쿼리 실행 결과는 ResultSet객체로 넘겨줌
- 고정적인 쿼리 실행에 유용
- Connection 객체에 메서드를 통해 생성
#### 쿼리 실행 메서드
1. executeQuery(sql문)   :   select문 실행 => ResultSet 결과 반환
2. executeUpdate(sql문)  :  dml문 실행 => int 결과 반환

---
### ResultSet : 쿼리 실행 결과 담고 읽기
- SELECT 쿼리로 조회된 데이터를 담고 있는 객체
- 쿼리르 실행한 후 결과 데이터를 ResultSet에 저장하고, ResultSet을 사용하여 데이터를 하나씩 읽고 처리(next)
#### 주요 메서드
1. next() : 다음 row를 참조하기 위해 커서를 움직여주는 메서드 (존재true/존재안함flase)
2. getInt(컬럼) : 현재 참조하는 행의 해당 컬럼의 값을 int 형으로 반환
2. getString(컬럼)
3. getDate(컬럼)
