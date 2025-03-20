- Statement 하위 인터페이스
- ? -> 플레이스홀더를 사용해 런타임 중 매개변수에 값을 전달시킬 수 있음 => 동적쿼리
  사용자의 입력에 따라 매번 달라질 수 있음


  ### 왜 String + 또는 String.format() 대신 PreparedStatement를 사용할까?
  ->  SQL Injection 방지, 성능 최적화, 유지보수 용이성

  - SQL Ingection인젝션
    SQL문을 조작해서 데이터베이스를 마음대로 조작하는 해킹 기법
