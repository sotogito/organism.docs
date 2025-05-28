```java
import org.springframework.stereotype.Component;  
  
import java.util.HashMap;  
import java.util.Map;  
  
@Component  
public class PageUtil {  
  
public Map<String, Object> getPageInfo(int totalCount, int page, int display, int pagePerBlock){  
        int totalPage = (int)Math.ceil((double)totalCount / display);  
        int beginPage = (page - 1) / pagePerBlock * pagePerBlock + 1;  
        int endPage = Math.min(beginPage + pagePerBlock - 1, totalPage);  
        int offset = (page - 1) * display;  
  
        Map<String, Object> map = new HashMap<>();  
        map.put("totalCount", totalCount);  
        map.put("page", page);  
        map.put("display", display);  
        map.put("pagePerBlock", pagePerBlock);  
        map.put("totalPage", totalPage);  
        map.put("beginPage", beginPage);  
        map.put("endPage", endPage);  
        map.put("offset", offset);  
  
        return map;  
  
    }  
      
}
```

- totalCount        게시글 총 개수 (db로부터 조회)
- page              현재 페이지 번호 (요청 파라미터)
- display           한 페이지에 표현할 게시글 최대 개수 (임의 설정)
- pagePerBlock      페이징 바에 표현할 페이지 최대 개수 (임의 설정)