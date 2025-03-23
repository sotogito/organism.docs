- 한 엔티티의 여러 레코드가 다른 엔티티의 여러 레코드와 동시에 연결될 수 있는 관계
- 직접 두 테이블을 연결하려면 양쪽 모두 FK를 두어야하는데 이를 효율적으로 처리하기 위해 join table, mapping table과 같은 중간 테이블을 별도로 만들어 1:N + 1:N형태로 쪼개 표현한다.
	- 예를들어 StudentSubject 테이블을 두어 student_id, subject_id를 FK로 갖도로 하여 매핑
- ex) 학생(Student) <-> 과목(Subjects)에서 한 학생이 여러 과목을 수강하고 과목도 여러 학생이 있을 수 있다.
---
```
+--------------+       +---------------------+       +--------------+
|   STUDENT    |       |  STUDENT_SUBJECT   |       |   SUBJECT    |
+--------------+       +---------------------+       +--------------+
| PK: student_id|      | PK: id (optional)  |       | PK: subject_id
| name         |       | FK: student_id ----+-----> | subject_name
| major        |       | FK: subject_id ----+-----> | description
| ...          |       | etc...            |       | ...
+--------------+       +---------------------+       +--------------+
	   1    ------------------    N
                                  N  ----------------------- 1

```