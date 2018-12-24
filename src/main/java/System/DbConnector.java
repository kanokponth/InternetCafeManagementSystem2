package System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    private static final String URL="jdbc:mysql://localhost:3306/internetcafe";
    private static final String USER ="root";
    private static final String PASSWORD="";
    private Connection connection;

    public Connection connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection=DriverManager.getConnection(URL,USER,PASSWORD);

            if(!this.connection.isClosed()){
                System.out.println("MySQL connected");
            }else
                System.out.println("MySQL connect failed");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.connection;
    }

    public void close() throws SQLException {
        this.connection.close();
    }
}