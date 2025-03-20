```xml
<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE properties SYSTEM "http://java.sun.com/dtd/properties.dtd">
<properties>
    
    <!-- 성으로 직원 조회용 쿼리-->
    <entry key="selectEmpByFamilyName">
        SELECT
            *
        FROM
            employee
        WHERE
            emp_name LIKE ?
    </entry>

</properties>
```

```java
Properties prop = new Properties();
try {
    prop.loadFromXML(new FileInputStream("src/main/java/com/sotogito/mapper/employee-query.xml"));
} catch (IOException e) {
    throw new RuntimeException(e);
}

String query = prop.getProperty("selectEmpByFamilyName");

```
