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


public class TopupController {
    Topup topup=new Topup();
    Connection connection;
    UserDao userDao =new UserDao(connection);
    User user;
    ArrayList<Button> listButton;
    Stage stageClose;

    @FXML
    private TextField id;
    @FXML
    private TextField money;

    @FXML
    private Label errorMsg;

    @FXML
    private Label totalPrice;

    @FXML
    private Button btnPrice1;

    @FXML
    private Button btnPrice5;

    @FXML
    private Button btnPrice10;

    @FXML
    private Button btnPrice50;

    @FXML
    private Button btnPrice100;
    @FXML
    private Spinner<Integer> spinner;

    public void setStageClose(Stage stageClose){this.stageClose = stageClose;}


    @FXML
    public void clk1(ActionEvent e){

        topup.topUp(1);
        money.setText(topup.getMoney()+"");
    }
    @FXML
    public void clk5(ActionEvent e){

        topup.topUp(5);
        money.setText(topup.getMoney()+"");
    }
    @FXML
    public void clk10(ActionEvent e){

        topup.topUp(10);
        money.setText(topup.getMoney()+"");
    }@FXML
    public void clk50(ActionEvent e){

        topup.topUp(50);
        money.setText(topup.getMoney()+"");
    }@FXML
    public void clk100(ActionEvent e){

        topup.topUp(100);
        money.setText(topup.getMoney()+"");
    }

    @FXML
    public void clkReset(ActionEvent e){
        topup.setMoney(0);
        money.setText(topup.getMoney()+"");
    }

    @FXML
    public void back(ActionEvent e){
        stageClose.close();
    }


    @FXML
    public void topUpMoney(ActionEvent e) throws SQLException {
        DbConnector dbconnect=new DbConnector();
        Connection connection=dbconnect.connect();
        UserDao userDao=new UserDao(connection);
        userDao.search(id.getText());
        if (id.getText().length() == 0){
            errorMsg.setText("โปรดกรอก username");
        }
        else {
            if (userDao.getName() == null){
                errorMsg.setText("Please Check Your ID");
                System.out.println(userDao.getAccess());
                System.out.println(userDao.getName());
            }
            else if(userDao.getAccess().equals("admin")){
                errorMsg.setText("บัญชีนี้ไม่สามารถเติมเงินได้");

            }
            else if (userDao.getName().equals(id.getText())) {
                errorMsg.setText("");

                Button b = (Button) e.getSource();

                Stage stage;
                stage = new Stage(StageStyle.DECORATED);
                stage.show();
                stage.setX(723);
                stage.setY(363);
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("OKPopup.fxml"));
                try {

                    stage.setScene(new Scene((Parent) loader.load(), 334, 242));
                    stage.setResizable(false);
                    OKPopupTopupController okPopupController = (OKPopupTopupController) loader.getController();
                    okPopupController.setID(id.getText());
                    okPopupController.setMoney(money.getText());
                    okPopupController.setState(stage);
                    okPopupController.setStageClose(stageClose);

                } catch (IOException e1) {
                    e1.printStackTrace();

                }

            }
        }




    }

    @FXML
    public void testBTN(){
        listButton = new ArrayList<>();
        listButton.add(btnPrice1);
    }

    @FXML
    public void topUpPop(ActionEvent e) throws IOException {

        Button b = (Button) e.getSource();

        stageClose = new Stage(StageStyle.DECORATED);
        stageClose.show();
        stageClose.setX(723);
        stageClose.setY(363);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("topup.fxml"));
        try {

            stageClose.setScene(new Scene((Parent) loader.load(), 474, 353));
            stageClose.setResizable(false);
            TopupController topupController = (TopupController) loader.getController();
            topupController.setStageClose(stageClose);





        } catch (IOException e1) {
            e1.printStackTrace();

        }


    }



}
