### connection-config.properties
```properties
driver=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost/empdb
user=sotogito
password=sotogito
```

### JDBCTemplate + static 메서드;
```java
public class JDBCTemplate {
    public static Connection getConnection() {

        Properties prop = new Properties();
        Connection conn = null;

        try {
            prop.load(new FileReader("src/main/java/com/sotogito/config/connection-config.properties"));

            Class.forName(prop.getProperty("driver"));
            conn = DriverManager.getConnection(prop.getProperty("url")
                                             , prop.getProperty("user")
                                             , prop.getProperty("password"));

        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        return conn;
    }

    public static void close(Connection conn) {
        try {
            if(conn != null && !conn.isClosed()) conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
```

### 호출
```java
public class Application {
    public static void main(String[] args) {
        Connection conn = JDBCTemplate.getConnection();

        ///  --sql문 실행 완료
        
        JDBCTemplate.close(conn);
    }
}
```

```java
import java.sql.Connection;

import static com.sotogito.section02.template.JDBCTemplate.getConnection;
import static com.sotogito.section02.template.JDBCTemplate.close;

public class Application {
    public static void main(String[] args) {
        Connection conn = getConnection();

        ///  --sql문 실행 완료

        close(conn);
    }
}
```
