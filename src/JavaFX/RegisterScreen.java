package JavaFX;

import MaceraOyunu.FileWorks;
import MaceraOyunu.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;

public class RegisterScreen {
    private String userName;
    private String password;
    private String playerName;
    Player player = new Player();

    @FXML
    TextField userNameTF,
            passwordTF,
            playerNameTF;
    @FXML
    Label warning, startLbl;
    @FXML
    Button startBtn;
    @FXML
    ImageView startImg;

    public void register() throws IOException {
        FileWorks fileWorks = new FileWorks();

        userName = userNameTF.getText();
        password = passwordTF.getText();
        playerName = playerNameTF.getText();


        if(isEqual(userName) && checkUsername(userName) && checkPassword(password) && checkplayerName(playerName)){
            warning.setText("Kayıt Başarılı");
            fileWorks.addAccount(userName, password, playerName);
            fileWorks.loginAccount(userName, password, player);
            fileWorks.updateCurrentAccount(player);
            startBtn.setDisable(false);
            startImg.setOpacity(1);
            startLbl.setOpacity(1);
        }

    }

    private boolean isEqual(String userName) throws IOException {
        File file = new File("src/SaveFiles/Players.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String[] infoArr;
        String line;

        while ((line = reader.readLine()) != null) {
            infoArr = line.split("\\|");
            if ((infoArr[0].equals(userName))) {
                warning.setText("Kullanıcı adı zaten kullanılıyor!");
                return false;
            }
        }
        reader.close();
        return true;
    }
    private boolean checkplayerName(String playerName){
        // Uzunluk kontrolü
        if (playerName.length() > 10) {
            warning.setText("Karakter ismi 10 karakterden daha uzun olamaz!");
            return false;

        }
        if (playerName.length() < 4) {
            warning.setText("Karakter ismi 4 karakterden daha kısa olamaz!");
            return false;

        }

        // Boşluk karakteri kontrolü
        if (playerName.contains(" ")) {
            warning.setText("Karakter ismi boşluk içeremez!");
            return false;
        }
        return true;
    }
    private boolean checkUsername(String userName){



        // Uzunluk kontrolü
        if (userName.length() > 10) {
            warning.setText("Kullanıcı adı 10 karakterden daha uzun olamaz!");
            return false;

        }
        if (userName.length() < 4) {
            warning.setText("Kullanıcı adı 4 karakterden daha kısa olamaz!");
            return false;

        }

        // Boşluk karakteri kontrolü
        if (userName.contains(" ")) {
            warning.setText("Kullanıcı adı boşluk içeremez!");
            return false;
        }

        return true;
    }
    private boolean checkPassword(String password){
        if (password.length() < 4) {
            warning.setText("Şifre 4 karakterden daha kısa olamaz!");
            return false;
        }
        if(password.length() > 10){
            warning.setText("Şifre 10 karakterden daha uzun olamaz!");
            return false;
        }
        if(password.contains(" ")){
            warning.setText("Şifre boşluk içeremez!\n");
            return false;
        }
        return true;
    }
    public void charSelect(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SelectCharScreen.fxml")); //ÖNEMLİ
        Stage stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    public void login(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml")); //ÖNEMLİ
        Stage stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
