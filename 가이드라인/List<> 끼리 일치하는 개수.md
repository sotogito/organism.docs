```java
    public int getMatchedCount(final Lotto randomLotto) {
        int result = 0;

        for (Integer userLottoNumber : numbers) {
            if (randomLotto.numbers.contains(userLottoNumber)) {
                result += 1;
            }
        }
        return result;
    }
```