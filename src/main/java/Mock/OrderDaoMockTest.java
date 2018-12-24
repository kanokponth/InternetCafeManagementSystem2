

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import System.OrderDao;
import System.Order;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class OrderDaoMockTest {
    @Mock
    private OrderDao orderDao;
    @Mock
    private OrderDaoMock Mock;

    @BeforeEach
    void initMock(){
        orderDao = mock(OrderDao.class);
        Mock = new OrderDaoMock(orderDao);
    }

    @Test
    void find_All_Data_Db() throws SQLException {
        Mock.findAllDb();
        verify(orderDao).findAll();
    }

    @Test
    void add_Data_To_Db() throws SQLException {
        Mock.add( "2","Lay: 6 Water: 6",108);
        verify(orderDao).add("2","Lay: 6 Water: 6",108);
    }

}