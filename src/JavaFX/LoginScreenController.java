package JavaFX;

import MaceraOyunu.FileWorks;
import MaceraOyunu.LoginScreen;
import MaceraOyunu.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginScreenController {
    @FXML
    private Parent root;
    private Stage stage;
    private Scene scene;
    private String userName;
    private String password;
    @FXML
    TextField userNameTF, passwordTF;
    @FXML
    protected Label warning;

    public void Login(ActionEvent event) throws IOException {
        Player player = new Player();
        FileWorks fileWorks = new FileWorks();
        LoginScreen loginScreen = new LoginScreen();

        //Get input
        try {
            userName = userNameTF.getText();
            password = passwordTF.getText();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        //Check input
        try {
            loginScreen.login(userName, password, player);
            if(player.getPlayerName() == null){
                warning.setText("Girdiğiniz bilgiler Hatalı!");
            }else{
                fileWorks.currentAccount(userName, password, player);
                if(player.getClassName().equals("null") && player.getTotalDamage() == 0){
                    root = FXMLLoader.load(getClass().getResource("SelectCharScreen.fxml"));
                    stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
                    scene = new Scene(root);
                    stage.setScene(scene);
                }else{
                    root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
                    stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
                    scene = new Scene(root);
                    stage.setScene(scene);
                }

            }
        }catch (ArrayIndexOutOfBoundsException e){
            warning.setText("Lütfen bilgilerinizi giriniz!");
        }catch (Exception e){
            System.out.println(e);
        }



    }

    public void register(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("RegisterScreen.fxml")); //ÖNEMLİ
        stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
    }


}
