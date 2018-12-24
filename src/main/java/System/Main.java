package System;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("page1.fxml"));
        primaryStage.setTitle("Internet Cafe");
        primaryStage.setX(1517);
        primaryStage.setY(0);
        primaryStage.setScene(new Scene(root, 403, 344));
        primaryStage.setResizable(false);


        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
