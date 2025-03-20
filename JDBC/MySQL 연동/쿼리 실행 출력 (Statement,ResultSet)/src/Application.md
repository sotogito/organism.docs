```java
public class Application1 {
    public static void main(String[] args) {
        Connection conn = JDBCTemplate.getConnection();
        Statement stmt = null; /// 쿼리문 실행 결과 받는 객체
        ResultSet rset = null; /// select문 실행 결과 담는 객체

        String query = "SELECT emp_id,emp_name FROM employee"; ///세미클론 금지

        try {
            stmt = conn.createStatement(); ///statement객체 생성
            rset = stmt.executeQuery(query); ///sql문 실행 및 결과받기

            /// 결과 처리 로직
            while (rset.next()) {
                int emp_id = rs.getInt("emp_id");
                String emp_name = rs.getString("emp_name");
                
                System.out.println(emp_id + " : "+emp_name);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            /**
             * ### 유의할 점
             *     자원반납은 생성된 역순으로 반납해줘야함
             */
            JDBCTemplate.close(rset);
            JDBCTemplate.close(stmt);
            JDBCTemplate.close(conn);
        }
    }
}
```

/*
200 : 선동일
201 : 송종기
202 : 노옹철
203 : 송은희
204 : 유재식
205 : 정중하
206 : 박나라
207 : 하이유
208 : 김해술
209 : 심봉선
210 : 윤은해
211 : 전형돈
212 : 장쯔위
213 : 하동운
214 : 방명수
215 : 대북혼
216 : 차태연
217 : 전지연
218 : 이오리
219 : 임시환
220 : 이중석
221 : 유하진
222 : 이태림
223 : 고두밋
*/
