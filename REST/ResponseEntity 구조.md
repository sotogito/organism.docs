```
HTTP/1.1 200 OK
Content-Type: application/json
X-Custom-Header: example-value
...

{
  "key1": "value1",
  "key2": "value2"
}
```


```java
@GetMapping("/weather")
public ResponseEntity<WeatherResponse> getWeather() {
    WeatherResponse response = new WeatherResponse("맑음", 27);

    return ResponseEntity
        .status(HttpStatus.OK)                          // 상태코드
        .header("X-Custom-Header", "example-value")     // 커스텀 헤더
        .header(HttpHeaders.CACHE_CONTROL, "no-cache")  // 표준 헤더도 가능
        .body(response);                                // 응답 바디
}
```
