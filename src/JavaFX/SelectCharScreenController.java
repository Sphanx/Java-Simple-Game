package JavaFX;

import MaceraOyunu.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SelectCharScreenController implements Initializable {
    Player player = new Player();
    FileWorks fileWorks = new FileWorks();
    @FXML
    Label dmgLbl, dmgLbl1, dmgLbl2, hpLbl, hpLbl1, hpLbl2, coinLbl, coinLbl1, coinLbl2;
    @FXML
    Button classBtn, classBtn1, classBtn2;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GameChar[] gameChars = {new Samurai(), new Ranger(), new Knight()};
        FileWorks fileWorks = new FileWorks();

        try {
            fileWorks.getCurrentAccount(player);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        dmgLbl.setText(String.valueOf(gameChars[2].getDamage()));
        hpLbl.setText(String.valueOf(gameChars[2].getHealth()));
        coinLbl.setText(String.valueOf(gameChars[2].getCoin()));
        dmgLbl1.setText(String.valueOf(gameChars[1].getDamage()));
        hpLbl1.setText(String.valueOf((gameChars[1].getHealth())));
        coinLbl1.setText(String.valueOf(gameChars[1].getCoin()));
        dmgLbl2.setText(String.valueOf(gameChars[0].getDamage()));
        hpLbl2.setText(String.valueOf(gameChars[0].getHealth()));
        coinLbl2.setText(String.valueOf(gameChars[0].getCoin()));


    }

    public void knight() throws IOException {
        GameChar knight = new Knight();
        player.setClassName(knight.getName());
        player.setHealth(knight.getHealth());
        player.setDamage(knight.getDamage());
        player.setCoin(knight.getCoin());
        fileWorks.updateCurrentAccount(player);

        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml")); //ÖNEMLİ
        Stage stage = (Stage)classBtn.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    public void ranger() throws IOException{
        GameChar ranger = new Ranger();
        player.setClassName(ranger.getName());
        player.setHealth(ranger.getHealth());
        player.setDamage(ranger.getDamage());
        player.setCoin(ranger.getCoin());
        fileWorks.updateCurrentAccount(player);

        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml")); //ÖNEMLİ
        Stage stage = (Stage)(classBtn1.getScene().getWindow());
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    public void samurai() throws IOException{
        GameChar samurai = new Samurai();
        player.setClassName(samurai.getName());
        player.setHealth(samurai.getHealth());
        player.setDamage(samurai.getDamage());
        player.setCoin(samurai.getCoin());
        fileWorks.updateCurrentAccount(player);

        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml")); //ÖNEMLİ
        Stage stage = (Stage)(classBtn2.getScene().getWindow());
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
