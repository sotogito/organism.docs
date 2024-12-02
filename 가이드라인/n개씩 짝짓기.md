`List<String> crews` 

#### 2명씩 추가

```java
        // 인덱스를 3씩 증가시키며 그룹화
        for (int i = 0; i < crews.size(); i += 2) {
            List<String> group = new ArrayList<>();

            group.add(crews.get(i));

			//만약 남은게 홀수면 넣지 않음
            if (i + 1 < crews.size()) { 
	            group.add(crews.get(i + 1))
            }

            groupedCrews.add(group);
        }
```

#### 3명씩 추가

```java
        // 인덱스를 3씩 증가시키며 그룹화
        for (int i = 0; i < crews.size(); i += 3) {
            List<String> group = new ArrayList<>();

            // i부터 i + 3까지의 요소를 그룹에 추가 (범위를 넘어가는 경우 처리)
            for (int j = i; j < i + 3 && j < crews.size(); j++) {
                group.add(crews.get(j).getName());
            }

            groupedCrews.add(group);
        }
```
#### 2명씩, 3명 남으면 3명씩
`for (int i = 0; i < crews.size(); i += 2)`
- i가 2개씩 늘어난다.
```java
for (int i = 0; i < crews.size(); i += 2) {    
  
    if (i + 1 == crews.size()) { //만약 1명이 남는다면 = 3명 조합 필요
	    //마지막 리스트 가져와서 나머지 한명 추가
        result.getLast().add(new Crew(missionTypeDto.course(), crews.get(i)));  
        break;    
    }  

	//기본 2명 추가
    crewsToAdd.add(new Crew(missionTypeDto.course(), crews.get(i)));  
    crewsToAdd.add(new Crew(missionTypeDto.course(), crews.get(i + 1)));  
  
    result.add(new PairCrew(crewsToAdd));  
}
```
size = 6
index = 0,1,2,3,4,5
i = 0,2,4