package MaceraOyunu;

public class ArmorSuper {
    int health;
    String armorName;
    int price;
    int armorID;

    public ArmorSuper(String armorName, int health, int price, int armorID){
        this.health = health;
        this.armorName = armorName;
        this.price = price;
        this.armorID = armorID;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getPrice() {
        return price;
    }

}
