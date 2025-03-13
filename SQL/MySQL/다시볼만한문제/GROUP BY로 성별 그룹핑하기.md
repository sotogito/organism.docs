- GROUP BY 의 조건과 분별하고 어떤 값들로 구분이 되는지 생각하자
- CASE WHEN THEN END 구문은 if-else 문과 다르다

  ## 문제
  
   3. 성별 급여의 평균(정수처리), 급여의 합계, 인원수를 조회한 뒤 인원수로 내림차순을 정렬 하시오.
    ------------------- 출력 예시 -------------------
    셩별     평균          합계           인원수
    -------------------------------------------------
    남       3,317,333     49,760,000       15
    여       2,757,360     24,816,240       9

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
그 이유는 바로 조건문이 잘못되었기 때문이다. 내가 작성한 코드를 자바 if문으로 바꿔보면
```java
if(1){
  남자
}else if (0){
  여자
}else{
  논바이너리
}
```
황당하다 이러니 당연히 남자만 추력될수 밖에 없다.

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

```sql
SELECT
    CASE
        WHEN SUBSTRING(EMP_NO, 8, 1) IN ('1', '3') THEN '남자'
        ELSE '여자'
    END AS 성별,
    FORMAT(AVG(SALARY),0),
    FORMAT(SUM(SALARY),0),
    COUNT(*)
FROM
    employee
GROUP BY
    성별
;
```

