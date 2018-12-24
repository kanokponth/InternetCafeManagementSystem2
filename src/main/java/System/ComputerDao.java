package System;

import java.sql.*;
import java.util.ArrayList;

public class ComputerDao {
    private Connection connection;

    public ComputerDao(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Computer> findAll() throws SQLException {
        ArrayList<Computer> computers = new ArrayList<>();
        Computer computer = null;

        String sqlText = "select * from computer order by computer_number";

        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlText);

        while (resultSet.next()) {
            computer = new Computer();
            computer.setComputerNumber(resultSet.getInt("computer_number"));
            computer.setStatus(resultSet.getString("status"));


            computers.add(computer);
        }
        resultSet.close();
        statement.close();

        return computers;
    }

    public void add(Computer computer) throws SQLException {

        Computer newComputer = computer;

        String sqlText = "insert into computer(computer_number,status) values (?,?)";

        PreparedStatement preparedStatement = this.connection.prepareStatement(sqlText);

        preparedStatement.setInt(1, newComputer.getComputerNumber());
        preparedStatement.setString(2, newComputer.getStatus());


        preparedStatement.executeUpdate();
        preparedStatement.close();

    }




}