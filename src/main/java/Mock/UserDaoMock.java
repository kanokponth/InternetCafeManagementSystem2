
import System.UserDao;
import System.User;
import sun.dc.pr.PRError;

import java.sql.SQLException;

public class UserDaoMock {
    private UserDao userDao;

    public UserDaoMock(UserDao userDao) {
        this.userDao = userDao;
    }

    public void findAllDb() throws SQLException {
        this.userDao.findAll();
    }

    public void add(User user) throws SQLException {
        this.userDao.add(user);
    }

    public void delete(String index) throws SQLException {
        this.userDao.delete(index);
    }

    public void updateComputerStatus(String status, String number) throws SQLException {
        this.userDao.updateComputerStatus(status,number);
    }

    public void checkId(String id,String pass) throws SQLException {
        this.userDao.checkID(id,pass);

    }

    public void findComputer() throws SQLException {
        this.userDao.findComputer();
    }

    public void update(String username, int balance) throws SQLException {
        this.userDao.update(username,balance);
    }

    public void updateComputerUser(String username, String status) throws SQLException {
        this.userDao.updateComputerUser(username,status);
    }

    public void updateHourTime(String username, int hour, int min, int sec) throws SQLException {
        this.userDao.updateHourTime(username,hour,min,sec);
    }

    public void search(String username) throws SQLException {
        this.userDao.search(username);
    }

    public void searchStatusComputer(String number) throws SQLException {
        this.userDao.searchStatusComputer(number);
    }

    public void insert(String username,String pass,String mail,String accesslevel) throws SQLException {
        this.userDao.insert(username,pass,mail,accesslevel);
    }

    public void searchPass(String username) throws SQLException {
        this.userDao.searchPass(username);
    }

    public void searchUser(String username) throws SQLException {
        this.userDao.searchUser(username);
    }

    public void updateHour(String username, int hour,int money) throws SQLException {
        this.userDao.updateHour(username,hour,money);
    }

    public void  updatePass(String username, String password) throws SQLException {
        this.userDao.updatePass(username,password);
    }
}
