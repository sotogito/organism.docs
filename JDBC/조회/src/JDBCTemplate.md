```java
public class JDBCTemplate {

    public static Connection getConnection() {

        Properties prop = new Properties();
        Connection conn = null;

        try{
            prop.load(new FileReader("src/main/java/com/sotogito/config/connection-config.properties"));

            Class.forName(prop.getProperty("driver"));
            conn = DriverManager.getConnection(prop.getProperty("url")
                                              ,prop.getProperty("user")
                                              ,prop.getProperty("password"));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return conn;
    }

  
    public static void close(Connection conn) {
        try{
            if(conn != null || !conn.isClosed()) conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rset) {
        try{
            if(rset != null || !rset.isClosed()) rset.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Statement stmt) {
        try{
            if (stmt != null || !stmt.isClosed()) stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
  
}
```
