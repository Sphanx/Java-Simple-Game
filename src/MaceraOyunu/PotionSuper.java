package MaceraOyunu;

public class PotionSuper {
    String potionName;
    int healthBoost;
    int potionID;
    int price;

    public String getPotionName() {
        return potionName;
    }

    public void setPotionName(String potionName) {
        this.potionName = potionName;
    }

    public int getHealthBoost() {
        return healthBoost;
    }

    public void setHealthBoost(int healthBoost) {
        this.healthBoost = healthBoost;
    }
    public int getPrice() {
        return price;
    }
    public PotionSuper(String potionName, int healthBoost, int potionID, int price){
        this.potionID = potionID;
        this.potionName = potionName;
        this.price = price;
        this.healthBoost = healthBoost;
    }










}
