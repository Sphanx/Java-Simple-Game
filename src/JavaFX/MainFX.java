package JavaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class MainFX extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml")); //ÖNEMLİ
        Scene scene = new Scene(root);
        primaryStage.setTitle("Yakın Diyarlar Destanı");

        primaryStage.setHeight(720);
        primaryStage.setWidth(1280);
        primaryStage.setResizable(false);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
