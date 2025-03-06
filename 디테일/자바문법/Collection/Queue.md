 ### FIFO(First In, First Out, 선입선출)

---

```java
// 큐 생성 (LinkedList 활용)
        Queue<Integer> queue = new LinkedList<>();

        // 요소 추가 (offer)
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        // 큐의 맨 앞 요소 확인 (peek)
        int front = queue.peek(); // 10

        // 요소 제거 (poll)
        int removed = queue.poll(); // 10

        // 큐가 비어있는지 확인 (isEmpty)
        boolean isEmpty = queue.isEmpty(); // false

        // 요소 개수 확인 (size)
        int size = queue.size(); // 2
```
| 메서드 | 설명 |
| --- | --- |
| `offer(value)` | 큐에 요소 추가 (성공하면 `true`, 실패하면 `false` 반환) |
| `poll()` | 큐의 맨 앞 요소를 제거하고 반환 (비어있으면 `null` 반환) |
| `peek()` | 큐의 맨 앞 요소를 확인 (제거하지 않음, 비어있으면 `null` 반환) |
| `isEmpty()` | 큐가 비어 있는지 확인 |
| `size()` | 큐의 크기(요소 개수) 반환 |
