package JavaFX;

import MaceraOyunu.*;
import javafx.event.ActionEvent;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ToolShopController implements Initializable {
    Player player = new Player();
    FileWorks fileWorks = new FileWorks();
    ToolShop toolShop = new ToolShop(player);
    PotionSuper potions = new HealingPotion();
    ArmorSuper lightArmors = new LightArmor();
    ArmorSuper heavyArmors = new HeavyArmor();
    WeaponSuper knives = new Knife();
    WeaponSuper swords = new Sword();
    WeaponSuper bows = new Bow();
    PotionSuper gpotions = new GhealingPotion();


    @FXML
    Button buyBowBtn, buyHPBtn, buySwordBtn, buyGHPBtn, buyHArmorBtn, buyKnifeBtn, buyLArmorBtn;

    @FXML
    Label wpName, wpInfo, wpPrice, currentBalance, warning;

    @FXML
    ImageView bow, character, ghealing, healing, heavyArmor, knife, lightArmor, sword;

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

        currentBalance.setText("Paran:\t" + player.getCoin());
    }

    public void printLArmor(){
        wpName.setText(lightArmors.getArmorName());
        wpInfo.setText("Sağladığı can: " + lightArmors.getHealth());
        wpPrice.setText("Fiyatı: " + lightArmors.getPrice());
        disableButtons();
        buyLArmorBtn.setDisable(false);
    }
    public void printHArmor(){
        wpName.setText(heavyArmors.getArmorName());
        wpInfo.setText("Sağladığı can: " + heavyArmors.getHealth());
        wpPrice.setText("Fiyatı: " + heavyArmors.getPrice());
        disableButtons();
        buyHArmorBtn.setDisable(false);
    }
    public void printSword(){
        wpName.setText(swords.getWeaponName());
        wpInfo.setText("Silah hasarı: " + swords.getDamage());
        wpPrice.setText("Fiyatı: " + swords.getPrice());
        disableButtons();
        buySwordBtn.setDisable(false);
    }
    public void printKnife(){
        wpName.setText(knives.getWeaponName());
        wpInfo.setText("Silah hasarı: " + knives.getDamage());
        wpPrice.setText("Fiyatı: " + knives.getPrice());
        disableButtons();
        buyKnifeBtn.setDisable(false);
    }
    public void printBow(){
        wpName.setText(bows.getWeaponName());
        wpInfo.setText("Silah hasarı: " + bows.getDamage());
        wpPrice.setText("Fiyatı:" + bows.getPrice());
        disableButtons();
        buyBowBtn.setDisable(false);
    }
    public void printGPotion(){
        wpName.setText(gpotions.getPotionName());
        wpInfo.setText("Can yenilemesi: " + gpotions.getHealthBoost());
        wpPrice.setText("Fiyatı: " + gpotions.getPrice());
        disableButtons();
        buyGHPBtn.setDisable(false);

    }
    public void printPotion(){
        wpName.setText(potions.getPotionName());
        wpInfo.setText("Can yenilemesi: " + potions.getHealthBoost());
        wpPrice.setText("Fiyatı: " + potions.getPrice());
        disableButtons();
        buyHPBtn.setDisable(false);

    }

    public void exit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Stage stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        fileWorks.updateCurrentAccount(player);
    }
    public void buyHP(){
        if(!toolShop.buyPotion(potions)){
            warning.setText("Yeterli miktarda paran yok!\n");
        }else{
            warning.setText(potions.getPotionName() + " Satın Aldın!");
            currentBalance.setText("Paran: " + player.getCoin());
        }
    }
    public void buyGHP(){
        if(!toolShop.buyPotion(gpotions)){
            warning.setText("Yeterli miktarda paran yok!\n");
        }else{
            warning.setText(gpotions.getPotionName() + " Satın Aldın!");
            currentBalance.setText("Paran: " + player.getCoin());
        }
    }
    public void buySword(){
        if(!toolShop.buyWeapon(swords)){
            warning.setText("Yeterli miktarda paran yok!");
        }else{
            warning.setText(swords.getWeaponName() + " Satın Aldın!");
            currentBalance.setText("Paran: " + player.getCoin());
        }
    }
    public void buyKnife(){
        if(!toolShop.buyWeapon(knives)){
            warning.setText("Yeterli miktarda paran yok!");
        }else{
            warning.setText(knives.getWeaponName() + " Satın Aldın!");
            currentBalance.setText("Paran: " + player.getCoin());
        }
    }
    public void buyBow(){
        if(!toolShop.buyWeapon(bows)){
            warning.setText("Yeterli miktarda paran yok!");
        }else{
            warning.setText(bows.getWeaponName() + " Satın Aldın!");
            currentBalance.setText("Paran: " + player.getCoin());
        }
    }
    public void buyHArmor(){
        if(!toolShop.buyArmor(heavyArmors)){
            warning.setText("Yeterli miktarda paran yok!");
        }else{
            warning.setText(heavyArmors.getArmorName() + " Satın Aldın!");
            currentBalance.setText("Paran: " + player.getCoin());
        }
    }
    public void buyLArmor(){
        if(!toolShop.buyArmor(lightArmors)){
            warning.setText("Yeterli miktarda paran yok!");
        }else{
            warning.setText(lightArmors.getArmorName() + " Satın Aldın!");
            currentBalance.setText("Paran: " + player.getCoin());
        }
    }
    public void disableButtons(){
        buyBowBtn.setDisable(true);
        buyGHPBtn.setDisable(true);
        buyHArmorBtn.setDisable(true);
        buyHPBtn.setDisable(true);
        buyKnifeBtn.setDisable(true);
        buyLArmorBtn.setDisable(true);
        buySwordBtn.setDisable(true);
    }

}
