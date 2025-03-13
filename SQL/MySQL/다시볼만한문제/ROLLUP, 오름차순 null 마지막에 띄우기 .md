    기술지원부       2       4550000             2275000  
    인사관리부       3       7820000             2606666.6666666665  
    총무부           3       17700000            5900000  
    해외영업1부      6       15760000            2626666.6666666665  
    해외영업2부      3       10100000            3366666.6666666665  
    회계관리부       4       11000000            2750000  
    21       66930000            3187142.8571428573

---
``` sql
SELECT
    DEPT_TITLE AS 부서명
    ,COUNT(*) AS 인원
    ,SUM(SALARY) AS 급여합계
    ,AVG(SALARY) AS 급여평균
FROM
    department
        join employee on DEPT_CODE = DEPT_ID
WHERE
    QUIT_YN = 'N'
GROUP BY
    DEPT_TITLE 
WITH ROLLUP
ORDER BY
    ISNULL(DEPT_TITLE)
    ,부서명    
;
```
ORDER BY에 ISNULL(DEPT_TITLE)를 추가해두지 않으면 집계 결과가 가장 상단에 배치된다.  
왜?  
오름차순으로 정렬하면 NULL 값은 최소값으로 취급되므로 상단에 위치하는거다.  
그래서 내림차순 DESC해주면 null은 마지막에 뜬다.  

근데 그래서 ISNULL(DEPT_TITLE)가 어떻게 NULL을 마지막에 띄울 수 있는걸까  

``` sql
ORDER BY 
    ISNULL(DEPT_TITLE),  -- (1) NULL이면 1, 아니면 0 → 0(부서) 먼저, 1(NULL) 나중
    부서명;              -- (2) 같은 그룹(0) 내에서 부서명 가나다순 정렬

```
데이터는 하나나 순회하면서 투입
1. ISNULL(DEPT_TITLE) 실행
   - NULL이면 1반환
   - 아니면 0 반환
2. 부서명 정렬 (ISNULL이 0인 경우만)
   - ISNULL(DEPT_TITLE) = 0인 행들(부서명 존재)끼리만 부서명 기준으로 정렬

그리고 위의 코드는 오름라순 정렬이기 때문에 null일 경우 ISNULL에서 1이 되었기 때문에 맨 마지막에 배치된다.

#### 그럼!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
만약 순서를 바꿔보면 어떻게될가  
```sql
ORDER BY 
    부서명, 
    ISNULL(DEPT_TITLE);
```
이 경우에도 마찬가지다. 부서명 즉 가나다라대로 정렬을 했다가 만약에 같은 부서명이 있을 경우 ISNULL(DEPT_TITLE)을 기준으로 추가 정렬을 시도한다.
