package MaceraOyunu;

import java.io.*;

public class FileWorks extends LoginScreen {
    File file = new File("src/SaveFiles/Players.txt");



    public boolean addAccount(String username, String password, String playerName ){
        Player newPlayer = new Player();
        try {
            BufferedWriter buffwriter = new BufferedWriter(new FileWriter(file.getAbsoluteFile(), true));
            buffwriter.write("\n"+
                    username + "|" +
                    password + "|" +
                    playerName + "|" +
                    newPlayer.getCoin() + "|" +
                    newPlayer.getClassName() + "|" +
                    newPlayer.getDamage() + "|" +
                    newPlayer.getHealth() + "|" +
                    newPlayer.getInventory().getWeapon().getWeaponName() + "|" +
                    newPlayer.getInventory().getWeapon().getDamage() + "|" +
                    newPlayer.getTotalDamage() + "|" +
                    newPlayer.getInventory().getArmor().getArmorName() +"|"+
                    newPlayer.getInventory().getArmor().getHealth() + "|" +
                    newPlayer.getTotalHealth() + "|" +
                    newPlayer.getInventory().getPotion().getPotionName() + "|" +
                    newPlayer.getInventory().getPotion().getHealthBoost());
            buffwriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public void updateAccount(Player player) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/SaveFiles/Yenidosya.txt"));
        String[] infoArr;
        String line;

        while((line = reader.readLine()) != null){
            infoArr = line.split("\\|");
            if((infoArr[0].equals(player.getUserName())) && (infoArr[1].equals(player.getPassword()))){
                infoArr[2] = player.getPlayerName();
                infoArr[3] = String.valueOf(player.getCoin());
                infoArr[4] = player.getClassName();
                infoArr[5] = String.valueOf(player.getDamage());
                infoArr[6] = String.valueOf(player.getHealth());
                infoArr[7] = player.getInventory().getWeapon().getWeaponName();
                infoArr[8] = String.valueOf(player.getInventory().getWeapon().getDamage());
                infoArr[9] = String.valueOf(player.getTotalDamage());
                infoArr[10] = player.getInventory().getArmor().getArmorName();
                infoArr[11] = String.valueOf(player.getInventory().getArmor().getHealth());
                infoArr[12] = String.valueOf(player.getTotalHealth());
                infoArr[13] = player.getInventory().getPotion().getPotionName();
                infoArr[14] = String.valueOf(player.getInventory().getPotion().getHealthBoost());
                String newLine = String.join("|", infoArr);
                writer.write(newLine);
                writer.newLine();
            }else{
                writer.write(line);
                writer.newLine();
            }
        }
        reader.close();
        writer.close();
        file.delete();
        File file2 = new File("src/SaveFiles/Yenidosya.txt");
        file2.renameTo(file);
    }

    public void removeAccount(Player player) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/SaveFiles/Yenidosya.txt"));
        String[] infoArr;
        String line;

        while((line = reader.readLine()) != null) {
            if (!line.isEmpty()){
                infoArr = line.split("\\|");
                if (!(infoArr[0].equals(player.getUserName()) && infoArr[1].equals(player.getPassword())) && (infoArr[10] != null)) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        }

            reader.close();
            writer.close();
            file.delete();
            File file2 = new File("src/SaveFiles/Yenidosya.txt");
            file2.renameTo(file);
    }
    public void loginAccount(String userName, String password, Player player) throws IOException {
         BufferedReader reader = new BufferedReader(new FileReader(file));
         String[] infoArr;
         String line;

        while((line = reader.readLine()) != null){
            infoArr = line.split("\\|");
            if((infoArr[0].equals(userName)) && (infoArr[1].equals(password))){
                player.setUserName(infoArr[0]);
                player.setPassword(infoArr[1]);
                player.setPlayerName(infoArr[2]);
                player.setCoin(Integer.parseInt(infoArr[3]));
                player.setClassName(infoArr[4]);
                player.setDamage(Integer.parseInt(infoArr[5]));
                player.setHealth(Integer.parseInt(infoArr[6]));
                player.getInventory().getWeapon().setWeaponName(infoArr[7]);
                player.getInventory().getWeapon().setDamage(Integer.parseInt(infoArr[8]));
                player.getInventory().getArmor().setArmorName(infoArr[10]);
                player.getInventory().getArmor().setHealth(Integer.parseInt(infoArr[11]));
                player.getInventory().getPotion().setPotionName(infoArr[13]);
                player.getInventory().getPotion().setHealthBoost(Integer.parseInt(infoArr[14]));
            }
        }
        reader.close();
    }
    public void currentAccount(String username, String password, Player player) throws IOException {

        try {
            File temporaryFile = new File("src/SaveFiles/CurrentPlayer.txt");
            BufferedWriter buffwriter = new BufferedWriter(new FileWriter(temporaryFile.getAbsoluteFile()));
            buffwriter.write(
                    username + "|" +
                    password + "|" +
                    player.getPlayerName() + "|" +
                    player.getCoin() + "|" +
                    player.getClassName() + "|" +
                    player.getDamage() + "|" +
                    player.getHealth() + "|" +
                    player.getInventory().getWeapon().getWeaponName() + "|" +
                    player.getInventory().getWeapon().getDamage() + "|" +
                    player.getTotalDamage() + "|" +
                    player.getInventory().getArmor().getArmorName() +"|"+
                    player.getInventory().getArmor().getHealth() + "|" +
                    player.getTotalHealth() + "|" +
                    player.getInventory().getPotion().getPotionName() + "|" +
                    player.getInventory().getPotion().getHealthBoost());
            buffwriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void updateCurrentAccount(Player player){
        try {
            File temporaryFile = new File("src/SaveFiles/CurrentPlayer.txt");
            BufferedWriter buffwriter = new BufferedWriter(new FileWriter(temporaryFile.getAbsoluteFile()));
            buffwriter.write(
                    player.getUserName() + "|" +
                            player.getPassword() + "|" +
                            player.getPlayerName() + "|" +
                            player.getCoin() + "|" +
                            player.getClassName() + "|" +
                            player.getDamage() + "|" +
                            player.getHealth() + "|" +
                            player.getInventory().getWeapon().getWeaponName() + "|" +
                            player.getInventory().getWeapon().getDamage() + "|" +
                            player.getTotalDamage() + "|" +
                            player.getInventory().getArmor().getArmorName() +"|"+
                            player.getInventory().getArmor().getHealth() + "|" +
                            player.getTotalHealth() + "|" +
                            player.getInventory().getPotion().getPotionName() + "|" +
                            player.getInventory().getPotion().getHealthBoost());
            buffwriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void getCurrentAccount(Player player) throws IOException {
        File temporaryFile = new File("src/SaveFiles/CurrentPlayer.txt");
        BufferedReader reader = new BufferedReader(new FileReader(temporaryFile));
        String[] infoArr;
        String line;

        while((line = reader.readLine()) != null) {
            infoArr = line.split("\\|");
            player.setUserName(infoArr[0]);
            player.setPassword(infoArr[1]);
            player.setPlayerName(infoArr[2]);
            player.setCoin(Integer.parseInt(infoArr[3]));
            player.setClassName(infoArr[4]);
            player.setDamage(Integer.parseInt(infoArr[5]));
            player.setHealth(Integer.parseInt(infoArr[6]));
            player.getInventory().getWeapon().setWeaponName(infoArr[7]);
            player.getInventory().getWeapon().setDamage(Integer.parseInt(infoArr[8]));
            player.getInventory().getArmor().setArmorName(infoArr[10]);
            player.getInventory().getArmor().setHealth(Integer.parseInt(infoArr[11]));
            player.getInventory().getPotion().setPotionName(infoArr[13]);
            player.getInventory().getPotion().setHealthBoost(Integer.parseInt(infoArr[14]));
        }
    }
}
