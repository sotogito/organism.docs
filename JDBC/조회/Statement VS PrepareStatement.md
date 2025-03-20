### 1. 파라미터 바인딩
- Statement : 파라미터 바인딩 불가, 쿼리 문자열 그대로 실행
- PreparedStatement : ?(홀더)를 통해 파라미터 바인딩 가능 => 동적 쿼리 작업시 유용
  
### 2. SQL Injection
- Statement : SQL Injection에 취약
- PrepareStatement : 파라미터 바인딩 방식이므로 SQL Injection 방지 가능
  
### 3. 컴파일 방식
- Statement : sql문이 실행될 때마다 db엔진에서 매번 새롭게 컴파일
- PrepareStatement : 최초에 한번만 컴파일되고 캐싱되어 재사용됨 => 동일한 쿼리문을 반복실행할 때 더 빠름

## PrepareStatement 쓰자!
