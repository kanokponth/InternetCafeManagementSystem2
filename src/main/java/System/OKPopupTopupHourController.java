package System;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;

public class OKPopupTopupHourController implements OKPopup {

    private String id;
    private int hour;
    private int money;
    private String number;
    private int h,m,s;
    Connection connection;
    UserDao userDao =new UserDao(connection);
    User user;
    private Stage state;

    @FXML
    public void initialize() {
        System.out.println(number);
    }

    @FXML
    Label msgLabel;

    public void setID(String msg){
        this.id = msg;
        System.out.println(id);
    }

    public void setSumHour(int msg){
        this.hour = msg;
    }
    public void setMoney(int msg){
        this.money = msg;
    }

    public void setH(int h) {
        this.h = h;
        System.out.println(h);
    }

    public void setM(int m) {
        this.m = m;
        System.out.println(m);
    }

    public void setS(int s) {
        this.s = s;
        System.out.println(s);
    }

    public void setNumber(String number) {
        this.number = number;
        System.out.println(number);
    }

    public void setMsg(String msg){
        msgLabel.setText("คุณแน่ใจที่จะเติมชั่วโมง "+ msg + " ชั่วโมงใช่หรือไม่ ?");
    }

    @Override
    public void confirm(ActionEvent event) throws SQLException {
        DbConnector dbconnect=new DbConnector();
        Connection connection=dbconnect.connect();//เชื่อมต่อดีบี
        UserDao userDao=new UserDao(connection);
        userDao.updateHour(id,hour,money);
        state.close();
    }

    @Override
    public void cancel(ActionEvent event) {
        state.close();
    }

    public void setState(Stage s){
        state = s;
    }
}
