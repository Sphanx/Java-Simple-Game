package MaceraOyunu;

public class Inventory {

    public WeaponSuper weapon;
    public ArmorSuper armor;
    public PotionSuper potion;

    public ArmorSuper getArmor() {
        return armor;
    }

    public void setArmor(ArmorSuper armor) {
        this.armor = armor;
    }

    public PotionSuper getPotion() {
        return potion;
    }

    public void setPotion(PotionSuper potion) {
        this.potion = potion;
    }

    public WeaponSuper getWeapon() {
        return weapon;
    }

    public void setWeapon(WeaponSuper weapon) {
        this.weapon = weapon;
    }
    public Inventory(){
        this.weapon = new WeaponSuper("Yumruk", 0 , 0 ,0);
        this.armor = new ArmorSuper("Gündelik kıyafet", 5, 0, 0);
        this.potion = new PotionSuper("İksir Yok", 0, 0, 0);
    }
}
