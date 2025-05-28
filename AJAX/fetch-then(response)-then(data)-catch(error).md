```js
fetch('비동기url') //비동기 요청 시작
    .then(response => {
		//응답 확인 및 JSON 파싱, 예외 throw
    })  
    .then(data => { 
		//파싱된 데이터로 화면에 동적 HTML 구성
    })  
    .catch(error => {  
        //예외 처리
    });  
```