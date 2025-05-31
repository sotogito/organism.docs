```js
function App() {
	document
		.querySelector("#espresso-menu-form")
		.addEventListener("submit", (e) => {
		e.preventDefault();
	});

	document
		.querySelector("#espresso-menu-name")
		.addEventListener("keypress", (e) => {
			if(e.key === "Enter") {
				console.log(document.querySelector("#esspresso-menu-name").value);
			}
		});
}
```

```js
const $ = (selector) => document.querySelector(selector);

function App() {
	$("#espresso-menu-form").addEventListener("submit", (e) => {
		e.preventDefault();
	})
}
```

- 매번 사용하는` document.querySelector` 를 유틸 함수로 빼어 $로 대신 사용한다.
- jQuery 없이 순수 JS로 개발할 때, `$`를 직접 만들어서 쓰는 건 자주 있는 방식이고 전통적인 방식이다.