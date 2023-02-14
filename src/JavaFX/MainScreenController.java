package JavaFX;

import MaceraOyunu.FileWorks;
import MaceraOyunu.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {
    Player player = new Player();
    FileWorks fileWorks = new FileWorks();
    Parent root;
    Stage stage;
    Scene scene;

    @FXML
    private Label charName,
            charName1, charName2,
            charName3, charName4,
            charName5, charName6,
            charName7, charName8,
            charName9, charName10,
            removeLbl, showInfoLbl,
            userNameLbl, passwordLbl,
            userName, password;

    @FXML
    ImageView removeImg, showInfoImg, showInfoPnlImg;
    @FXML
    Button showInfoBtn, removeBtn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            fileWorks.getCurrentAccount(player);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        charName.setText(player.getPlayerName());
        charName10.setText(player.getInventory().getArmor().getArmorName());
        charName9.setText(String.valueOf(player.getCoin()));
        charName8.setText(String.valueOf(player.getDamage()));
        charName7.setText(player.getInventory().getWeapon().getWeaponName());
        charName6.setText(String.valueOf(player.getInventory().getWeapon().getDamage()));
        charName5.setText(String.valueOf(player.getTotalDamage()));
        charName4.setText(String.valueOf(player.getHealth()));
        charName3.setText(String.valueOf(player.getInventory().getArmor().getHealth()));
        charName2.setText(String.valueOf(player.getTotalHealth()));
        charName1.setText(player.getInventory().getPotion().getPotionName());

    }


    public void safeHouse(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SafeHouse.fxml")); //ÖNEMLİ
        stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
    }
    public void exit(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml")); //ÖNEMLİ
        stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
    }
    public void toolShop(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ToolShop.fxml")); //ÖNEMLİ
        stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
    }
    public void forest(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ForestScreen.fxml")); //ÖNEMLİ
        stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
    }
    public void GoblinCamp(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("GoblinCampScreen.fxml")); //ÖNEMLİ
        stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
    }
    public void Cave(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("CaveScreen.fxml")); //ÖNEMLİ
        stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
    }
    public void accountSettings(){
        removeLbl.setOpacity(1);
        removeBtn.setDisable(false);
        removeImg.setOpacity(1);
        showInfoLbl.setOpacity(1);
        showInfoBtn.setDisable(false);
        showInfoImg.setOpacity(1);
    }
    public void showInfo(){
        showInfoPnlImg.setOpacity(1);
        userNameLbl.setOpacity(1);
        passwordLbl.setOpacity(1);
        userName.setText(player.getUserName());
        password.setText(player.getPassword());
    }
    public void disableInfo(){
        showInfoPnlImg.setOpacity(0);
        userNameLbl.setOpacity(0);
        passwordLbl.setOpacity(0);
        userName.setText("");
        password.setText("");
    }
    public void removeAccount() throws IOException {
        try {
            fileWorks.removeAccount(player);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File temporaryFile = new File("SaveFiles/CurrentPlayer.txt");
        temporaryFile.delete();

        root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        stage = (Stage)((removeBtn.getScene().getWindow()));
        scene = new Scene(root);
        stage.setScene(scene);
    }

}
