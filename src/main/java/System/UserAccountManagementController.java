package System;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserAccountManagementController {
    private String password,username;
    private int money;
    UserDao userDao;



    @FXML
    ChoiceBox numberComputer;
    @FXML
    Label usernameLabel;
    @FXML
    Label passError;
    String  name;
    String seveMoney;


    @FXML
    TextField oldPasswordTextfield;

    @FXML
    TextField newPasswordTextfield;

    @FXML
    TextField newPasswordConfirmationTextfield;

    @FXML
    Label balanceLabel;

    @FXML
    Label newPasswordLabel;

    @FXML
    Label confirmPassLabel;
    @FXML Label oldPasswordLabel;
    @FXML Label completeLabel;
    @FXML Label nullLabel;




    public void receiveValue(String usernameFromUserPage,String passwordFromUserPage,int moneyFromUserPage){
        this.password=passwordFromUserPage;
        this.username=usernameFromUserPage;
        this.money=moneyFromUserPage;

    }
    public void setValue(String id,String money){
        usernameLabel.setText(id);
        balanceLabel.setText(money);

    }

    @FXML
    public void handleBtnOkOnClick(ActionEvent event) throws SQLException {

        DbConnector dbconnect=new DbConnector();
        Connection connection=dbconnect.connect();
        UserDao userDao = new UserDao(connection);

        if (newPasswordTextfield.getText().length() == 0 || oldPasswordTextfield.getText().length() == 0 || newPasswordConfirmationTextfield.getText().length() == 0){
            nullLabel.setText("โปรดกรอกข้อมูลให้ครบถ้วน");
            oldPasswordLabel.setText("");
            newPasswordLabel.setText("");
            confirmPassLabel.setText("");
        }
        else if (!password.equals(oldPasswordTextfield.getText())){
            oldPasswordLabel.setText("password ไม่ตรงกัน");
            newPasswordLabel.setText("");
            nullLabel.setText("");
            confirmPassLabel.setText("");
        }
        else if(newPasswordTextfield.getText().length() < 6) {
            newPasswordLabel.setText("โปรดใส่ password อย่างน้อย 6 หลัก");
            oldPasswordLabel.setText("");
            nullLabel.setText("");
            confirmPassLabel.setText("");
        }
        else if (newPasswordConfirmationTextfield.getText().length() < 6){
            newPasswordLabel.setText("โปรดใส่ password ใหม่ให้ถูกต้อง");
            confirmPassLabel.setText("");
            oldPasswordLabel.setText("");
            nullLabel.setText("");
        }
        else if (newPasswordTextfield.getText().equals(password)){
            newPasswordLabel.setText("โปรดใส่ password ไม่ให้ตรงกับพาสเวิร์ดเก่า");
            oldPasswordLabel.setText("");
            nullLabel.setText("");
            confirmPassLabel.setText("");
        }

        else if (!newPasswordConfirmationTextfield.getText().equals(newPasswordTextfield.getText())){
            confirmPassLabel.setText("โปรดใส่ password ให้ตรงกัน");
            oldPasswordLabel.setText("");
            nullLabel.setText("");
            newPasswordLabel.setText("");

        }
        else{
            completeLabel.setText("เปลี่ยน password เรียบร้อยแล้ว");
            oldPasswordLabel.setText("");
            newPasswordLabel.setText("");
            nullLabel.setText("");
            confirmPassLabel.setText("");
            EncodeAndDecode encodeAndDecode=new EncodeAndDecode();
            userDao.updatePass(username,encodeAndDecode.encode(newPasswordConfirmationTextfield.getText()));
            System.out.println(encodeAndDecode.decode());
        }


    }




    @FXML
    public void UserManagePopup(ActionEvent e) throws IOException, SQLException {

        Button b = (Button) e.getSource();

        Stage stage;
        stage = new Stage(StageStyle.DECORATED);
        stage.show();
        stage.setX(750);
        stage.setY(270);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("UserAccountManagement.fxml"));
        try {

            stage.setScene(new Scene((Parent) loader.load(), 420, 540));
            UserAccountManagementController userAccountManagementController=(UserAccountManagementController)loader.getController();
            userAccountManagementController.setValue(name,seveMoney);
            userAccountManagementController.receiveValue(name, password, money);


            stage.setResizable(false);
        } catch (IOException e1) {
            e1.printStackTrace();

        }


    }

    public void setName(String n){
        name=n;
    }
    public void setMoney(String m){
        seveMoney=m;

    }
    public void setPassword(String password){
        this.password = password;
    }

}

