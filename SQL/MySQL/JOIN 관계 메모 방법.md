```sql
SELECT
    EMP_NAME
    ,EMP_NO
    ,PHONE
    ,DEPT_TITLE # -> department-> (DEPT_ID,DEPT_CODE) -> employee
    ,JOB_NAME # -> job (JOB_CODE,JOB_CODE) -> employee
FROM
    employee e
     JOIN department d ON d.DEPT_ID = e.DEPT_CODE
     JOIN job j ON j.JOB_CODE = e.JOB_CODE
;
```
두 테이블사이에 어떤 공통의 컬럼관계가 있는지 메모하면서 하는 걸 추천

```sql
DEPT_TITLE # -> department-> (DEPT_ID,DEPT_CODE) -> employee
```
DEPT_TITLE는 department에 있는 컬럼이고, employee와 공통적으로 재정의 할 수 있는 컬럼은 각각 (DEPT_ID,DEPT_CODE)이다.

