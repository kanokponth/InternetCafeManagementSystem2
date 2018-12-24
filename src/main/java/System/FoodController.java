package System;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;


public class FoodController {
    private String id;
    private int balance,totalPrice,layQuantity,paprikaQuantity,cornaeQuantity,estQuantity,cokeQuantity,cokeZeroQuantity;
    private int testoQuantity,potaeQuantity,pringlesQuantity,ichitanQuantity,spriteQuantity,waterQuantity;
    private String order;



    private String name, number;
    private int money;

    public void setMoney(int money) {
        this.money = money;
    }

    private ArrayList<String> orders;


    public void setName(String name) {
        this.name = name;
    }

    @FXML
    Label usernameLabel;
    @FXML Label balanceLabel;
    @FXML Label totalPriceLabel;
    @FXML Label warningLabel;

    @FXML
    TextField layTextField;
    @FXML
    TextField paprikaTextField;
    @FXML
    TextField cornaeTextField;
    @FXML
    TextField testoTextField;
    @FXML
    TextField potaeTextField;
    @FXML
    TextField pringlesTextField;
    @FXML
    TextField estTextField;
    @FXML
    TextField cokeTextField;
    @FXML
    TextField cokeZeroTextField;
    @FXML
    TextField ichitanTextField;
    @FXML
    TextField spriteTextField;
    @FXML
    TextField waterTextField;



    public void sendValue(String id,int balance,String number){
        this.number=number;
        this.balance=balance;
        this.id=id;

        usernameLabel.setText(id);
        balanceLabel.setText(String.valueOf(balance));
    }

    public void setNumber(String num){
        this.number = num;
    }

    @FXML
    public void initialize(){

        layTextField.setEditable(false);
        paprikaTextField.setEditable(false);
        cornaeTextField.setEditable(false);
        testoTextField.setEditable(false);
        potaeTextField.setEditable(false);
        spriteTextField.setEditable(false);
        ichitanTextField.setEditable(false);
        waterTextField.setEditable(false);
        estTextField.setEditable(false);
        cokeTextField.setEditable(false);
        cokeZeroTextField.setEditable(false);
        pringlesTextField.setEditable(false);
    }

