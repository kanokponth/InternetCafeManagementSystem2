package System;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;

public class OKPopupFoodController implements OKPopup {

    private Stage stage, stage3;
    private String msg;
    private String number,order;
    private int totalPrice;

    public void setMsg(String msg) {
        this.msg = msg;
        msgLabel.setText(msg);
    }

    @FXML Label msgLabel;


    public void sendToPop(String number,String order,int totalPrice){
        this.number=number;
        this.order=order;
        this.totalPrice=totalPrice;



    }

    @Override
    public void confirm(ActionEvent event) throws SQLException {
        DbConnector dbconnect=new DbConnector();
        Connection connection=dbconnect.connect();
        OrderDao orderDao=new OrderDao(connection);

        orderDao.add(number,order,totalPrice);

        stage.close();
        stage3.close();
    }

    @Override
    public void cancel(ActionEvent event) throws SQLException {
        stage.close();
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void setStage3(Stage stage){
        this.stage3 = stage;
    }
}
