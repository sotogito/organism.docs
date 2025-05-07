```
tasks.withType(JavaCompile) {  
    options.encoding = 'UTF-8'  
    options.compilerArgs << "-parameters"  
}
```

- options.compilerArgs << "-parameters"   : 인텔리제이에서 컴파일 시 파라미터명이 보존되도록 설정