    @FXML public void handleIncreaseLayAmountButtonOnClick(ActionEvent e){
        layQuantity++;
        layTextField.setText(String.valueOf(layQuantity));
        totalPrice+=10;
        totalPriceLabel.setText(String.valueOf(totalPrice));
        if(layQuantity>0){

        }

    }
    @FXML public void handleIncreasePaprikaAmountButtonOnClick(ActionEvent e){
        paprikaQuantity++;
        paprikaTextField.setText(String.valueOf(paprikaQuantity));
        totalPrice+=5;
        totalPriceLabel.setText(String.valueOf(totalPrice));

    }
    @FXML public void handleIncreaseCornaeAmountButtonOnClick(ActionEvent e){
        cornaeQuantity++;
        cornaeTextField.setText(String.valueOf(cornaeQuantity));
        totalPrice+=30;
        totalPriceLabel.setText(String.valueOf(totalPrice));

    }
    @FXML public void handleIncreaseEstAmountButtonOnClick(ActionEvent e){
        estQuantity++;
        estTextField.setText(String.valueOf(estQuantity));
        totalPrice+=15;
        totalPriceLabel.setText(String.valueOf(totalPrice));

    }
    @FXML public void handleIncreaseCokeAmountButtonOnClick(ActionEvent e){
        cokeQuantity++;
        cokeTextField.setText(String.valueOf(cokeQuantity));
        totalPrice+=15;
        totalPriceLabel.setText(String.valueOf(totalPrice));

    }
    @FXML public void handleIncreaseCokeZeroAmountButtonOnClick(ActionEvent e){
        cokeZeroQuantity++;
        cokeZeroTextField.setText(String.valueOf(cokeZeroQuantity));
        totalPrice+=20;
        totalPriceLabel.setText(String.valueOf(totalPrice));

    }
    @FXML public void handleIncreaseIchitanAmountButtonOnClick(ActionEvent e){
        ichitanQuantity++;
        ichitanTextField.setText(String.valueOf(ichitanQuantity));
        totalPrice+=20;
        totalPriceLabel.setText(String.valueOf(totalPrice));

    }
    @FXML public void handleIncreaseWaterAmountButtonOnClick(ActionEvent e){
        waterQuantity++;
        waterTextField.setText(String.valueOf(waterQuantity));
        totalPrice+=8;
        totalPriceLabel.setText(String.valueOf(totalPrice));

    }
    @FXML public void handleIncreaseSpriteAmountButtonOnClick(ActionEvent e){
        spriteQuantity++;
        spriteTextField.setText(String.valueOf(spriteQuantity));
        totalPrice+=15;
        totalPriceLabel.setText(String.valueOf(totalPrice));

    }
    @FXML public void handleIncreaseTestoAmountButtonOnClick(ActionEvent e){
        testoQuantity++;
        testoTextField.setText(String.valueOf(testoQuantity));
        totalPrice+=15;
        totalPriceLabel.setText(String.valueOf(totalPrice));

    }
    @FXML public void handleIncreasePringlesAmountButtonOnClick(ActionEvent e){
        pringlesQuantity++;
        pringlesTextField.setText(String.valueOf(pringlesQuantity));
        totalPrice+=30;
        totalPriceLabel.setText(String.valueOf(totalPrice));

    }
    @FXML public void handleIncreasePotaeAmountButtonOnClick(ActionEvent e){
        potaeQuantity++;
        potaeTextField.setText(String.valueOf(potaeQuantity));
        totalPrice+=20;
        totalPriceLabel.setText(String.valueOf(totalPrice));

    }
    //*************************************************************************************
    @FXML public void handleDecreaseTestoAmountButtonOnClick(ActionEvent e){
        if(testoQuantity>0){
            testoQuantity--;
            testoTextField.setText(String.valueOf(testoQuantity));
            totalPrice-=15;
            totalPriceLabel.setText(String.valueOf(totalPrice));
        }


    }
    @FXML public void handleDecreasePringlesAmountButtonOnClick(ActionEvent e){
        if(pringlesQuantity>0){
            pringlesQuantity--;
            pringlesTextField.setText(String.valueOf(pringlesQuantity));
            totalPrice-=30;
            totalPriceLabel.setText(String.valueOf(totalPrice));
        }


    }
    @FXML public void handleDecreasePotaeAmountButtonOnClick(ActionEvent e){
        if(potaeQuantity>0){
            potaeQuantity--;
            potaeTextField.setText(String.valueOf(potaeQuantity));
            totalPrice-=20;
            totalPriceLabel.setText(String.valueOf(totalPrice));
        }


    }
    @FXML public void handleDecreaseLayAmountButtonOnClick(ActionEvent e){
        if(layQuantity>0){
            layQuantity--;
            layTextField.setText(String.valueOf(layQuantity));
            totalPrice-=10;
            totalPriceLabel.setText(String.valueOf(totalPrice));
        }


    }
    @FXML public void handleDecreasePaprikaAmountButtonOnClick(ActionEvent e){
        if(paprikaQuantity>0){
            paprikaQuantity--;
            paprikaTextField.setText(String.valueOf(paprikaQuantity));
            totalPrice-=5;
            totalPriceLabel.setText(String.valueOf(totalPrice));
        }

    }
    @FXML public void handleDecreaseCornaeAmountButtonOnClick(ActionEvent e){
        if(cornaeQuantity>0){
            cornaeQuantity--;
            cornaeTextField.setText(String.valueOf(cornaeQuantity));
            totalPrice-=30;
            totalPriceLabel.setText(String.valueOf(totalPrice));
        }

    }
    @FXML public void handleDecreaseEstAmountButtonOnClick(ActionEvent e){
        if(estQuantity>0){
            estQuantity--;
            estTextField.setText(String.valueOf(estQuantity));
            totalPrice-=15;
            totalPriceLabel.setText(String.valueOf(totalPrice));
        }

    }
    @FXML public void handleDecreaseCokeAmountButtonOnClick(ActionEvent e){
        if(cokeQuantity>0){
            cokeQuantity--;
            cokeTextField.setText(String.valueOf(cokeQuantity));
            totalPrice-=15;
            totalPriceLabel.setText(String.valueOf(totalPrice));
        }

    }
    @FXML public void handleDecreaseCokeZeroAmountButtonOnClick(ActionEvent e){
        if(cokeZeroQuantity>0){
            cokeZeroQuantity--;
            cokeZeroTextField.setText(String.valueOf(cokeZeroQuantity));
            totalPrice-=20;
            totalPriceLabel.setText(String.valueOf(totalPrice));
        }

    }
    @FXML public void handleDecreaseSpriteAmountButtonOnClick(ActionEvent e){
        if(spriteQuantity>0){
            spriteQuantity--;
            spriteTextField.setText(String.valueOf(spriteQuantity));
            totalPrice-=15;
            totalPriceLabel.setText(String.valueOf(totalPrice));
        }

    }
    @FXML public void handleDecreaseIchitanAmountButtonOnClick(ActionEvent e){
        if(ichitanQuantity>0){
            ichitanQuantity--;
            ichitanTextField.setText(String.valueOf(ichitanQuantity));
            totalPrice-=20;
            totalPriceLabel.setText(String.valueOf(totalPrice));
        }

    }
    @FXML public void handleDecreaseWaterAmountButtonOnClick(ActionEvent e){
        if(waterQuantity>0){
            waterQuantity--;
            waterTextField.setText(String.valueOf(waterQuantity));
            totalPrice-=8;
            totalPriceLabel.setText(String.valueOf(totalPrice));
        }

    }

