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
