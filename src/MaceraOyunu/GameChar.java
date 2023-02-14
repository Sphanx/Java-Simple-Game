package MaceraOyunu;

public class GameChar {
    private String name;
    private int id;
    private int damage;
    private int health;
    private int coin;

    public GameChar(String name, int id, int damage, int health, int coin) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.coin = coin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getCoin() {
        return coin;
    }
}
