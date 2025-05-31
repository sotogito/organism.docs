아래 코드의 목적은 메뉴요소가 추가될 때마다 html 태그를 추가한다.
```js
const store = {
	setLocalStorage(menu) {
		localStorage.setItem("menu", JSON.stringify(menu));
	},
	getLocalStorage() {
		return JSON.parse(localStorage.getItem("menu"));
	}
}
```

```js
this.menu = []; //데이터를 담는곳 곳(localStorage 아님)
```

#### 메뉴 추가 기능
```js
const addMenuName = () => {
	const espressoMenuName = $("#espresso-menu-name").value;
	this.menu.push({ name: espressoMenuName }); // { name: "아메리카노" } 객체 추가
	store.setLocalStorage(this.menu);
	
	const template = this.menu.map((item, index) => { //화면 출력을 위함
		return `<li>~~~~</li>`;
	}).join("");
	화면에띄울곳.innerHTML = template;
}
```
여기서 특징은 메뉴를 추가할때마다 다시 li태그를 다 불러와서 join한다는 것이다.
왜냐면. 화면에 추가시켜줘야하기 떄문이다.


즉
1. 메뉴 추가
2. 이름-메뉴명 으로 menu 배열에 추가
3. menu배열을 localstoarge값으로 설정
4. 화면에 출력하기 위해서 menu의 요소를 for문을 통해 하나하나 html의 형태로 만들고 그 결과를 join하여 합침
5. 출력  


근ㄴ데 여기서 드는 궁금증은 굳이 menu가 필요할까? 이다 그냥 LocalStorage 에서 읽어와서 처리하면 되는거 아닐까?  
-> 아니다  
1. localStorage는 문자열 저장소이다.  
즉, js에서 바로 읽어서 사용하지 못한다. 그래서 저장하는 코드를 보면 `JSON.stringify()`으로 저장한다. 당여닣 읽어올때도 `JSON.parse()`를 해줘야한다는 말이다.
2. 로컬스토리지는 느리고 동기처리이다.  
localStorage는 브라우저의 디스크에 저장돼 있어서 접근 속도가 매우 느리다. 그리고 동기처리이기 때문에 호출중에 화면이 랜더링 되어 깜빡 거리거나 멈출 수 있다.  

즉. 화면에 출력하기 위한 배열이 따로 존재해야 관리가 편하다.

#### 메뉴 삭제
```js
const removeMenuName = (e) => {
	if(confirm("정말 삭제하시겠습니까?")) {
		const menuId = e.target.closest("li").dataset.menuId;
		this.menu.splice(menuId,1); //menu 배열에서 1개 삭제
		store.setLocalStorage(this.menu);//localstorage 업데이트
		e.target.closest("li").remove();
	}
}
```

배열에 데이터를 삭제하고 삭제된 배열을 LocalStorage로 업데이트한다.

