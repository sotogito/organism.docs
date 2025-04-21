### 기본 인덱스
```javascript
for(let i = 0; i<fruits.length; i++) {
   console.log(`인덱스${i}. 요소 ${fruits[i]}`);
};
```
### in for문
- 자바의 향상된 for문과 다른 개념
- 문자열로된 인덱스를 반환함
```javascript
for(let i in fruits){
   console.log(`인덱스${i}. 요소 ${fruits[i]}`);
};
```
i는 차례대로 0,1,2

### of for문
- 자바의 향상된 for문과 흡사
```javascript
for(let city of cities){
   console.log(city);
}
```
