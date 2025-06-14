N+1문제란 연관관계 때문에 쿼리가 N번 더 조회되는 현상을 말한다.  
예를들어  아래를 Member 객체로 해보겠다.

```java
@ManyToOne(fetch = FetchType.LAZY)  
@JoinColumn(name = "team_id", nullable = false)  
private Team team;
```

만약 맴버들의 팀을 정보를 조회하고 싶으면 다음과 같은 코드가 필요하다.
```java
List<Member> members = memberRepository.findAll(); //------- 1번 접근(Team데이터X)
for (Member m : members) {                         // ---- Member.sizs() 만큼 db 접근
    System.out.println(m.getTeam().getName());
}
```
Member에서 Team을 지연로딩으로 설정해두었기 때문에 memberRepository.findAll(); 에서는 Team의 데이터를 가져오지 않는다.  
바로 Team의 데이터를 필요로하는 그 아래 구분에서 다시한번 db에 접근하게 된다.  
그럼 사실상 레퍼지토리를 사용한 것은 1번이지만 지연로딩으로 인해 Team의 데이터를 가져오기 위해서 Member의 수만큼 db에 접근하게 되는것이다.  

```
SELECT * FROM member; ----------- 1번

SELECT * FROM team WHERE id = ?;  -------- member.size()번
```
### JOIN FETCH
```java
@Query("SELECT m FROM Member m JOIN FETCH m.team")
List<Member> findAllWithTeam();
```
- FETCH JOIN을 사용하여 LAZY로 설정한 모든 연관관계의 데이터를 한번에 가져올 수 있다.
1. LAZY의 제약조건을 유지하여 N+1의 문제를 해결할 수 있다.
	(EAGER로 해도 N+1의 문제는 해결할 수 있지만, 항상 조인이 된다는 치명적인 단점이 있어 잘 사용하지 않는다.)

```
SELECT m.*, t.*
FROM member m
JOIN team t ON m.team_id = t.id;
```

