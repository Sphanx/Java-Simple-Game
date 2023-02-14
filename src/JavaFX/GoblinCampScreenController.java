package JavaFX;

import MaceraOyunu.DangerLoc;
import MaceraOyunu.FileWorks;
import MaceraOyunu.GoblinCamp;
import MaceraOyunu.Player;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GoblinCampScreenController implements Initializable {
    FileWorks fileWorks = new FileWorks();
    Player player = new Player();
    DangerLoc goblinCamp;


    @FXML
    Label hpLbl, dmgLbl, coinLbl, hpLbl1, dmgLbl1, coinLbl1, warning, warning2, endLbl, continueLbl, leaveLbl, playerDice, enemyDice;

    @FXML
    Button attackBtn, hpBtn, runBtn, winBtn, loseBtn;
    @FXML
    ImageView character, endImg, leaveImg, enemyImg, playerDiceImg, enemyDiceImg;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            fileWorks.getCurrentAccount(player);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        goblinCamp = new GoblinCamp(player);

        URL knightURL = ClassLoader.getSystemResource("images/CharSprites/Knight/Knight_Stand.png");
        URL rangerURL = ClassLoader.getSystemResource("images/CharSprites/Ranger/Ranger_Stand.png");
        URL samuraiURL = ClassLoader.getSystemResource("images/CharSprites/Samurai/Samurai_Stand.png");
        if(player.getClassName().equals("Knight")){
            character.setImage(new Image(knightURL.toString()));
        }else if(player.getClassName().equals("Samurai")){
            character.setImage(new Image(samuraiURL.toString()));
        }else{
            character.setImage(new Image(rangerURL.toString()));
        }
        updatePlayerStatus();
        updateEnemyStatus();
    }
    public void Battle(){
        //Player Turn
        playerDiceImg.setOpacity(1);
        enemyDiceImg.setOpacity(1);
        playerDice.setText(String.valueOf(goblinCamp.playerAttack()));
        enemyDice.setText(String.valueOf(goblinCamp.enemyAttack()));
        updateEnemyStatus();
        if(goblinCamp.isEnemyDead()){
            win();
        }
        //Enemy Turn
        updatePlayerStatus();
        if(goblinCamp.isPlayerDead()){
            lose();
        }
    }

    public void lose(){
        loseBtn.setDisable(false);
        endImg.setOpacity(0);
        endLbl.setText("KAYBETTİN!\nyaralısın ve geri dönüyorsun...");
        winBtn.setDisable(true);
        leaveLbl.setText("Geri Dön");
        leaveImg.setOpacity(1);
        attackBtn.setDisable(true);
        hpBtn.setDisable(true);
        runBtn.setDisable(true);
        warning2.setText("");
        continueLbl.setText("");
        playerDiceImg.setOpacity(0);
        playerDice.setText("");
        enemyDiceImg.setOpacity(0);
        enemyDice.setText("");
    }
    public void win(){
        winBtn.setDisable(false);
        endImg.setOpacity(1);
        endLbl.setText("KAZANDIN!");
        continueLbl.setText("Devam Et");
        enemyImg.setOpacity(0);
        leaveLbl.setText("Kaç");
        leaveImg.setOpacity(1);
        loseBtn.setDisable(false);
        warning2.setText("Eğer kaçarsan 10 altın kaybedeceksin!");
        attackBtn.setDisable(true);
        hpBtn.setDisable(true);
        runBtn.setDisable(true);
        playerDiceImg.setOpacity(0);
        playerDice.setText("");
        enemyDiceImg.setOpacity(0);
        enemyDice.setText("");
    }

    //leave battle
    public void battleLeave(){
        goblinCamp.run();
        try {
            fileWorks.updateCurrentAccount(player);
            mainScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //stay in battle
    public void battleContinue(){
        winBtn.setDisable(true);
        endImg.setOpacity(0);
        endLbl.setText("");
        endLbl.setFont(new Font("Rockwell", 51));
        continueLbl.setText("");
        goblinCamp.newEnemy();
        leaveImg.setOpacity(0);
        loseBtn.setDisable(true);
        leaveLbl.setText("");
        enemyImg.setOpacity(1);
        updateEnemyStatus();
        updatePlayerStatus();
        warning2.setText("");
        attackBtn.setDisable(false);
        hpBtn.setDisable(false);
        runBtn.setDisable(false);
    }
    public void drinkPotion(){
        if(!goblinCamp.drinkPotion()){
            warning.setText("İksirin Yok!");
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            warning.setText(" ");
                        }
                    })
            );
            timeline.play();
        }
        updatePlayerStatus();
    }
    //warning
    public void run(){
        endImg.setOpacity(1);
        endLbl.setFont(new Font("Rockwell", 26));
        endLbl.setText("10 Altın kaybedeceksin!");
        continueLbl.setText("Devam Et");
        loseBtn.setDisable(false);
        winBtn.setDisable(false);
        endImg.setOpacity(1);
        leaveLbl.setText("Kaç");
        leaveImg.setOpacity(1);
    }

    public void updatePlayerStatus(){
        hpLbl.setText("Can: " + goblinCamp.getTotalHealth());
        dmgLbl.setText("Hasar zarı: 1d" + player.getTotalDamage());
        coinLbl.setText("Para: " + player.getCoin());
    }

    public void updateEnemyStatus(){
        hpLbl1.setText("Can: " + goblinCamp.getEnemy().getHealth());
        dmgLbl1.setText("Hasar zarı: 1d" + goblinCamp.getEnemy().getDamage());
        coinLbl1.setText("Ödül: " + goblinCamp.getEnemy().getCoin());
    }
    public void mainScreen() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml")); //ÖNEMLİ
        Stage stage = (Stage)(runBtn.getScene().getWindow());
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

}
