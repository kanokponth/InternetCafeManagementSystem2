
import static org.junit.jupiter.api.Assertions.*;
import System.DbConnector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.sql.SQLException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class DbConnectorMockTest {
        @Mock
        private DbConnectorMock Mock;
        @Mock
        private DbConnector dbConnector;

        @BeforeEach
        void initMock(){
            dbConnector = mock(DbConnector.class);
            Mock = new DbConnectorMock(dbConnector);
        }

        @Test
        void connect_To_Db(){
            Mock.connectToDB();
            verify(dbConnector).connect();
        }

        @Test
        void  close_Db() throws SQLException {
            Mock.closeDB();
            verify(dbConnector).close();
        }


}