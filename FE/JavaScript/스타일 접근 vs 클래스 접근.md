#### 스타일
- 말그대로 스타잃 요소를 변경할 때 (textContent같은건 아님)
- 단일 요소로 간단히 변경할 때
- 상태 변경이 1회성으로 발생하고, 변경된 스타일이 즉시 적용되어야 할 때
#### 클래스
- 묶음의 변경 단위로 반복적으로 적용해야될 때
- 상태에 따라 스타일을 제어해야할 때
- 재사용, 일관성이 유지되어야할 때

---

요소를 변경하는데에는 두가지가 있다.  
스타일로 접근하여 바로 변경하는 경우와
```javascript
    function displaySearchBox(radio) {
      // 현재 선택된 카테고리의 검색 박스만 보여지게 처리하시오.
      Array.from(document.getElementsByClassName('search-boxes'))
                         .forEach(box => box.style.display = 'none';
      
      document.getElementById(`${radio.id}-search`).style.display = 'block';
    }
```
클래스를 부여 혹은 삭제하는 경우
```javascript
    function displaySearchBox(radio) {
      Array.from(document.getElementsByClassName('search-boxes'))
                         .forEach(box => box.classList.remove('show'));
      
      document.getElementById(`${radio.id}-search`).classList.add('show');
    }
```
