

import System.DbConnector;

import java.sql.SQLException;

public class DbConnectorMock {
    private DbConnector dbConnector;

    public DbConnectorMock(DbConnector connector) {
        this.dbConnector = connector;
    }

    public void connectToDB(){
        this.dbConnector.connect();
    }

    public void closeDB() throws SQLException {
        this.dbConnector.close();
    }
}
