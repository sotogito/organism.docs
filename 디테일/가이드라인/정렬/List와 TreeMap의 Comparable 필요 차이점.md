#### **List**

- 정렬되지 않은 상태로 데이터를 저장.
- **정렬이 필요할 때만 `compareTo`를 호출**하므로, 기본적으로 `Comparable`이 없어도 문제가 없습니다.
- 정렬 시 `Comparator`를 제공하면 `Comparable`이 없어도 동작합니다.

#### **TreeMap**

- 삽입 시마다 정렬 기준이 필요.
- 키가 `Comparable`을 구현하지 않았거나 `Comparator`가 없으면, 삽입 시점을 포함한 모든 연산에서 **`ClassCastException`**이 발생합니다.

- 만약 Integer이나 String을 비교하기 위해서는 정의할 필요 없다.
- 하지만 객체를 담았을 경우 TreeMap는 정의가 필요하다.