
```java
public boolean hasSamePairCrewSingly(PairCrew newPairCrew) {  
    for (PairCrew pairCrew : pairCrews) {  
        if (pairCrew.haveSamePairCrewSingly(newPairCrew)) {  
            return true;  
        }  
    }  
    return false;  
}
```


```java
public boolean hasSamePairCrewSingly(PairCrew newPairCrew) {  
    for (PairCrew pairCrew : pairCrews) {  
        return pairCrew.haveSamePairCrewSingly(newPairCrew); 
    }  
    return false;  
}
```

잘못된 코드이다. 만약 같다면 찾고 반환해야하는데, 위의 코드는 첫번째 paireCrew를 haveSamePairCrewSingly으로 확인하자마자 return으로 인해 바로 반환한다.
