```xml
<?xml version="1.0" encoding="UTF-8" ?>  
<configuration>  

  <!--콘솔에 로그를 출력해주는 Appender-->  
  <appender class="ch.qos.logback.core.ConsoleAppender" name="consoleLog">  
    <encoder>      <pattern>%-5level: [%date{yyyy-MM-dd HH:mm:ss}] [%logger:%line] - %msg%n</pattern>  
    </encoder>  </appender>  


  <!--파일에 로그 출력-->  
  <appender class="ch.qos.logback.core.FileAppender" name="fileLog">  
    <file>/logs/webmvc.log</file> <!--<file>/Users/사용자이름/logs/webmvc.log</file>--> <!--맥북의 경우-->  
    <append>true</append>  
    <immediateFlush>true</immediateFlush>  
    <encoder>      <pattern>%-5level: [%date{yyyy-MM-dd HH:mm:ss}] [%logger:%line] - %msg%n</pattern>  
    </encoder>  
  </appender>  


  <!--특정 조건 후에 기존의 파일을 백업파일로 바꾸고 새파일에서 로깅처리되게끔 Appender-->  
  <appender class="ch.qos.logback.core.rolling.RollingFileAppender" name="rollingFileLog">  
    <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">  
      <fileNamePattern>/logs/webmvc-%d{yyyy-MM-dd}.%i.log</fileNamePattern>  
      <maxFileSize>10MB</maxFileSize>     <!--최대 하나의 파일 용량, 넘어가면 새로 생성 -->  
      <maxHistory>30</maxHistory>         <!--파일 보관일-->  
      <totalSizeCap>100GB</totalSizeCap>  <!--로그파일 전체가 해당 용량을 넘어가면 오래된 순서대로 삭제됨-->  
    </rollingPolicy>  
    <encoder>      
      <pattern>%-5level: [%date{yyyy-MM-dd HH:mm:ss}] [%logger:%line] - %msg%n</pattern>  
    </encoder>  
  </appender>  


  <!--패키지를 지정하여 출력될 로깅 레벨 구체화 가능-->  
  <logger name="org.springframework" level="INFO"/>  
  <logger name="com.sotogito.webmvc" level="DEBUG"/>  


  <!--appender 반영-->  
  <!--보편 기준 로그 태그 (해당 로그 이상만 남겨짐)-->  
  <root level="WARN">  
    <appender-ref ref="consoleLog"/>  
    <appender-ref ref="fileLog"/>  
    <appender-ref ref="rollingFileLog"/>  
  </root>  
</configuration>
```

#### \<appender\>  
1) 전달된 로그를 어디에 출력할지 결정하는 역할 (콘솔, 파일, db 등)  
2) 참고 : https://logback.qos.ch/manual/appenders.html  
3) 주요 종류  
    → ConsoleAppender     : 로그를 콘솔에 출력  
    → JDBCAppender        : 로그를 RDB에 출력  
    → FileAppender        : 로그를 파일에 출력 (단, 지정한 파일에 로그가 계속 쌓이기 때문에 크기가 지나치게 커질 수 있고 지속적인 로그관리 불가능해짐)  
    → RollingFileAppender : FileAppender를 보완한 개념  
                            ex) DailyRollingFileAppender : 일정한 조건 후에 기존파일을 백업파일로 바꾸고 다시 처음부터 로깅 시작  
  
#### \<encoder\>, \<pattern\>  
1) 로그를 어떤 포맷으로 출력할껀지 출력패턴을 결정하는 역할  
2) 참고 : https://logback.qos.ch/manual/layouts.html#ClassicPatternLayout  
3) 주요 패턴  
    → %logger{n}  : 로거주체 (로그가 찍히는 클래스)  => %logger{0} 으로 하면 클래스명만 출력  
    → %line       : 로거 발생 라인  
    → %date       : yyyy-MM-dd HH:mm:ss.SSS 형식으로  
    → %date{포맷} : 포맷반영한 날짜 (포맷에 ,를 포함시키려면 따옴표로 포맷을 묶어야됨)  
    → %level      : 로그레벨  
    → %msg        : 로그 메세지  
  
#### \<root\>  
1) 현재 애플리케이션의 "모든 패키지안"의 특정 레벨 이상의 로그를 특정 appender에 적용시켜 출력  
2) 작성방법  
```
<root level="로그레벨(해당레벨이상의 로그만이 출력됨)">  
    <appender-ref ref="로그를 출력시킬 appender"/>  
</root>
```
#### \<logger\>
1) "특정 패키지안"의 특정 레벨 이상 로그를 특정 appender에 적용시켜 출력  
2) 작성방법  
3) 작성방법  
```
<logger name="특정패키지" level="로그레벨" [additivity="root logger로 전달여부(기본값 true)"]>  
     [<appender-ref ref="로그를 출력시킬 appender" />]  
</logger>
```
** 기본적으로 logger가 먼저 반영되고 root logger가 반영됨