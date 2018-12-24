

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import System.UserDao;
import System.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.sql.SQLException;

class UserDaoMockTest {
    @Mock
    private UserDaoMock Mock;
    @Mock
    private UserDao userDao;
    @Mock
    private User user;

    @BeforeEach
    void initMock(){
        userDao = mock(UserDao.class);
        Mock = new UserDaoMock(userDao);
        user = new User();
    }

    @Test
    void find_All_Data_Db() throws SQLException {
        Mock.findAllDb();
        verify(userDao).findAll();
    }

    @Test
    void add_User() throws SQLException {
        Mock.add(user);
        verify(userDao).add(user);
    }

    @Test
    void delete_row() throws SQLException {
        Mock.delete("2");
        verify(userDao).delete("2");
    }

    @Test
    void update_computer_status() throws SQLException {
        Mock.updateComputerStatus("yes","3");
        verify(userDao).updateComputerStatus("yes","3");
    }

    @Test
    void check_id() throws SQLException {
        Mock.checkId("5","1234");
        verify(userDao).checkID("5","1234");
    }

    @Test
    void find_Computer() throws SQLException {
        Mock.findComputer();
        verify(userDao).findComputer();
    }

    @Test
    void update() throws SQLException {
        Mock.update("boss",500);
        verify(userDao).update("boss",500);
    }

    @Test
    void update_Computer_User() throws SQLException {
        Mock.updateComputerUser("kong", "yes");
        verify(userDao).updateComputerUser("kong","yes");
    }

    @Test
    void update_Hour_Time() throws SQLException {
        Mock.updateHourTime("Mai",2,15,45);
        verify(userDao).updateHourTime("Mai",2,15,45);
    }

    @Test
    void search() throws SQLException {
        Mock.search("Earth");
        verify(userDao).search("Earth");
    }

    @Test
    void search_Status_Computer() throws SQLException {
        Mock.searchStatusComputer("1");
        verify(userDao).searchStatusComputer("1");
    }

    @Test
    void insert() throws SQLException {
        Mock.insert("Toon","079855","masmaroz@gmail.com","guest");
        verify(userDao).insert("Toon","079855","masmaroz@gmail.com","guest");
    }

    @Test
    void search_Pass() throws SQLException {
        Mock.searchPass("tae");
        verify(userDao).searchPass("tae");
    }

    @Test
    void search_User() throws SQLException {
        Mock.searchUser("Kao");
        verify(userDao).searchUser("Kao");
    }

    @Test
    void update_Hour() throws SQLException {
        Mock.updateHour("Nine",5,300);
        verify(userDao).updateHour("Nine",5,300);
    }

    @Test
    void update_Pass() throws SQLException {
        Mock.updatePass("Green","456789");
        verify(userDao).updatePass("Green","456789");
    }
}