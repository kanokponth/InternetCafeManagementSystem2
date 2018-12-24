package System;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Page1UserController {

    @FXML
    private Label hour;
    @FXML
    private Label number;
    @FXML
    private Label money;
    @FXML
    private Button start;
    private String id ;
    private String moneyUser;
    Timeline t;
    int h = 0;
    int m=0;
    int s=0;
    int c=3;
    private String password;
    Connection connection;
    @FXML
    private  Label username;
    @FXML
    public  void initialize() throws InterruptedException, SQLException {
        DbConnector dbconnect=new DbConnector();
        Connection connection=dbconnect.connect();
        userDao.searchUser("u");
        username.setText(userDao.getName());

        money.setText(userDao.getMoney()+"");
        t = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            try {

                timelabel();


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();

    }

    UserDao userDao =new UserDao();
    User user;
    public void setPassword(String password) {
        this.password = password;
    }





    public void setMoneyUser(String moneyUser) {
        this.moneyUser = moneyUser;
    }

    public String getIdUser() {
        return id;
    }

    public void setIdUser(String id) {
        this.id = id;

    }
    public void setlabel(String id) {
        username.setText(id);
        this.id=id;
    }

    public Page1UserController() throws SQLException {

        getIdUser();



    }

    public void setMoney(String money1){
        money.setText(money1);

    }
    public void setHour(String hour1){
        h=Integer.parseInt(hour1);


    }
    public void setValue() throws SQLException {
        DbConnector dbconnect=new DbConnector();
        Connection connection=dbconnect.connect();
        userDao.searchUser(username.getText());
        System.out.println(id+"dsdsdsd");


    }
    @FXML
    public void start(ActionEvent e) throws SQLException {
        setValue();
        money.setText(String.valueOf(userDao.getMoney()));
        hour.setText(userDao.getHour()+"");
        start.setText("Logout");

    }
    @FXML
    public void topUpHour(ActionEvent e) throws SQLException {
        setValue();
        javafx.scene.control.Button b = (javafx.scene.control.Button) e.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("topuphour.fxml"));
        stage.setX(793);
        stage.setY(419);
        try {
            stage.setScene(new Scene((Parent) loader.load(), 600, 600));
            stage.setResizable(false);

            TopUpHourController topUpHourController= (TopUpHourController) loader.getController();
            topUpHourController.setvalue(userDao.getMoney(),userDao.getHour(),id);




        } catch (IOException e1) {
            e1.printStackTrace();

        }
    }

    @FXML
    public void handlePopUpChangePasswordButtonOnClick(ActionEvent e) throws SQLException {
        setValue();
        javafx.scene.control.Button b = (javafx.scene.control.Button) e.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("UserAccountManagement.fxml"));
        stage.setX(750);
        stage.setY(270);
        try {
            stage.setScene(new Scene((Parent) loader.load(), 420, 540));
            stage.setResizable(false);
            UserAccountManagementController userAccountManagementController= (UserAccountManagementController) loader.getController();
            userAccountManagementController.receiveValue(id,password,userDao.getMoney());

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    public void addHourUserPopUp(ActionEvent e) throws IOException, SQLException {
        setValue();

        TopUpHourController topUphour = new TopUpHourController();
        topUphour.setUsername(id);
        topUphour.setPasswordFromPage1(password);
        topUphour.setNumber(number.getText());
        topUphour.setH(h);
        topUphour.setM(m);
        topUphour.setS(s);
        topUphour.addHourPopUp(e);
    }
    public void lname(String name){
        this.id=name;
        username.setText(name);
    }

    @FXML
    public void foodPopup(ActionEvent e) throws IOException, SQLException {
        setValue();

        FoodController foodController = new FoodController();
        foodController.setMoney(Integer.parseInt(money.getText()));
        foodController.setName(username.getText());
        foodController.setNumber(number.getText());
        foodController.setFoodPopup(e);
        //foodController.sendValue(username.getText(), Integer.parseInt(money.getText()));
    }

    @FXML
    public void back(ActionEvent e) throws SQLException {
        Button b = (Button) e.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("page1.fxml"));
        DbConnector dbconnect=new DbConnector();
        Connection connection=dbconnect.connect();//เชื่อมต่อดีบี
        UserDao userDao =new UserDao(connection);
        userDao.searchUser(id);

        if(h!=0&&m!=0&&s!=0){
            userDao.updateHourTime(id,h,m,s);

        }

        System.out.println(h+"toto"+m+"roro");
        userDao.updateComputerStatus("no",number.getText());
        userDao.updateComputerUser(id,"offline");
        stage.setX(1512);
        stage.setY(0);
        try {
            stage.setScene(new Scene((Parent) loader.load(), 403, 344));
            Page1Controller page1Controller  = (Page1Controller) loader.getController();
            stage.setResizable(false);
            } catch (IOException e1) {
            e1.printStackTrace();
            }
    }
    @FXML
    public void toFoodPage(ActionEvent e){
        Button b = (Button) e.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Food.fxml"));
        stage.setX(510);
        stage.setY(215);
        try {
            stage.setScene(new Scene((Parent) loader.load(), 900, 650));
            FoodController foodController  = (FoodController) loader.getController();
            stage.setResizable(false);
            userDao.searchUser(id);




        } catch (IOException e1) {
            e1.printStackTrace();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

    @FXML
    public void manageUserPopUp(ActionEvent e) throws IOException, SQLException {
        setValue();

        UserAccountManagementController user = new UserAccountManagementController();

       user.setMoney(userDao.getMoney()+"");
       user.setName(username.getText()+"");
       user.setPassword(password);
       user.UserManagePopup(e);


    }
    public void setPage() throws SQLException {
        setValue();
        hour.setText(userDao.getHour()+" :"+userDao.getMin()+" :"+userDao.getSec() );
    }
    public void timelabel() throws SQLException {



        if(s == 0){
            if(m==0){
                if(h>0){
                    h--;
                    m=59;
                    s=59;
                }else {
                    if(h==0&&m==0&&m==0){
                        hour.setText("TimeOut");
                        h=0;
                        m=0;
                        s=0;

                    }

                }

            }
            else {
                m--;
                s=59;
            }


        }else {
            s--;
        }
        if(h==0&&m==0&&s==0){
            hour.setText("TimeOut");

        }else {
            hour.setText(h+":"+m+":"+s);
            /*DbConnector dbconnect=new DbConnector();
            Connection connection=dbconnect.connect();//เชื่อมต่อดีบี
            UserDao userDao =new UserDao(connection);

            userDao.updateHourTime(id,h,m,s);*/

        }


    }
    public void setMin(int m){
        this.m=m;
    }
    public void setSec(int s){
        this.s=s;
    }
    public void setNumber(String n){
        number.setText(n);

    }
}



