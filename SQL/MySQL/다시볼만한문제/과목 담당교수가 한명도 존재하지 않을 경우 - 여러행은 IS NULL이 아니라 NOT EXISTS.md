```
-- 13. 예체능 계열 과목 중 과목 담당교수를 한명도 배정받지 못한 과목을 찾아 그 과목 이름과 학과 이름을 출력하는 SQL 문장을 작성하시오.
/*
    class_name          | department_name
    ----------------------------------------
    논문지도1	        | 공연예술학과
    무용기능학	        | 공연예술학과
    논문지도2	        | 도예학과
    도예기법연구	    | 도예학과
    공예창작연구	    | 디자인학과
    기업이미지디자인연구  | 디자인학과
        ..
    사회조사분석론	    | 체육학과
    스포츠산업연구	    | 체육학과
    운동처방연구	    | 체육학과
    해부학실험	        | 체육학과   
    ----------------------------------------
    
    44개의 행 조회
*/
```

1. 기준은 tb_class이다.
2. 예체능 계열 과목 : tb_department에서 카테고리가 예체능인 과목들의 DEPARTMENT_NO를 가져와 현재의 수업의 tb_department가 범위 안에 있는지 확인한다. (56~63)
3. 담당교수를 한명도 배정받지 못한 과목 : tb_class_professor목록에서 수업매칭이 단 한건도 없을 경우 배정받지 못한 과목이다.

이 문제에서 중요한 포인트는 담당 교수를 배정받지 못하는 경우를 판별하기 위해서는 산순히 그 데이터의 상태가 아니라 조건으로 반환된 데이터의 개수로 확인해야한다는 것이다.  
즉 1row가 아니라 1개 이상의 여러 row로 판단해야한다.

### 풀이1 서브쿼리 + NOT EXISTS
```sql
SELECT
	CLASS_NAME
    ,(SELECT DEPARTMENT_NAME FROM tb_department WHERE DEPARTMENT_NO = c.DEPARTMENT_NO) AS department_name
FROM
	tb_class c
WHERE
	c.DEPARTMENT_NO IN (SELECT DEPARTMENT_NO FROM tb_department WHERE CATEGORY = "예체능")
AND NOT EXISTS (SELECT PROFESSOR_NO FROM tb_class_professor WHERE CLASS_NO = c.CLASS_NO)  # IS NULL하면 안됨, 결과같이 1행 이상이기 때문에
;
```

#### 오답이엇던
```
AND (SELECT PROFESSOR_NO FROM tb_class_professor WHERE CLASS_NO = c.CLASS_NO) is null
 = 0
```
클래스번호가 같을 경우의 결과같은 한개 이상이기 때문에 is null을 사용할 수 없다. count도 group으로 묶지 않았기 때문에 사용할 수 없다.



### 풀이 2  left조인 + IS NULL

```sql
SELECT
	CLASS_NAME
    ,(SELECT DEPARTMENT_NAME FROM tb_department WHERE DEPARTMENT_NO = c.DEPARTMENT_NO) AS department_name
FROM
	tb_class c
     LEFT JOIN tb_class_professor cp ON cp.CLASS_NO = c.CLASS_NO # null을포함하여 조인
WHERE
	c.DEPARTMENT_NO IN (SELECT DEPARTMENT_NO FROM tb_department WHERE CATEGORY = "예체능")
AND cp.PROFESSOR_NO IS NULL; # 찾아진 교수의 이름이 존재하지 않을 경우(CLASS_NO로 해도 됨)
;
```
위에와 다르게 from문에서 바로 조인해줬다. 여기서 중요한 것은 Null데이터를 같이 남겨 조합하는 left join을 사용했다는 것이다. <mark style="background: #FFF3A3A6;">만약에 LEFT를 남기지 않을 경우는 필요한 null데이터를 모두 스킵해버리기 때문에 where에서 교수가 배정되지 않는 경우를 판별해 낼 수 없다.</mark>
그리고 WHERE절에서 조합의 하나하나를 IS NULL로 처리하여 배절되지 않는 경우를 판별해낸다.


 배치된 교수가 없을 경우를 찾아내는 구문이 NOT EXISTS로 조금 더 직관적인 거 같아서 더 선호하는 쿼리긴 하다.




