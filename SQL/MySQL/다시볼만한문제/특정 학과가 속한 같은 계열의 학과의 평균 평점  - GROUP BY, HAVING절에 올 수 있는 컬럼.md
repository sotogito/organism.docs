```
-- 19. 춘 기술대학교의 "환경조경학과"가 속한 같은 계열 학과들의 학과 별 전공과목 평점을 파악하기 위한 적절한 SQL 문을 찾아내시오.
--     단, 출력헤더는 "계열 학과명", "전공평점"으로 표시되도록 하고, 평점은 소수점 한 자리까지만 반올림하여 표시되도록 한다.
/*
    계열 학과명      | 전공평점
    ----------------------------
    간호학과	     | 3.2
    물리학과	     | 3.3
    생명공학원	     | 3.2
    생물학과	     | 3.4
    생태시스템공학과 | 3.5
        ...
    화학과	         | 3.1
    환경응용과학과	 | 3.6
    환경조경학과	 | 3.3
    ----------------------------
    
    20개의 행 조회
*/
```

처음에는 환경조경학과 카테고리의 분류를 having절에 넣어 처리하려고 했다.  
그 이유는 group by로 추려진 데이터도 어차피 tb_department테이블일테고 그 컬럼에 CATEGORY 컬럼이 존재할 테니 분류가 가능할거라고 생각했다.  

  
<mark style="background: #CACFD9A6;">  Error Code: 1064. You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'having  d.CATEGORY = (select CATEGORY from tb_department where DEPARTMENT_NAME =' at line 14</mark>

근데!!!!!  
아니다
외? 

GROUP BY 절에 명시되지 않은 컬럼은 조합을 만들 떄 사용되지 않는다. 그니까 그 원본의 테이ㅂ블 tb_department을 그룹바이에 맞게 분류하는게 아니라 완전히 <mark style="background: #FFF3A3A6;">새로운 조합을 생성</mark>한다는 것이다.    

그래서 카테고리 컬럼을 having절에서 사용하지 못했던 것이다.  
왜?  
select(집계)와 group by에 언급되지 않은 컬럼이니까


#### having절에는 무슨 컬럼을 사요ㅕㅇ해야지
- SELECT절에 언급된 컬럼
- GROUP BY에 언급된 컬럼




### 풀이
```sql
select
	d.DEPARTMENT_NAME
    ,format(avg(POINT),1)
from
	tb_department d
		join tb_student s on s.DEPARTMENT_NO = d.DEPARTMENT_NO
        join tb_grade g on g.STUDENT_NO = s.STUDENT_NO
where
 	d.CATEGORY = (select CATEGORY from tb_department where DEPARTMENT_NAME = "환경조경학과")
group by
	d.DEPARTMENT_NAME
order by
	d.DEPARTMENT_NAME
;
```
그래서 where절에서 하나하나 걸러내줬다.

#### having이 사용한 경우 추가 예시 코드
```sql
select
	d.DEPARTMENT_NAME
    ,avg(POINT)
    ,d.CATEGORY
from
	tb_department d
		join tb_student s on s.DEPARTMENT_NO = d.DEPARTMENT_NO
        join tb_grade g on g.STUDENT_NO = s.STUDENT_NO
-- where
-- 	d.CATEGORY = (select CATEGORY from tb_department where DEPARTMENT_NAME = "환경조경학과")
group by
	d.DEPARTMENT_NAME , d.CATEGORY # 집계함수를 사용하지 않고 select에 언급된 컬럼은 그룹바이로 묶어주는 것이 좋ㄷ하
 having
 	 d.CATEGORY = (select CATEGORY from tb_department where DEPARTMENT_NAME = "환경조경학과")
;
```
위에와 다른걸 말해보면
1. SELECT 절에 카테고리가 포함되었다.
2. GROUP BY 절에 카테고리를 추가하였다.
3. HAVING 절에 카테고리를 사용하여 그룹바이로 생성한 조합테이블을 최종적으로 분류해줬다.  


만약 GROUP BY절에 카테고리를 포함하지 않으면 어떻게 됧까  
<mark style="background: #CACFD9A6;">Error Code: 1055. Expression #3 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'chundb.d.CATEGORY' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by  </mark>

이런 오류가 난다. 뜻을 해석하자면 mysqL이 select절에 있는 카테고리 컬럼을 처리할 때 모호함이 발생한다는 것이다. 분명 코드에서는 이름대로 출력한다고 그룹바이에 명시했는데 엉뚱한 컬럼도 같이 출력한다고 하니 마이에스큐앨이 당황한겅다 그래서 max나 sum 같은 집계함수로 어떻게 처리할지 명확하게 표기하거나 그룹바이에 추가해주어야 한다.

