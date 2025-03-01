추가하고 삭제하기 좋다
LinkedList는 중간에 데이터를 뺀다고 해도 다른 데이터들이 영향을 받지 않는다. 왜냐면 각자의 고유한 노드를 자기고 있기 때문이다.

```java
void addFirst(Object obj)
LinkedList의 맨 앞에 객체(obj)를 추가


void addLast(Objec obj)
LinkedList의 맨 뒤에 객체(obj)를 추가


boolean add(Object obj)
LinkedList의 마지막에 객체를 추가한다. (성공하면 true)


void add(int index, Object element)
지정된 위치(index)에 객체를 저장한다.


void addAll(Collection c)
주어진 컬렉션의 모든 객체를 저장한다. (마지막에 추가)


void addAll(int index, Collection c)
지정한 위치부터 주어진 컬렉션의 데이터를 저장한다.
```