```java
@Component  
public class FileUtil {  
  
    public Map<String, String> fileUpload(MultipartFile uploadFile){  
        String filePath = "/upload/board/"+ DateTimeFormatter.ofPattern("/yyyyMMdd").format(LocalDate.now());  
        File filePathDir = new File("C:"+filePath);  
  
        if(!filePathDir.exists()) { // 저장할 경로에 폴더가 없다면  
            filePathDir.mkdirs();   //폴더를 생성  
        }  
        /// 파일명 수정  
        String originalFileName = uploadFile.getOriginalFilename(); //abc.def.jpg  
        String ext = originalFileName.substring(originalFileName.lastIndexOf(".")); //.jpg  
        String filesystemName = UUID.randomUUID().toString().replace("-", "") + ext;// uuid를 사용하여 절대 겹치지않은 파일명으로 설정  
  
        /// 업로드(지정한 폴더에 파일을 저장)  
        try {  
            uploadFile.transferTo(new File(filePathDir, filesystemName)); //중복되지않은파일 이름으로 저장하겠다.  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
  
        return Map.of(  
                "filePath", filePath,  
                "originalName", originalFileName,  
                "filesystemName", filesystemName  
        );  
    }  
  
}
```

#### 주의할 점
util 클래스라 외부에서 사용할 서비스의 DTO와 의존도가 높아지면 안된다. 때문에 util의 반환값은 서비스에서 사용할 DTO가 아닌 
- 독립적인 DTO(record 추천)
- map인데
util이기 떄문에 dto보다는 map이 나을 거 같다.