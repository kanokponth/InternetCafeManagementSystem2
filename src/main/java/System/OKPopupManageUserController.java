package System;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;

public class OKPopupManageUserController implements OKPopup {

    Stage state;
    Connection connection;
    UserDao userDao =new UserDao(connection);
    String usernameDB;
    @FXML
    Label msgLabel;

    public void setUsernameDB(String usernameDB) {
        this.usernameDB = usernameDB;
        msgLabel.setText("ยืนยันการเปลี่ยนพาสเวิร์ด");
    }

    public String getUsernameDB() {
        return usernameDB;
    }

    @Override
    public void confirm(ActionEvent event) throws SQLException {
        DbConnector dbconnect=new DbConnector();
        Connection connection=dbconnect.connect();
        UserDao userDao=new UserDao(connection);

        userDao.updatePass(getUsernameDB(),"1234567");


        state.close();
    }

    @Override
    public void cancel(ActionEvent event) {
        state.close();
    }

    public void setState(Stage state){
        this.state = state;
    }
}
