#### 동적 코딩 방식
db연결 정보를 외부 파일에 작성하여 자바 내로 읽어들여 반영시키는 방식
- 좋은점
  1. db연경 정보가 변경될 경우 파일만 수정하면 됨
     => 자바 코드를 수정한게 아니므로 프로그램 재구동 시킬 필요 없음
  2. .properties와 같이 "key=value형식으로 일반인도 쉽게 수정 가능

```properties
driver=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost/empdb
user=sotogito
password=sotogito
```

```java
public class Application3 {
    public static void main(String[] args) {

        Properties prop = new Properties();

        Connection conn = null;

        try {
            prop.load(new FileReader("src/main/java/com/sotogito/config/connection-config.properties"));

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);


        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(conn != null && !conn.isClosed()) conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

```
