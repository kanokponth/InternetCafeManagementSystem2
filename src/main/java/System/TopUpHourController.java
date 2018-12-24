package System;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class TopUpHourController {
    private int money;
    private int hour;
    TopUpHour topUpHour;
    Connection connection;

    UserDao userDao =new UserDao();
    private String id;
    @FXML
    private TextField textField;
    @FXML
    private Label textField1;
    @FXML private Label errMsg;
    private  String username;
    private Timeline timeline;
    private Stage primaryStage;
    private String usernameFromPage1;
    private String passwordFromPage1 , number;
    private int h,m,s;

    public void setPasswordFromPage1(String passwordFromPage1) {
        this.passwordFromPage1 = passwordFromPage1;
    }

    public void setNumber(String number) {
        this.number = number;
        System.out.println(number+" 5 5 5 5 5");
    }

    public void setH(int h) {
        this.h = h;
        System.out.println(h+" 5 5 5 5 5");
    }

    public void setM(int m) {
        this.m = m;
        System.out.println(m);
    }

    public void setS(int s) {
        this.s = s;
        System.out.println(s);
    }

    public void setUsernameFromPage1(String usernameFromPage1) {
        this.usernameFromPage1 = usernameFromPage1;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setStage(Stage stage){
        this.primaryStage = stage;
    }

    public void setvalue(int money, int hour, String id) {
        textField1.setText(money +"");
        topUpHour =new TopUpHour(money,hour);
        textField.setEditable(false);
        this.id=id;
    }
    public void setLabel(String input ){
        textField1.setText(input+"");

    }
    @FXML
    public  void add(ActionEvent e){
        topUpHour.increseHour();
        textField.setText(topUpHour.getHour()+"");
        textField1.setText(topUpHour.getMoney()+"");


    }
    @FXML
    public  void del(ActionEvent e){
        topUpHour.decrese();
        textField.setText(topUpHour.getHour()+"");
        textField1.setText(topUpHour.getMoney()+"");

    }


    @FXML
    public  void addHour(ActionEvent e) throws SQLException {
        errMsg.setText("");
        TopUpHourController topUpHourController = new TopUpHourController();

        if (textField.getText().length() > 0 && !textField.getText().equals("0")) {
            Button b = (Button) e.getSource();
            Stage stage;
            stage = new Stage(StageStyle.DECORATED);
            stage.show();
            stage.setX(785);
            stage.setY(330);
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("OKPopupConfirmTopupHour.fxml"));
            try {

                stage.setScene(new Scene((Parent) loader.load(), 334, 242));
                OKPopupTopupHourController okPopupTopupHourController = (OKPopupTopupHourController) loader.getController();
                okPopupTopupHourController.setID(id);
                okPopupTopupHourController.setSumHour(topUpHour.sumHour());
                okPopupTopupHourController.setMoney(topUpHour.getMoney());
                okPopupTopupHourController.setMsg(textField.getText());
                okPopupTopupHourController.setState(stage);
                stage.setResizable(false);

            } catch (IOException e1) {
                e1.printStackTrace();

            }

        }
        else{
            errMsg.setText("โปรดเพิ่มจำนวนชั่วโมง");
        }

    }

    @FXML
    public void addHourPopUp(ActionEvent e) throws IOException, SQLException {
        setValue1();


        Button b = (Button) e.getSource();
        Stage stage;
        stage = new Stage(StageStyle.DECORATED);
        stage.show();
        stage.setX(700);
        stage.setY(230);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("topuphour.fxml"));
        try {

            stage.setScene(new Scene((Parent) loader.load(), 490, 393));
            TopUpHourController topUpHourController  = (TopUpHourController) loader.getController();
            stage.setResizable(false);
            topUpHourController.setLabel(userDao.getMoney()+"");
            topUpHourController.setStage(stage);
            stage.setResizable(false);


            topUpHourController.setvalue(userDao.getMoney(),userDao.getHour(),username);




        } catch (IOException e1) {
            e1.printStackTrace();

        }


    }
    public void setValue1() throws SQLException {
        DbConnector dbconnect=new DbConnector();
        Connection connection=dbconnect.connect();//เชื่อมต่อดีบี
        userDao.searchUser(username);
        System.out.println(id+"dsdsdsd");

    }

    public void backBtn(ActionEvent event)  {

        primaryStage.close();


    }

    public String getNumber() {
        return number;
    }

    public int getH() {
        return h;
    }

    public int getM() {
        return m;
    }

    public int getS() {
        return s;
    }
}
