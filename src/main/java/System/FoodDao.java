package System;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FoodDao {
    private Connection connection;


    public FoodDao(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Food> findAll() throws SQLException {
        ArrayList<Food> foods=new ArrayList<>();

        Food food =null;

        String sqlText ="select * from food ";


        Statement statement=this.connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sqlText);


        while (resultSet.next()){
            food=new Food();
            food.setFoodID(resultSet.getString("food_id"));
            food.setFoodName(resultSet.getString("food_name"));
            food.setFoodPrice(resultSet.getInt("price"));



            foods.add(food);
        }

        resultSet.close();
        statement.close();
        return foods;
    }

    public void add(Food food) throws SQLException {

        Food newFood=food;

        String sqlText ="insert into food(food_id,food_name,price) values (?,?,?)";

        PreparedStatement preparedStatement=this.connection.prepareStatement(sqlText);

        preparedStatement.setString(1,newFood.getFoodID());
        preparedStatement.setString(2,newFood.getFoodName());
        preparedStatement.setInt(3,newFood.getFoodPrice());

        preparedStatement.executeUpdate();
        preparedStatement.close();

    }








}
