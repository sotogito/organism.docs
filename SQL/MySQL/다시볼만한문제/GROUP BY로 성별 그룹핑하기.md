- GROUP BY 의 조건과 분별하고 어떤 값들로 구분이 되는지 생각하자
- CASE WHEN THEN END 구문은 if-else 문과 다르다

  ## 문제
  -- 3. 성별 급여의 평균(정수처리), 급여의 합계, 인원수를 조회한 뒤 인원수로 내림차순을 정렬 하시오.
/*
    ------------------- 출력 예시 -------------------
    셩별     평균          합계           인원수
    -------------------------------------------------
    남       3,317,333     49,760,000       15
    여       2,757,360     24,816,240       9

*/

### 해결 1
```sql
  SELECT
    CASE
        WHEN SUBSTRING(EMP_NO,8,1) IN (1,3) THEN '남자'
        WHEN SUBSTRING(EMP_NO,8,1) IN (2,4) THEN '여자'
        ELSE '논바이너리'
    END AS 성별
    ,AVG(SALARY)
    ,SUM(SALARY)
    ,COUNT(*)
    
FROM
    employee

GROUP BY
    SUBSTRING(EMP_NO,8,1)
;
```
- 문제 1
성별을 판단하는 인덱스를 기준으로 할 경우는 1,2,3,4 총 4가지의 경우가 있어서 남/여 가 아니라 4가지의 경우로 그룹핑된다.


### 해결 2
```sql
  GROUP BY
    SUBSTRING(EMP_NO,8,1) IN (1,3);
```
그래서 남자를 기준으로 했더니 2개의 행이 나왓다. 이거까지는 잘 했다고 생각했는데
출력해보니 오류가 뜬다.

 LIMIT 0, 1000	Error Code: 1055. Expression #1 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'empdb.employee.EMP_NO' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by	0.000 sec

무슨문젠가 보니 내가 그룹핑한 조건을 만약 if문으로 변경해보면 다음과 같다
```java
if(남자){
    return 1;
} else{
    return 0;
}
```
그래서 분리된 명확한 값이 그룹핑의 기준이 되지 않는다. 

### 해결3
```sql
    CASE
        WHEN 1 THEN '남자'
        WHEN 0 THEN '여자'
        ELSE '논바이너리'
    END AS 성별
```
그래서 로직은 바꿀꺼지만 이렇게 하면 동작이 될까? 하고 시도해봤는데 성별에는 남자만 출력되었다.  
남자  
남자  
그래서 지피티한테 물어보니까 CASE문은 내가 알고있던 동작 방식과 완전 다르게 동작했다.
나는 IF문과 같이 동작할거라고 생각했다.
1. GROUP BY에서 남자는 1, 여자는 0으로 분리 -> [1.0]
2. SELECT에 1이 먼저 들어가서 CASE문에서 남자 출력 + 그 뒤에 컬럼 출력
3. SELECT에 0이 들어가서 CASE문에서 여자 출력 + 그 뒤에 컬럼 출력

1. GROUP BY에서 남자는 1, 여자는 0으로 분리됨 → 그룹 리스트 [1, 0]
   SUBSTRING(EMP_NO,8,1) IN (1,3)의 결과값이 남자 → TRUE(1), 여자 → FALSE(0)
3. SELECT에서 먼저 1 그룹(남자)이 처리됨
   CASE 문 실행 → WHEN 0 THEN '여자'는 거짓(FALSE)이므로 실행되지 않음
WHEN 1 THEN '남자'는 참(TRUE)이므로 '남자' 출력
5. 그 뒤에 AVG(SALARY), SUM(SALARY), COUNT(*) 출력됨
   다음으로 0 그룹(여자)이 처리됨
CASE 문 실행 → WHEN 0 THEN '여자'는 거짓(FALSE)이므로 실행되지 않음
WHEN 1 THEN '남자'는 참(TRUE)이므로 여자도 '남자'로 출력됨(!)
결과적으로 모든 행이 '남자'로 출력됨

---
### 해결 코드
```sql
SELECT
    CASE
        WHEN SUBSTRING(EMP_NO, 8, 1) IN ('1', '3') THEN '남자'
        WHEN SUBSTRING(EMP_NO, 8, 1) IN ('2', '4') THEN '여자'
        ELSE '논바이너리'
    END AS 성별,
    AVG(SALARY),
    SUM(SALARY),
    COUNT(*)
FROM
    employee
GROUP BY
    CASE
        WHEN SUBSTRING(EMP_NO, 8, 1) IN ('1', '3') THEN '남자'
        WHEN SUBSTRING(EMP_NO, 8, 1) IN ('2', '4') THEN '여자'
        ELSE '논바이너리'
    END;
```

```sql
SELECT
    CASE
        WHEN SUBSTRING(EMP_NO, 8, 1) IN ('1', '3') THEN '남자'
        WHEN SUBSTRING(EMP_NO, 8, 1) IN ('2', '4') THEN '여자'
        ELSE '논바이너리'
    END AS 성별,
    AVG(SALARY),
    SUM(SALARY),
    COUNT(*)
FROM
    employee
GROUP BY
    성별;

```