    @FXML public void handleConfirmButtonOnClick(ActionEvent event){
        order=""; //ออร์เดอร์ที่สั่ง
        ArrayList<String> orders=new ArrayList<>();
        if(totalPrice>balance){ //เงินไม่พอ
            warningLabel.setText("จำนวนเงินของท่านไม่เพียงพอ กรุณาเติมเงิน");
        }
        else if(totalPrice==0){
            warningLabel.setText("โปรดเลือกอาหารที่ท่านต้องการ");
        }
        else{//เงินพอ
            if(layQuantity>0){
                order+=" "+"Lay: "+layQuantity;
                orders.add(" "+"Lay: "+layQuantity);

            }if(paprikaQuantity>0){
                order+=" "+"Paprika: "+paprikaQuantity;
                orders.add(" "+"Paprika: "+paprikaQuantity);

            }if(cornaeQuantity>0){
                order+=" "+"Cornae: "+cornaeQuantity;
                orders.add(" "+"Cornae: "+cornaeQuantity);

            }if(estQuantity>0){
                order+=" "+"Est: "+estQuantity;
                orders.add(" "+"Est: "+estQuantity);

            }if(cokeQuantity>0){
                order+=" "+"Coke: "+cokeQuantity;
                orders.add(" "+"Coke: "+cokeQuantity);

            }if(cokeZeroQuantity>0){
                order+=" "+"Coke Zero: "+cokeZeroQuantity;
                orders.add(" "+"Coke Zero: "+cokeZeroQuantity);
            }
            if(testoQuantity>0){
                order+=" "+"Testo: "+testoQuantity;
                orders.add(" "+"Testo: "+testoQuantity);

            }if(pringlesQuantity>0){
                order+=" "+"Pringles: "+pringlesQuantity;
                orders.add(" "+"Pringles: "+pringlesQuantity);

            }if(potaeQuantity>0){
                order+=" "+"Potae: "+potaeQuantity;
                orders.add(" "+"Potae: "+potaeQuantity);

            }if(waterQuantity>0){
                order+=" "+"Water: "+waterQuantity;
                orders.add(" "+"Water: "+waterQuantity);

            }if(ichitanQuantity>0){
                order+=" "+"Ichitan: "+ichitanQuantity;
                orders.add(" "+"Ichitan: "+ichitanQuantity);

            }if(spriteQuantity>0){
                order+=" "+"Sprite: "+spriteQuantity;
                orders.add(" "+"Sprite: "+spriteQuantity);
            }
            //ได้ order เป็นสตริง เอาไปเเจ้งเตือน หน้า admin   ส่วน orders เอาไว้ โชว์ text area หน้าต่อไปเฉยๆ


            Button b = (Button) event.getSource();
            Stage stage1 = (Stage) b.getScene().getWindow();
            stage1.setX(687);
            stage1.setY(273);
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("FoodPage2.fxml"));
            try {
                stage1.setScene(new Scene((Parent) loader.load(), 546, 533));
                FoodPage2Controller foodPage2Controller  = (FoodPage2Controller) loader.getController();
                foodPage2Controller.receiveOrder(id,totalPrice,balance-totalPrice,orders,number,order);
                foodPage2Controller.setStage2(stage1);
                stage1.setResizable(false);




            } catch (IOException e1) {
                e1.printStackTrace();

            }



        }
    }

    @FXML
    public void setFoodPopup(ActionEvent event) throws SQLException {
        Button b = (Button) event.getSource();

        Stage stage;
        stage = new Stage(StageStyle.DECORATED);
        stage.show();
        stage.setX(510);
        stage.setY(215);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("food.fxml"));
        try {

            stage.setScene(new Scene((Parent) loader.load(), 900, 650));
            FoodController foodController=(FoodController) loader.getController();

            System.out.println(number);
            foodController.sendValue(name,money,number);


            stage.setResizable(false);
        } catch (IOException e1) {
            e1.printStackTrace();

        }

    }

}