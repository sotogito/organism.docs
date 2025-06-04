2차 프로젝트에 모든 html : js를 1:1로 작성하였다. 이게 맞나 싶어 분리하고 싶었지만 코드를 저금이라도 건들면 동작이 이상해졌다.
가장 큰 의문은 도대체 `window.addEventListener("DOMContentLoaded", () => {` 내부에 왜 작성해야하냐?1 인데 공부해보니까 사실 내 코드에서는 필요 없는 방법이였다.

일단 
#### DOM(Document Object Model)이란?
- 브라우저가 HTML을 읽고 해석하면서 만든 **웹페이지 구조의 트리(Tree)**
- `<div>`, `<button>`, `<input>` 같은 태그가 **자바스크립트로 조작 가능한 객체**로 바뀜

#### 그럼 window.addEventListener("DOMContentLoaded", () => {는?
- 이 이벤트는 **"자바스크립트가 HTML 요소들을 안전하게 조작할 수 있게 되었을 때"** 실행이 된다는 뜻이다.

그래서 저 이벤트를 쓰냐 마냐는 js를 선언한 script문이 어디에있냐에 따라서 정해진다.  
`<script src="${contextPath}/resources/js/pages/sales/salesList.js"></script>`  

html도 순차적으로 코드가 실행이 될텐데,
- head태그나, 구현 html 위에 선언되었을 경우 -> 이벤트 써야됨

하지만 만약
- body태그 아래에 선언되어있을 경우 -> 안써도 됨  
만약 JS 파일이 `<body>` **맨 아래**에 있으면 DOM이 이미 만들어진 상태니까, 굳이 `DOMContentLoaded`를 안 써도 무방하다.


하지만 가장 메인이 되는 페이지에는 작성하는게 좋다.
예를들어 조회 페이지에서
1. 날짜 버튼 클릭 이벤트 - export function() 
2. 상태 체크박스 처리 이벤트  - export function() 
3. 모달띄우기 이벤트  - export function() 
가 있으면 그 페이지.js파일에서는 DOM이벤트를 사용하여 준비가 되어야하는 순서대로 언급해놓는것이다.

