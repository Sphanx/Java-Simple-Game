package MaceraOyunu;

import java.io.IOException;

public class SafeHouse extends SafeLoc{
    public SafeHouse(Player player) {
        super(player, "Güvenli ev");
    }


    public void saveGame() {
        FileWorks fileWorks = new FileWorks();
        try {
            fileWorks.updateAccount(player);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}
