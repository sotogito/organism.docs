js에서 생성한 HTML 엘리먼트를 추가하는데, 위치를 지정하여 누적 추가할 수 있음

```js
<!-- beforebegin -->
<p>
  <!-- afterbegin -->
  foo
  <!-- beforeend -->
</p>
<!-- afterend -->
```
- [`"beforebegin"`](https://developer.mozilla.org/ko/docs/Web/API/Element/insertAdjacentHTML#beforebegin)
요소 이전에 위치합니다. 오직 요소가 DOM 트리에 있고 부모 요소를 가지고 있을 때만 유효합니다.
- [`"afterbegin"`](https://developer.mozilla.org/ko/docs/Web/API/Element/insertAdjacentHTML#afterbegin)
요소 바로 안에서 처음 자식 이전에 위치합니다.
- [`"beforeend"`](https://developer.mozilla.org/ko/docs/Web/API/Element/insertAdjacentHTML#beforeend)
요소 바로 안에서 마지막 자식 이후에 위치합니다.
- [`"afterend"`](https://developer.mozilla.org/ko/docs/Web/API/Element/insertAdjacentHTML#afterend)
요소 이후에 위치합니다. 오직 요소가 DOM 트리에 있고 부모 요소를 가지고 있을 때만 유효합니다.
