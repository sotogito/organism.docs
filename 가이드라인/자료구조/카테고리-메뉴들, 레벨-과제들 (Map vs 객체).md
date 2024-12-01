### `EnumMap<Level,List<String>>`

- <mark style="background: #FFF3A3A6;">Key를 상수로 사용할때(Enum)</mark>
- Key를 기준으로 빠르게 조회가 필요할때
- 키-값 쌍이 동적으로 추가/삭제되어야할때
- 키가 많아지거나, 동적으로 변할 가능성이 있을 때
	
- value의 확장 가능성이 크다면 value를 객체로 생성하는 방법도 있음
		- `EnumMap<Level,List<객체>>`

### List<객체>
- value가 가지는 상태가 많고 명확할때
- 확장이 필요할때
- 조회를 한다기 보다 생성을 할때

---


예를들어 레벨-과제들로 설명해보자면
```
## 레벨
- 레벨1
- 레벨2
- 레벨3
- 레벨4
- 레벨5
```
```
  - 레벨1: 자동차경주 | 로또 | 숫자야구게임
  - 레벨2: 장바구니 | 결제 | 지하철노선도
  - 레벨3: 
  - 레벨4: 성능개선 | 배포
  - 레벨5: 
```

다음과 같이 구현해야한다. 이는 총 4가지 자료구조를 생각해볼 수 있다.  
일단 레벨을 Enum으로 구현한다는 가정이다.

1.  `EnumMap<Level,List<String>>`
2.  `Enum, List<String>`을 가지는 객체 생성 후 List<객체>를 가지를 Repository 생성
3.  `EnumMap<Level,Missions>`
4.  `EnumMap<Level,List<Mission>>`

일단 1 ,4 번을 가장 추천한다.  

#### Map을 사용해야하는 이유
- 조회가 빠르다.
- key-value 로 설계가 단순하다.

객체를 아예 생성해거 관리하는 것도
괜찮은 설계 방법이지만 검색 부분에서 많이 느릴 수 있다.
또한 Key - Value의 관계가 아니라 `creationDate`, `author` 등 더 복잡한 요소가 들어갈때는 객체를 생성하는게 낫다.