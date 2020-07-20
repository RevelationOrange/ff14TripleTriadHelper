package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("set up the 3 panels");
        primaryStage.setScene(new Scene(root, 1800, 600));
        primaryStage.show();
        Controller c = loader.getController();
        c.Setup();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
