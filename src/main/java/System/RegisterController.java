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

public class RegisterController {


    @FXML Label usernameLabel;
    @FXML Label passwordLabel;
    @FXML Label emailLabel;
    @FXML Label completeLabel;

    @FXML
    private TextField id;
    @FXML
    private PasswordField pass;
    @FXML
    private TextField mail;

    @FXML
    ComboBox accessLevel;
    private String accessLevel1;

    @FXML
    public  void initialize(){
        accessLevel.getItems().addAll("admin","guest");
        accessLevel.setValue("admin");



    }

    @FXML
    public  void register(ActionEvent e) throws SQLException {
        if(id.getLength()>0){
            usernameLabel.setText("");

        }if(pass.getLength()>0){
            passwordLabel.setText("");

        }if(mail.getLength()>0){
            emailLabel.setText("");
        }

        if(id.getLength()==0){
            usernameLabel.setText("โปรดกรอก username ที่ต้องการ");

        }if(pass.getLength()==0){
            passwordLabel.setText("โปรดกรอก password ที่ต้องการ");

        }if(mail.getLength()==0){
            emailLabel.setText("โปรดกรอก e-mail ที่ต้องการ");
        }

        if(id.getLength()>0&&pass.getLength()>0&&mail.getLength()>0){
            DbConnector dbconnect=new DbConnector();
            Connection connection=dbconnect.connect();
            UserDao userDao=new UserDao(connection);
            EncodeAndDecode encodeAndDecode=new EncodeAndDecode();
            userDao.search(id.getText());
            String username=userDao.getName();
            if(id.getText().equals(username)){
                usernameLabel.setText("username นี้มีอยู่ในระบบแล้ว");
            }if(pass.getLength()<6){
                passwordLabel.setText("โปรดกรอกรหัสอย่างน้อย 6 ตัว");
            }if(pass.getLength()>5&&!id.getText().equals(username)&&mail.getLength()>0){
                accessLevel1= (String) accessLevel.getValue();

                userDao.insert(id.getText(),encodeAndDecode.encode(pass.getText()),mail.getText(),accessLevel1);
                encodeAndDecode.encode(pass.getText());
                System.out.println(pass.getText());
                completeLabel.setText("สมัครสมาชิกเสร็จสมบูรณ์");
                id.setText("");
                pass.setText("");
                mail.setText("");
            }
        }



    }


    @FXML
    public void regisPop(ActionEvent e) throws IOException {

        Button b = (Button) e.getSource();
        Stage stage;
        stage = new Stage(StageStyle.DECORATED);
        stage.show();
        stage.setX(598);
        stage.setY(240);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("register.fxml"));
        try {

            stage.setScene(new Scene((Parent) loader.load(), 654, 514));
            stage.setResizable(false);


        } catch (IOException e1) {
            e1.printStackTrace();

        }
    }
    @FXML
    public  void setDefult(){


        pass.setText("1234567");

    }

}
