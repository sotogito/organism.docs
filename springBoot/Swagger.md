[gradle](obsidian://open?vault=organism.docs&file=springBoot%2F0.%20%ED%85%9C%ED%94%8C%EB%A6%BF%2FSwagger%20dependencies)

  [조회 링크](http://localhost:8080/swagger-ui/index.html )
`http://localhost:8080/swagger-ui/index.html  `
#### Config
```java
package com.sotogito.rest.section04.swagger.config;  
  
import io.swagger.v3.oas.models.Components;  
import io.swagger.v3.oas.models.OpenAPI;  
import io.swagger.v3.oas.models.info.Info;  
import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.Configuration; 

@Configuration  
public class SwaggerConfig {  
  
    @Bean  
    public OpenAPI openAPI() {  
        return new OpenAPI()  
                .components(new Components())  
                .info(apiInfo());  
    }  
  
    private Info apiInfo() {  
        return new Info()  
                .title("Spring Boot REST API")  
                .description("REST API 기반의 회원서비스")  
                .version("1.0.0");  
    }  
}
```

---
### 어노테이션
-> 클라이언트와 협업하기 위해 필요함. - 백 로직 설명

- `@Hidden` : 컨트롤러에 붙여 해당 컨트롤러를 띄우지 않음
- @Tag(name = "API 목록", description = "회원 관리") : 컨트롤러에 붙여 상세화한다.

- `@Schema(description = "회원 DTO")` : DTO, dto필드에 붙여 조회시 상세화한다.
	- example = "test01" : 예시 데이터를 제시한다.
	-  allowableValues = {"00", "01", "02", "03"} : 필드에 대입 가능한 값을 명시


- <mark style="background: #FFF3A3A6;">@Operation(summary = "회원 목록 조회", description = "회원 목록을 조회하는 기능")</mark> : 메서드에 붙여 상세화한다.
- ApiResponses : API 응답 설명
```JAVA
@ApiResponses(value = {  
        @ApiResponse(  
                responseCode = "200",  
                description = "조회 성공",  
                content = @Content(schema = @Schema(implementation = ResponseMessage.class))  
        ),  
        @ApiResponse(  
                responseCode = "00",  
                description = "조회 실패",  
                content = @Content(schema = @Schema(implementation = ResponseErrorMessage.class))  
        )  
})
```
- @Parameter(name = "userNo", required = true, description = "조회할 회원 번호") : 매개변수로 받을 값을 정의