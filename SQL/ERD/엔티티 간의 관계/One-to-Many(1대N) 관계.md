- 한쪽 엔티티의 1개 레코드에 다른 한쪽 엔티티의 여러 레토드가 대응되는 관계
- 자식테이블(N)쪽에서 부모테이블(1)의 키를 외래키(FK)로 참조한다.
- ex) 사용자<->글 / 글 <-> 댓글

#### 부모(Parent)테이블
- 1에 해당되는 쪽
### 자식(Child) 테이블
- N에 해당되는 쪽
- 부모테이블의 key(보통 PK)를 외래키로 참조한다.

#### 외래 키 ForeignKey
- 자식 테이블에 부모 테이블의 PK를 저장하여 누구에 속하는 지를 나타낸다.
- 참조 무결성을 유지하고 1대N 관계가 성립하도록 유지한다.

---
```
+--------------+         +-------------+
|     USER     |         |    POST     |
+--------------+         +-------------+
| PK: user_id  |         | PK: post_id |
| username     |         | title       |
| email        |         | content     |
| ...          |         | created_at  |
+--------------+         | FK: user_id → USER(user_id)
	    1    ----------------   N

```