package System;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ManageUserController{
    UserDao userDao =new UserDao();
    Stage state;
    @FXML
    private TextField input;
    @FXML
    private TableView<Produec> table1;
    @FXML
    private TextArea textArea;
    @FXML
    private TableColumn<Produec,String>username  ;
    @FXML
    private TableColumn<Produec,String>password  ;
    @FXML
    private TableColumn<Produec,String>email  ;
    @FXML
    private TableColumn<Produec,String>access_lavel  ;
    @FXML
    private TableColumn<Produec,Integer>balance  ;
    @FXML
    private TableColumn<Produec,Integer>hour  ;


    @FXML
    public  void initialize() throws SQLException {
        input.setEditable(false);

        username.setCellValueFactory(new PropertyValueFactory<Produec, String>("username"));

        email.setCellValueFactory(new PropertyValueFactory<Produec, String>("email"));
        access_lavel.setCellValueFactory(new PropertyValueFactory<Produec, String>("access_Level"));
        balance.setCellValueFactory(new PropertyValueFactory<Produec,Integer>("balance"));
        hour.setCellValueFactory(new PropertyValueFactory<Produec,Integer>("hour"));
        table1.setItems(userDao.getProduce());
        table1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                clickTable();
            }
        });
    }

    public void clickTable(){
        ObservableList<Produec> wordselect;
        wordselect=table1.getSelectionModel().getSelectedItems();
        for(Produec produec:wordselect){
            input.setText(produec.getUsername());
        }
    }
    @FXML
    public void back(ActionEvent e){
        Button b = (Button) e.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setX(415);
        stage.setY(176);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("page2.fxml"));
        try {
            stage.setScene(new Scene((Parent) loader.load(), 1089, 727));
            Page2Controller page2Controller  = (Page2Controller) loader.getController();
            stage.setResizable(false);



        } catch (IOException e1) {
            e1.printStackTrace();

        }

    }
    @FXML
    public void setDefult(ActionEvent e) throws SQLException {
        DbConnector dbconnect=new DbConnector();
        Connection connection=dbconnect.connect();
        UserDao userDao=new UserDao(connection);

        Button b = (Button) e.getSource();

        Stage stage;
        stage = new Stage(StageStyle.DECORATED);
        stage.show();
        stage.setX(793);
        stage.setY(419);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("OKPopupManageUser.fxml"));
        try {

            stage.setScene(new Scene((Parent) loader.load(), 334, 242));
            stage.setResizable(false);
            OKPopupManageUserController okPopupManageUserController = (OKPopupManageUserController) loader.getController();
            okPopupManageUserController.setUsernameDB(input.getText());
            okPopupManageUserController.setState(stage);


        } catch (IOException e1) {
            e1.printStackTrace();

        }





    }


}
