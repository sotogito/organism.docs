```java
private final static StringBuilder printout = new StringBuilder();  
  
public static void print() {  
    System.out.print(getPrintout());  
}  
  
public static String getPrintout() {  
 
}  
  
private static String getFormattedScorePrintout(Entry<Rank, Integer> entry, Rank rank) {  
    int matchCount = rank.getMatchCount();  
    String formatedPrizedMoney = String.format(PRIZE_MONEY_FORMAT, rank.getPrizeMoney());  
    int matchResult = entry.getValue();  
  
    if (rank.equals(Rank.SECOND)) {  
        return String.format(PRINT_SECOND_RANK_FORMAT, matchCount, formatedPrizedMoney, matchResult);  
    }  
    return String.format(PRINT_RANK_FORMAT, matchCount, formatedPrizedMoney, matchResult);  
}
```