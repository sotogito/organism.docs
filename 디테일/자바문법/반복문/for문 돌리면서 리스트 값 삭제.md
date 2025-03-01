인덱스 for문이나 향상된 for문이나 for문을 돌리는 도중에 값을 삭제하면 예외가 발생한다.

.`ConcurrentModificationException`

- _**removeIf 삭제 -추천**_

```java
Boolean isRemove = musics.removeIf(music -> music.getTitle().equals(title)); 
```


- 만약 for문을 돌리면서 삭제를 하면 ConcurrentModificationException 예외가 난다.
```java
for(Book book : bookList) { 
		if(book.getTitle().contains(title) && book.getAuthor().contains(author)) { 
			bookList.remove(book); 
	} 
}
```


- 삭제 대상을 삭제한 뒤 바로 break로 나가버리면 예외는 던져지지 않지만 단 1개만 지울 수 있다.
```java
for(Book book : bookList) { 
	if(book.getTitle().contains(title)) { 
		bookList.remove(book); 
			break; 
		} 
}
```


- 인덱스 for문은 인덱스 밀림 현상을 조심해야한다.
예를들어 i가 0일때 0번째 인덱스가 삭제될 경우 1번째에 있큰 값이 0에 자리로 당겨진다. 
i가 1로 ++ 되면 결국은 당겨진 값은 확인되지 않고 넘어가게된다.
```java
for(int i =0; i<bookList.size(); i++){ 
	if(bookList.get(i).getTitle().equals(title)){ 
		//bookList.remove(i); 
		bookList.remove(bookList.get(i)); 
	} 
}
```

- 그래서 인덱스를 뒤에서부터 삭제하면 밀림 현상을 막을 수 있다.
```java
for(int i = bookList.size()-1; i>=0; i--){ 
	if(bookList.get(i).getTitle().equals(title)){ 
		bookList.remove(i); 
	} 
}
```