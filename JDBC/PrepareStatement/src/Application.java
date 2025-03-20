public class Application {

    public static void main(String[] args) {

        EmployeeDTO emp = null; 


      
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;


      
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee ID");
        String inputEmpId = sc.nextLine();


        String query = "SELECT * FROM employee WHERE emp_id = ?";

        try {
            pstmt = conn.prepareStatement(query); /// 쿼리를 같이 넘기면서 스태이트먼트 객체를 생성한다.

            ///  현재 담겨있는 미완성된 sql문을 완성형으로 만들기(사용자가 입력한 값을 ?에 채우기)
            //사용자가 입력한 id값을 쿼리의 첫번째 ?에 채워넣는다.
            pstmt.setString(1, inputEmpId);         // 파라미터 바인딩
    

            rset = pstmt.executeQuery(); /// sql문 결과 받기

            /// 매핑
            if(rset.next()) {
                emp = new EmployeeDTO(
                        rs.getString("emp_id")
                        ,rs.getString("emp_name")
                        ,rs.getString("emp_no")
                        ,rs.getString("email")
                        ,rs.getString("phone")
                        ,rs.getString("dept_code")
                        ,rs.getString("job_code")
                        ,rs.getString("sal_level")
                        ,rs.getInt("salary")
                        ,rs.getDouble("bonus")
                        ,rs.getString("manager_id")
                        ,rs.getDate("hire_date")
                        ,rs.getDate("quit_date")
                        ,rs.getString("quit_yn")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(pstmt);/// Statement > PrepareStatement 때문에 자식이 그대로 인수로 넘겨짐 ㄱㄴ
            close(conn);
        }

        if (emp == null) {
            System.out.println("업다");
            return;
        }
        System.out.println("있다.");
        System.out.println(emp);
    }
}
