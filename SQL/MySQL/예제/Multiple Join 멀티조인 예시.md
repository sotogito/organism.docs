```sql
SELECT
    EMP_ID
    ,EMP_NAME
    ,JOB_NAME # -> job -> (JOB_CODE,JOB_CODE) ->employee
    , DEPT_TITLE # -> department -> (DEPT_ID,DEPT_CODE) ->employee
FROM
    employee e
        JOIN job j ON j.JOB_CODE = e.JOB_CODE
        JOIN department d on d.DEPT_ID = e.DEPT_CODE
        JOIN location l ON l.LOCAL_CODE = d.LOCATION_ID
WHERE
    QUIT_YN = 'N'
AND JOB_NAME = '대리'
AND LOCAL_NAME LIKE 'ASIA%'
;
```
- [JOB_NAME] -> job -> (JOB_CODE,JOB_CODE) ->employee
- [DEPT_TITLE] -> department -> (DEPT_ID,DEPT_CODE) ->employee
- [LOCAL_NAME] -> location -> (LOCAL_CODE,LOCATION_ID) ->department -> (DEPT_ID,DEPT_CODE) ->employee
