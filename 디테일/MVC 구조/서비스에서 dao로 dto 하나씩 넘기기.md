#### OrderService
```java
    public int registOrder(OrderDto order) {
        int result = 0;

        Connection conn = getConnection();

        int insertOrderResult = orderDao.insertOrder(conn,order);
        if(insertOrderResult != 0){
            rollback(conn);
            return result;
        }

        int currOrderCode = orderDao.selectCurrOrderCode(conn);

        List<OrderMenuDto> orderMenuList = order.getOrderMenuList();
        int insertOrderMenuResult = 0;

        for(OrderMenuDto orderMenu : orderMenuList) {
            orderMenu.setOrderCode(currOrderCode);
            insertOrderMenuResult += orderDao.insertOrderMenu(conn, orderMenu);
        }

        if(orderMenuList.size() == insertOrderMenuResult) {
            result = 1;
            commit(conn);
        }else {
            rollback(conn);
        }

        close(conn);
        return result;
    }
```
#### OrderDao
```java
    public int insertOrderMenu(Connection conn,OrderMenuDto orderMenu) {
        int result = 0;

        PreparedStatement ps = null;

        String query = prop.getProperty("insertOrderMenu");
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1,orderMenu.getOrderCode());
            ps.setInt(2,orderMenu.getMenuCode());
            ps.setInt(3,orderMenu.getOrderAmount());

            result = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(ps);
        }

        return result;
    }
```
처음에는 insertOrderMenu로 List<OrderMenuDto>을 넘겨줘야한다고 생각했는데 왜 서비스에서 dao로 dto를 하나하나 넘겨주는 것이 선호될까?  
### 1. 트랜잭션 관리의 유연성 -> 개별 결과에 따른 commit & rollback 용이
### 2. 에러 위치 파악 쉬움
### 3. DAO는 단일 책임 - 오직 db 접근 insert만
### 4. PreparedStatement 재사용 어려움
JDBC는 batch insert가 있긴 하지만, 코드 단순성 면에서
for문으로 하나씩 PreparedStatement 생성/실행하는 게 더 안전하고 익숙한 방식
