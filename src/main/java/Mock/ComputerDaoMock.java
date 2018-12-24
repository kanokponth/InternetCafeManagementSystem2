

import System.ComputerDao;

import System.Computer;
import java.sql.SQLException;

public class ComputerDaoMock {
    private ComputerDao computerDao;

    public ComputerDaoMock(ComputerDao computerDao) {
        this.computerDao = computerDao;

    }

    public void findAllDb() throws  SQLException {
        this.computerDao.findAll();
    }

    public void add(Computer computer) throws SQLException {
        this.computerDao.add(computer);
    }
}
