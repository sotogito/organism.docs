원래는 가장 높은 평균 평점을 구하고 그것에 맞는 학생을 뽑아내려고 했다.  
근데 이 경우에는  
[지금 학생의 평균 평점.] = [가장 높은 평균 평점]을 where절에서 계속 해줘야한다.,  
즉 계산을 계속 해줘야한다는 소리다. 가독성은 물론이고 비효율적일거라고 생각했다. 

### 풀이
```sql
select
	s.STUDENT_NO
    ,s.STUDENT_NAME
from
	tb_student s
		join tb_department d on d.DEPARTMENT_NO = s.DEPARTMENT_NO
        join tb_grade g on g.STUDENT_NO = s.STUDENT_NO
where
	d.DEPARTMENT_NAME = "국어국문학과"
group by
	s.STUDENT_NO, s.STUDENT_NAME # 비집계 컬럼은 모두 order by에 넣어 짝을 이룬다.
order by
	avg(g.POINT) desc
limit
	1
;
```
1. 학생들, 학과들, 점수들이 저장되어있는 테이블을 조인한다.
2. 그 중 국어국문학과인 조합만 남겨둔다.
3. 학생의 번호, 이름을 기준으로그룹필하여 하나하나 개별적으로 분리한다.
4. 묶인 조합에서 학생의 평균평점을 구하여 내림차순한다.
5. 그 중 첫번째의 값만 선별한다 = 최고점수

#### 아까 위에서 생각한대로 코드를 작성하면?
```sql
SELECT
    s.STUDENT_NO,
    s.STUDENT_NAME
FROM tb_student s
WHERE
    -- 이 학생의 평균점수
    (
        SELECT AVG(g.POINT)
        FROM tb_grade g
        WHERE g.STUDENT_NO = s.STUDENT_NO
    )
    =
    -- 전체 학생 중 최고 평균점수
    (
        SELECT MAX(sub.avg_p)
        FROM (
            SELECT STUDENT_NO, AVG(POINT) AS avg_p
            FROM tb_grade
            GROUP BY STUDENT_NO
        ) AS sub
    );
    
```

이렇게 된다. 싫다


---
#### 추가 오답
```sql
select
	s.STUDENT_NO
    ,s.STUDENT_NAME
from
	tb_student s
        join tb_grade g on g.STUDENT_NO = s.STUDENT_NO
group by
	s.DEPARTMENT_NO
having
	s.DEPARTMENT_NO = (select DEPARTMENT_NO from tb_department where DEPARTMENT_NAME = "국어국문학과")
order by
	avg(g.POINT) desc
limit
	1
;
```
일단 학과별로 분리한 다음에 국어국문학과인 학과의 테이블만 남겨두고 거기서 최고 평점의 학생을 출력하려고 했는데 생각해보니 위와같이 작성하면 <mark style="background: #ABF7F7A6;">해당 학과에 속한 모든 학생의 행이 한 그룹으로 합쳐</mark>진다. 그래서 학생의 학번과 이름을 출력할 수 없다.