표준 SQL 규칙에서는, **GROUP BY에 없는 컬럼이 SELECT 절에서 그대로 쓰이려면**, 그 컬럼이 “해당 그룹 안에서 유일하게 결정되는(함수적 종속)” 경우에만 허용된다.  

즉, “같은 `STUDENT_NO`면 `STUDENT_NAME`도 항상 똑같다”라는 사실을 DB가 **명시적으로** 알 수 있어야 한다.


```sql
SELECT
    s.STUDENT_NO,
    s.STUDENT_NAME
FROM tb_student s
JOIN tb_department d ON d.DEPARTMENT_NO = s.DEPARTMENT_NO
JOIN tb_grade g ON g.STUDENT_NO = s.STUDENT_NO
WHERE d.DEPARTMENT_NAME = '국어국문학과'
GROUP BY s.STUDENT_NO, s.STUDENT_NAME\

ORDER BY AVG(g.POINT) DESC

LIMIT 1;
```

```sql
SELECT
    d.DEPARTMENT_NAME,
    AVG(g.POINT) AS avg_point
FROM tb_grade g
JOIN tb_student s ON g.STUDENT_NO = s.STUDENT_NO
JOIN tb_department d ON s.DEPARTMENT_NO = d.DEPARTMENT_NO

GROUP BY d.DEPARTMENT_NAME;
```
이름-성적으로 저장된 테이블이 있다면 학생의 이름으로 그룹핑하고 학점들을 집계한다.
