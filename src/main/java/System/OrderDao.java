package System;

import java.sql.*;
import java.util.ArrayList;

public class OrderDao {
    private Connection connection;

    public OrderDao(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Order> findAll() throws SQLException {
        ArrayList<Order> orders = new ArrayList<>();
        Order order = null;
        String sqlText="select * from orders order by id desc";

        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlText);

        while (resultSet.next()) {
            order = new Order();
            order.setComputerNumber(resultSet.getString("computer_number"));
            order.setDetail(resultSet.getString("detail"));
            order.setTotalPrice(resultSet.getInt("total_price"));

            orders.add(order);
        }
        resultSet.close();
        statement.close();

        return orders;
    }

    public void add(String number,String order,int totalPrice) throws SQLException {


        String sqlText = "insert into orders(computer_number,detail,total_price) values (?,?,?)";

        PreparedStatement preparedStatement = this.connection.prepareStatement(sqlText);

        preparedStatement.setString(1, number);
        preparedStatement.setString(2,order);
        preparedStatement.setString(3,totalPrice+"");

        preparedStatement.executeUpdate();
        preparedStatement.close();

    }




}