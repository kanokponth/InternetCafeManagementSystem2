package System;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.security.auth.Subject;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Page2Controller {
    UserDao userDao = new UserDao();


    @FXML
    private TableView<Order> orderTable;
    @FXML
    private TableColumn<Order, String> computerNumber;
    @FXML
    private TableColumn<Order, String> detail;
    @FXML
    private TableColumn<Order, String> totalPrice;


    @FXML private Button button1;

    @FXML private Button button2;
    @FXML private Button button3;
    @FXML private Button button4;
    @FXML private Button button5;
    @FXML private Button button6;
    @FXML private Button button7;
    @FXML private Button button8;
    @FXML private Button button9;
    @FXML private Button button10;
    @FXML private Button button11;
    @FXML private Button button12;
    @FXML private Button button13;
    @FXML private Button button14;
    @FXML private Button button15;
    @FXML private Button button16;





    @FXML
    Label label;
    @FXML
    Label time;

    ArrayList<Computer> com=new ArrayList<>();
    Timeline t;
    int c = 3;
    @FXML
    public  void initialize() throws InterruptedException, SQLException {

        setbutton();
        t = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            try {
                timelabel();
                orderTable.setItems(getData());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
        computerNumber.setCellValueFactory(new PropertyValueFactory<Order,String>("computerNumber"));
        detail.setCellValueFactory(new PropertyValueFactory<Order,String>("detail"));
        totalPrice.setCellValueFactory(new PropertyValueFactory<Order,String>("totalPrice"));


    }

    public ObservableList<Order> getData() throws SQLException {
        DbConnector dbconnect=new DbConnector();
        Connection connection=dbconnect.connect();//เชื่อมต่อดีบี
        OrderDao orderDao=new OrderDao(connection);
        ArrayList<Order> orders=orderDao.findAll();
        ObservableList<Order> data=FXCollections.observableArrayList();
        for(Order order:orders){
            data.add(new Order(order.getComputerNumber(),order.getDetail(), order.getTotalPrice()));
        }
        return data;

    }


    @FXML
    public void topUp(ActionEvent e) throws IOException {
        TopupController tp = new TopupController();
        tp.topUpPop(e);
    }

    @FXML
    public void regUp(ActionEvent e) throws IOException {
        RegisterController rg = new RegisterController();
        rg.regisPop(e);
    }



    public void setbutton() throws SQLException {
        DbConnector dbconnect=new DbConnector();
        Connection connection=dbconnect.connect();//เชื่อมต่อดีบี
        UserDao userDao=new UserDao(connection);

        com=userDao.findComputer();
        ArrayList<Button> bt=new ArrayList<>();
        bt.add(button1);
        bt.add(button2);
        bt.add(button3);
        bt.add(button4);
        bt.add(button5);
        bt.add(button6);
        bt.add(button7);
        bt.add(button8);
        bt.add(button9);
        bt.add(button10);
        bt.add(button11);
        bt.add(button12);
        bt.add(button13);
        bt.add(button14);
        bt.add(button15);
        bt.add(button16);





        for(Computer c:com){
            if(c.getStatus().equals("yes")){
                bt.get(com.indexOf(c)).setText("X");
                bt.get(com.indexOf(c)).setStyle("-fx-background-color: red");
            }else {
                bt.get(com.indexOf(c)).setText("O");
                bt.get(com.indexOf(c)).setStyle("-fx-background-color: #33CC66");

            }

        }

    }
    public void timelabel() throws SQLException {


        time.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        if(c>=0){

            if(c==0){
                setbutton();
            }
            c--; }
        if(c==-1)
            c = 3;
    }
    @FXML
    public void manager(ActionEvent e) {
        Button b = (Button) e.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setX(620);
        stage.setY(130);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("manage.fxml"));
        try {
            stage.setScene(new Scene((Parent) loader.load(), 791, 766));
            stage.setResizable(false);

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }




}
