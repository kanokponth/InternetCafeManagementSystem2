
import System.OrderDao;
import System.Order;
import java.sql.SQLException;

public class OrderDaoMock {
    private OrderDao orderDao;

    public OrderDaoMock(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void findAllDb() throws SQLException {
        this.orderDao.findAll();
    }

    public void add(String number, String order, int totalPrice) throws SQLException {
        this.orderDao.add(number,order,totalPrice);
    }
}
