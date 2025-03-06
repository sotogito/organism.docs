### LIFO(Last In, First Out, 후입선출)


---

```java
        // 스택 생성
        Stack<Integer> stack = new Stack<>();

        // 요소 추가 (push)
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        // 스택의 맨 위 요소 확인 (peek)
        int top = stack.peek(); // 30

        // 요소 제거 (pop)
        int popped = stack.pop(); // 30

        // 스택이 비어있는지 확인 (isEmpty)
        boolean isEmpty = stack.isEmpty(); // false

        // 요소 개수 확인 (size)
        int size = stack.size(); // 2

        // 스택에서 특정 요소 찾기 (search)
        int position = stack.search(10); // 1 (위에서부터의 위치)
```
| 메서드 | 설명 |
| --- | --- |
| `push(value)` | 스택에 요소 추가 |
| `pop()` | 스택의 맨 위 요소를 제거하고 반환 |
| `peek()` | 스택의 맨 위 요소를 확인 (제거하지 않음) |
| `isEmpty()` | 스택이 비어 있는지 확인 |
| `size()` | 스택의 크기(요소 개수) 반환 |
| `search(value)` | 해당 값이 몇 번째 위치에 있는지 반환 (없으면 `-1`) |
