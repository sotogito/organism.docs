```
implementation 'org.springframework:spring-context:6.1.6'
```

---
- spring
- jsp
- jdbc
- mybatis
```
// 위에 일부 생략 

tasks.withType(JavaCompile) {
    options.encoding = 'UTF-8'
    options.compilerArgs << "-parameters"
}

dependencies {
    // spring 라이브러리
    implementation 'org.springframework:spring-context:6.1.6'
    implementation 'org.springframework:spring-webmvc:6.1.6'
    implementation 'org.springframework:spring-jdbc:6.1.6'
    
    // aop 관련 라이브러리
    implementation 'org.aspectj:aspectjrt:1.9.19'
    implementation 'org.aspectj:aspectjweaver:1.9.19'

    // servlet/jsp 라이브러리
    compileOnly('jakarta.servlet:jakarta.servlet-api:6.0.0')
    implementation 'jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:3.0.0'
    implementation 'org.glassfish.web:jakarta.servlet.jsp.jstl:3.0.1'
    
    // db/mybatis 라이브러리
    implementation 'com.mysql:mysql-connector-j:8.0.33' 
    implementation 'org.mybatis:mybatis:3.5.16'         
    implementation 'com.zaxxer:HikariCP:6.3.0'          
    implementation 'org.mybatis:mybatis-spring:3.0.3'   

    // 기타 라이브러리
    compileOnly 'org.projectlombok:lombok:1.18.24'
    annotationProcessor 'org.projectlombok:lombok:1.18.24'
    implementation 'com.fasterxml.jackson.core:jackson-databind:2.17.2'

    // logging 라이브러리
    implementation 'ch.qos.logback:logback-classic:1.4.14'
    implementation 'ch.qos.logback:logback-core:1.4.14'
    
    // test 라이브러리
    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")

}
```
