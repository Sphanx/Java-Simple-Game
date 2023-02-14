package MaceraOyunu;

import java.util.Scanner;

public class Player {

    private Inventory inventory;
    private int damage;
    private int health;
    private int coin;
    private String playerName;
    private String className;
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    Scanner scanner = new Scanner(System.in);

    public Player(){
        this.inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    public int getTotalDamage(){
        return this.getDamage() + this.getInventory().getWeapon().getDamage();
    }
    public int getTotalHealth(){
        return this.getHealth() + this.getInventory().getArmor().getHealth();
    }


}
