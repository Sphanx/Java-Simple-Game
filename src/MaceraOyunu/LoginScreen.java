package MaceraOyunu;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginScreen {
    private String warning;

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public void login(String userName, String password, Player player){
        FileWorks fileWorks = new FileWorks();

        try {
            fileWorks.loginAccount(userName, password, player);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
