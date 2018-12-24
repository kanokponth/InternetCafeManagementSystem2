

import System.ComputerDao;

import System.Computer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.sql.SQLException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


class ComputerDaoMockTest {
    @Mock
    private ComputerDaoMock Mock;
    @Mock
    private Computer computer;
    @Mock
    private ComputerDao computerDao;

    @BeforeEach
    void initMock(){
        computerDao = mock(ComputerDao.class);
        Mock = new ComputerDaoMock(computerDao);
        computer = new Computer();
    }

    @Test
    void find_All_Data_Db() throws SQLException {
        Mock.findAllDb();
        verify(computerDao).findAll();
    }

    @Test
    void add_Data_To_Db() throws SQLException {
        Mock.add(computer);
        verify(computerDao).add(computer);
    }
}