```java
public List<Product> read(String path) throws IOException {  
    BufferedReader br = new BufferedReader(new FileReader(path));  

	List<Product> products = new ArrayList<>(); //데이터 저장 리스트

	String line;()  
	br.readLine(); //첫번째 헤더라인 건너뛰기 
	while ((line = br.()readLine()) != null) {  
  
	    String[] splitLine = line.split(OrderInputForm.ORDER_DELIMITER.get());  
  
	    String name = splitLine[0];  
	    int price = Integer.parseInt(splitLine[1]);  
	    int quantity = Integer.parseInt(splitLine[2]);  
  
	    Product product = new Product(name,proce,quantity);
	    products.add(product);  
  
	}
}
```
- try-catch로 IOException는 Reader에서 바로 잡아주는 게 좋다.

```java
public class ConvenienceStoreroom implements OrderProductFinder {
    private final Products products;
    private final Promotions promotions;


    public ConvenienceStoreroom(
    PromotionReader promotionReader, ProductReader productReader) throws IOException {

        this.promotions = new Promotions(promotionReader.read(ResourcePath.PROMOTION.get()));
        this.products = new Products(productReader.read(ResourcePath.PRODUCT.get(), promotions));
        this.stockManager = new StockManager();
    
    }
```

- 데이터를 읽어야하는 객체를 모아두고 레퍼지토리를 생성한다.
