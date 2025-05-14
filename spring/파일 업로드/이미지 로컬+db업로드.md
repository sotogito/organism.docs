- view
```html
<form action="${contextPath}/board/regist1.do" method="POST" enctype="multipart/form-data">  
  게시글 제목: <input type="text" name="boardTitle"> <br>  
  게시글 내용: <textarea name="boardContent"></textarea> <br>  
  첨부파일: <input type="file" name="uploadFile" accept="image/*"> <br>  
  <input type="submit">  
</form>
```

- controller
```java
@PostMapping("/regist1.do")  
public String registBoard1(@ModelAttribute BoardDto board, @RequestParam MultipartFile uploadFile) {
```

- service
```java
@Override  
public int registOneFileBoard(BoardDto board, MultipartFile uploadFile) {  
    BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);  
  
    int insertResult = boardMapper.insertBoard(board);  
  
    boolean isUploadFileValid = (insertResult > 0 && uploadFile != null && !uploadFile.getOriginalFilename().equals(""));  
    if(isUploadFileValid) {  
        /// 저장경로  
        String filePath = "/upload/board/"+ DateTimeFormatter.ofPattern("/yyyyMMdd").format(LocalDate.now());  
        File filePathDir = new File("C:"+filePath);  
  
        if(!filePathDir.exists()) { // 저장할 경로에 폴더가 없다면  
            filePathDir.mkdirs();   //폴더를 생성  
        }  
        /// 파일명 수정  
        String originalFileName = uploadFile.getOriginalFilename(); //abc.def.jpg  
        String ext = originalFileName.substring(originalFileName.lastIndexOf(".")); //.jpg  
        String filesystemName = UUID.randomUUID().toString().replace("-", "") + ext;// uuid를 사용하여 절대 겹치지않은 파일명으로 설정  
  
        /// 업로드(지정한 퐁더에 파일을 저장)  
        try {  
            uploadFile.transferTo(new File(filePathDir, filesystemName)); //중복되지않은파일 이름으로 저장하겠다.  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
  
        /// db에 저장 - tbl_attachment insert (저장명, 원본명, 수정명, 참조게시글번호)  
        AttachmentDto attachment = AttachmentDto.builder()  
                                                .filePath(filePath)  
                                                .originalName(originalFileName)  
                                                .filesystemName(filesystemName)  
                                                .refBoardNo(board.getBoardNo())  
                                                .build();  
        insertResult = boardMapper.insertAttach(attachment);  
    }  
  
    return insertResult;  
}
```