- resources/config
- my-batis.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-config.dtd">
<!-- Configuration 생성-->
<configuration>

    <environments default="dev"> <!--environment들에서 기본으로 사용할 id-->
        <!-- Environment 생성-->
        <environment id="dev">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/menudb"/>
                <property name="username" value="sotogito"/>
                <property name="password" value="sotogito"/>
            </dataSource>
        </environment>
    </environments>

</configuration>
```
