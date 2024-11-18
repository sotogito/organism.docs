- `matches(정규식)` : 정규식으로 이루어져 있는지 확인
- `replaceAll(정규식, 대체 문자 또는 문자열)` : 정규식일 경우 해당 대체자로 변경
	- replace()도 같은 역할을 하지만, 정규식을 지원하지 않음
- `String[] = split(정규식)` : 정규식을 기준으로 분할
	```java
	String txt3 = "power987*-;";
	String[] txts = txt3.split("[0-9]+"); // 숫자부분을 기준으로 분할
	System.out.println(txts[0]); // power
	System.out.println(txts[1]); // *-;
	```
	숫자는 분리된 배열에 포함되지 않음
