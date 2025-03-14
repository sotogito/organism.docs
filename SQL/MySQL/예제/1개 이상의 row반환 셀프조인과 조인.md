### FROM절 JOIN 사용
```sql
SELECT
    s.STUDENT_NO
    ,g.POINT
FROM
    tb_student s
    JOIN tb_grade g ON g.STUDENT_NO = s.STUDENT_NO;
```
JOIN을 사용하면 tb_student와 tb_grade를 조인하면서 학생 번호(STUDENT_NO)를 기준으로 매칭된 모든 행을 반환  
JOIN은 여러 개의 행을 허용하면서 조인된 데이터셋을 확장하는 방식

### SELF JOIN
```sql
SELECT
    s.STUDENT_NO
    ,(SELECT POINT FROM tb_grade WHERE STUDENT_NO = s.STUDENT_NO)
FROM
    tb_student s;
```
Error Code: 1242. Subquery returns more than 1 row  

위에와 마찬가지로 SELECT POINT FROM tb_grade WHERE STUDENT_NO = s.STUDENT_NO 서브쿼리는 s.STUDENT_NO에 해당하는 모든 점수(POINT)를 반환한다  
하지만 서브쿼리는 단일 값만 반환할 수 있어야 하는데, 여러 개의 행이 반환되면 오류가 발생한다.
