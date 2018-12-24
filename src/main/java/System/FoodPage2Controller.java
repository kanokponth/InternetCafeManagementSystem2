package System;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;

public class FoodPage2Controller {
    private String id,number;
    private int oldBalance;
    private int totalPrice;
    private String order="";
    private String orderAdmin="";
    @FXML
    Label userLabel;
    @FXML Label balanceLabel;
    @FXML
    TextArea orderTextArea;
    @FXML Label totalPriceLabel;
    private Stage stage2;

    public void setStage2(Stage stage){
        this.stage2 = stage;
    }


    public void receiveOrder(String id, int totalPrice,int newBalance,ArrayList<String> orders,String number,String orderS){
        this.number=number;
        this.id=id;
        this.orderAdmin=orderS;
        this.oldBalance=newBalance+totalPrice;
        this.totalPrice=totalPrice;
        orderTextArea.setEditable(false);
        userLabel.setText(id);
        balanceLabel.setText(String.valueOf(newBalance));
        totalPriceLabel.setText(String.valueOf(totalPrice));

        for(int i=0;i<orders.size();i++){
            this.order+=orders.get(i)+"\n";
        }
        orderTextArea.setText(this.order);


    }
    @FXML public void handleBackButtonOnClick(ActionEvent event){
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setX(510);
        stage.setY(215);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Food.fxml"));
        try {
            stage.setScene(new Scene((Parent) loader.load(), 900, 650));
            FoodController foodController  = (FoodController) loader.getController();
            foodController.sendValue(id,oldBalance,number);
            stage.setResizable(false);






        } catch (IOException e1) {
            e1.printStackTrace();

        }
    }

    @FXML
    public void confirmFood(ActionEvent event){
        Button b = (Button) event.getSource();

        Stage stage;
        stage = new Stage(StageStyle.DECORATED);
        stage.show();
        stage.setX(793);
        stage.setY(419);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("OKPopupFoodController.fxml"));
        try {

            stage.setScene(new Scene((Parent) loader.load(), 334, 242));
            stage.setResizable(false);
            OKPopupFoodController okPopupFoodController = (OKPopupFoodController) loader.getController();
            okPopupFoodController.setStage(stage);
            okPopupFoodController.setStage3(stage2);
            okPopupFoodController.setMsg("คุณต้องการที่จะซื้อสินค้านี้ใช่หรือไม่ ?");
            okPopupFoodController.sendToPop(number,orderAdmin,totalPrice);
            System.out.println(number);

        } catch (IOException e1) {
            e1.printStackTrace();

        }
    }
}