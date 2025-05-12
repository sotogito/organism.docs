```
implementation 'org.springframework:spring-context:6.1.6'
```

---
- spring
- jsp
- jdbc
- mybatis
```
dependencies {  
    implementation 'org.springframework:spring-context:6.1.6'  
    implementation 'org.springframework:spring-webmvc:6.1.6'  
    implementation 'org.springframework:spring-jdbc:6.1.6'
  
    compileOnly('jakarta.servlet:jakarta.servlet-api:6.0.0')  
    implementation 'jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:3.0.0'  
    implementation 'org.glassfish.web:jakarta.servlet.jsp.jstl:3.0.1'  
  
    compileOnly 'org.projectlombok:lombok:1.18.24'  
    annotationProcessor 'org.projectlombok:lombok:1.18.24'
    
    implementation 'com.mysql:mysql-connector-j:8.0.33'  
	implementation 'org.mybatis:mybatis:3.5.16'
	implementation 'com.zaxxer:HikariCP:6.3.0'
	implementation 'org.mybatis:mybatis-spring:3.0.3'

    implementation 'ch.qos.logback:logback-classic:1.4.14'
    implementation 'ch.qos.logback:logback-core:1.4.14'
  
    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")  
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")  
}
```
