package System;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.SQLException;

public class OKPopupTopupController implements OKPopup {

    @FXML
    Label msgLabel;
    @FXML
    Button button;
    private String id;
    Connection connection;
    UserDao userDao =new UserDao(connection);
    User user;
    private String money;
    Stage state;
    Stage stageClose;

    public void setStageClose(Stage sta) {
        stageClose = sta;
    }

    public void setID(String msg){
        this.id = msg;
        System.out.println(id);
    }

    public void setMoney(String msg){
        this.money = msg;
        System.out.println(money);
        msgLabel.setText("คุณแน่ใจที่จะเติมเงิน "+ msg + " บาทใช่หรือไม่ ?");
    }

    public String getId() {
        return id;
    }

    public String getMoney() {
        return money;
    }


    public void setState(Stage s){
        state = s;
    }

    @FXML
    @Override
    public void confirm(ActionEvent event) throws SQLException {
        DbConnector dbconnect=new DbConnector();
        Connection connection=dbconnect.connect();//เชื่อมต่อดีบี
        UserDao userDao=new UserDao(connection);
        userDao.search(getId());
        userDao.update(getId(), Integer.parseInt(getMoney()) + userDao.getMoney());

        state.close();
        stageClose.close();
    }

    @FXML
    @Override
    public void cancel(ActionEvent event) throws SQLException {
        state.close();
    }
}
