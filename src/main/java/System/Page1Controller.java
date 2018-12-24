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

public class Page1Controller {
    UserDao userDao =new UserDao();
    @FXML
    private TextField id;
    @FXML
    private PasswordField pass;
    @FXML
    private Label status;

    @FXML
    private Label labelTime;
    @FXML
    ComboBox number;
    String numberComputer;
    String statusComputer;

    @FXML
    public  void initialize(){
        number.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16");
        numberComputer= (String) number.getValue();



    }


    @FXML
    public void logIn(ActionEvent e) throws SQLException, InterruptedException {




        userDao.checkID(id.getText(),pass.getText());
        if(userDao.isCkeck()){
            if(userDao.getAccess().equals("admin")){
                javafx.scene.control.Button b = (javafx.scene.control.Button) e.getSource();
                Stage stage = (Stage) b.getScene().getWindow();
                stage.setX(415);
                stage.setY(176);
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("page2.fxml"));
                try {
                    stage.setScene(new Scene((Parent) loader.load(), 1089, 727));
                    stage.setResizable(false);
                    Page2Controller page2Controller= (Page2Controller) loader.getController();
                } catch (IOException e1) {
                    e1.printStackTrace();

                }

            }else if(userDao.getAccess().equals("guest")){
                userDao.searchUser(id.getText());
                if(!number.getValue().toString().isEmpty()){
                    userDao.searchStatusComputer((String) number.getValue());
                    statusComputer=userDao.getStatus();
                    System.out.println(statusComputer);
                    if(statusComputer.equals("no")){
                        if (userDao.getStatusComputerUser().equals("offline")) {
                                javafx.scene.control.Button b = (javafx.scene.control.Button) e.getSource();
                                Stage stage = (Stage) b.getScene().getWindow();
                                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("userpage.fxml"));
                                stage.setX(1512);
                                stage.setY(0);

                                try {
                                    stage.setScene(new Scene((Parent) loader.load(), 408, 464));


                                    Page1UserController page1UserController = (Page1UserController) loader.getController();
                                    DbConnector dbconnect = new DbConnector();
                                    Connection connection = dbconnect.connect();//เชื่อมต่อดีบี
                                    UserDao userDao = new UserDao(connection);
                                    userDao.updateComputerStatus("yes", (String) number.getValue());
                                    userDao.searchUser(id.getText());
                                    userDao.updateComputerUser(id.getText(), "online");
                                    page1UserController.setMoney(userDao.getMoney() + "");
                                    page1UserController.setHour(userDao.getHour() + "");
                                    System.out.println(userDao.getHour()+"totoo");
                                    page1UserController.setlabel(id.getText());
                                    page1UserController.setIdUser(id.getText());
                                    page1UserController.setPassword(pass.getText());
                                    page1UserController.setMoneyUser(userDao.getMoney() + "");
                                    page1UserController.setMin(userDao.getMin());
                                    page1UserController.setSec(userDao.getSec());
                                    page1UserController.setNumber((String) number.getValue());


                                    stage.setResizable(false);

                                } catch (IOException e1) {
                                    e1.printStackTrace();

                                }
                            } else {
                                status.setText("Username นี้กำลังใช้งานอยู่");
                                id.setText("");
                                pass.setText("");
                            }
                        }


                }
            }


        }
        else {
            status.setText("กรอก username หรือ password ผิด");
        }




    }

}
