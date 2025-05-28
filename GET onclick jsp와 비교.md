#### jsp
```java
<tbody>   
<c:forEach var="board" items="${boardList}">  
  <tr onclick="location.href='${contextPath}/board/detail.page?no=${board.boardNo}';">  
    <td>${board.boardNo}</td>  
    <td>${board.boardTitle}</td>  
    <td>${board.boardWriter}</td>  
    <td>${board.readCount}</td>  
    <td>${board.registDate}</td>  
    <td>${board.attachCount == 0 ? '' : '★'}</td>  
  </tr></c:forEach>  
</tbody>
```

#### Thymeleaf
```java
<tbody>  
  <th:block th:each="board:${boards}"  
            th:object="${board}">  
    <tr th:onclick="|location.href='@{/board/detail.page(no=*{boardNo})}';|">  
      <td th:text="*{boardNo}"></td>  
      <td th:text="*{boardTitle}"></td>  
      <td th:text="*{boardWriter}"></td>  
      <td th:text="*{readCount}"></td>  
      <td th:text="*{registDate}"></td>  
      <td th:text="*{attachCount} != 0 ? '있다' : '없다'"></td>  
    </tr>  </th:block>  
</tbody>
```