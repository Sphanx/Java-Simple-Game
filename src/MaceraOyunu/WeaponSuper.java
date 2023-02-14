package MaceraOyunu;

public class WeaponSuper {
    private String weaponName;
    private int damage;
    private final int price;
    private int weaponID;

    public int getWeaponID() {
        return weaponID;
    }

    public void setWeaponID(int weaponID) {
        this.weaponID = weaponID;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }



    public WeaponSuper(String weaponName, int damage, int price, int weaponID) {
        this.weaponName = weaponName;
        this.damage = damage;
        this.price = price;
        this.weaponID = weaponID;
    }


}
