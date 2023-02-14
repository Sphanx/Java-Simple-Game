package JavaFX;

import MaceraOyunu.FileWorks;
import MaceraOyunu.Player;
import MaceraOyunu.SafeHouse;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SafeHouseController implements Initializable {
    Player player = new Player();
    SafeHouse safeHouse = new SafeHouse(player);
    @FXML
    ImageView character;
     @FXML
     Rectangle bed;
     @FXML
     Button restBtn, exitBtn;
     @FXML
     Label btnMsg, saveMsg;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FileWorks fileWorks = new FileWorks();

        try {
            fileWorks.getCurrentAccount(player);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        URL knightURL = ClassLoader.getSystemResource("images/CharSprites/Knight/Knight_idle.png");
        URL rangerURL = ClassLoader.getSystemResource("images/CharSprites/Ranger/Ranger_idle.png");
        URL samuraiURL = ClassLoader.getSystemResource("images/CharSprites/Samurai/Samurai_idle.png");
        if(player.getClassName().equals("Knight")){
            character.setImage(new Image(knightURL.toString()));
        }else if(player.getClassName().equals("Samurai")){
            character.setImage(new Image(samuraiURL.toString()));
        }else{
            character.setImage(new Image(rangerURL.toString()));
        }

    }
    public void onHover(){
        bed.setOpacity(0.34);
        btnMsg.setText("Dinlenmek için tıkla");
    }
    public void exitHover(){
        bed.setOpacity(0.0);
        btnMsg.setText(" ");
    }
    public void rest(){
        safeHouse.saveGame();
        saveMsg.setText("Oyun kaydedildi!");

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1.5), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        saveMsg.setText(" ");
                    }
                })
        );
        timeline.play();

    }
    public void exit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Stage stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }



}
