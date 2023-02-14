package MaceraOyunu;

public class Enemy {
    private int ID;
    private int health;
    private int damage;
    private String name;
    private int coin;

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enemy(int ID, int health, int damage, String name, int coin) {
        this.ID = ID;
        this.health = health;
        this.damage = damage;
        this.name = name;
        this.coin = coin;
    }
}
