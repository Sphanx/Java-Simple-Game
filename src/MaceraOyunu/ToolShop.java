package MaceraOyunu;

public class ToolShop extends  SafeLoc{
    public ToolShop(Player player) {
        super(player, "Mağaza");
    }


    public boolean buyPotion(PotionSuper potion){

        if(potion instanceof HealingPotion){
            if(potion.getPrice() > player.getCoin()) {
                return false;
            }else{//buying potion
                    int balance  = player.getCoin() - potion.getPrice();
                    player.setCoin(balance);
                    player.getInventory().setPotion(potion);
                }
        }//Second potion
        if(potion instanceof GhealingPotion){
            if(potion.getPrice() > player.getCoin()) {
                return false;
            }else{//buying potion
                int balance  = player.getCoin() - potion.getPrice();
                player.setCoin(balance);
                player.getInventory().setPotion(potion);
            }
        }
        return true;
    }



    public boolean buyWeapon(WeaponSuper weapon){
        //First weapon
        if(weapon instanceof Sword){
            if(weapon.getPrice() > getPlayer().getCoin()){
                return false;
            }else{//buying weapon
                int balance  = player.getCoin() - weapon.getPrice();
                player.setCoin(balance);
                player.getInventory().setWeapon(weapon);
            }
        }
        //Second weapon
        if(weapon instanceof Knife){
            if (weapon.getPrice() > getPlayer().getCoin()){
                return false;
            }else{//Buying weapon
                int balance  = player.getCoin() - weapon.getPrice();
                player.setCoin(balance);
                player.getInventory().setWeapon(weapon);
            }
        }
        //Third weapon
        if(weapon instanceof Bow){
            if (weapon.getPrice() > getPlayer().getCoin()){
                return false;
            }else{//Buying weapon
                int balance  = player.getCoin() - weapon.getPrice();
                player.setCoin(balance);
                player.getInventory().setWeapon(weapon);
            }
        }
        return true;
    }

    public boolean buyArmor(ArmorSuper armor){

        //First armor
        if(armor instanceof HeavyArmor){
            if(armor.getPrice() > getPlayer().getCoin()){
                return false;
            }else{//buying armor
                int balance  = player.getCoin() - armor.getPrice();
                player.setCoin(balance);
                player.getInventory().setArmor(armor);
            }
        }
        //Second armor
        if(armor instanceof LightArmor){
            if(armor.getPrice() > getPlayer().getCoin()){
                return false;
            }else{//buying armor
                int balance  = player.getCoin() - armor.getPrice();
                player.setCoin(balance);
                player.getInventory().setArmor(armor);
            }
        }

        return true;
    }


}
