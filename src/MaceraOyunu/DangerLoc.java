package MaceraOyunu;

import java.util.Random;

public abstract class DangerLoc extends Location{
    private Enemy enemy;
    private String award;
    private String name;
    int totalHealth = player.getTotalHealth();

    public int getTotalHealth() {
        return totalHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public DangerLoc(Player player, String name, Enemy enemy, String award){
        super(player, name);
        this.enemy = enemy;
        this.award = award;
        this.name = name;
    }
    public boolean drinkPotion(){
        if(player.getInventory().getPotion().getPotionName().equals("İksir Yok")){
            return false;
        }else{
            totalHealth += player.getInventory().getPotion().getHealthBoost();
            if(totalHealth >= player.getTotalHealth()){
                totalHealth = player.getTotalHealth();
            }
            player.getInventory().getPotion().setPotionName("İksir Yok");
        }
        return true;
    }
    public void run(){
        player.setCoin(player.getCoin() - 10);
        if(player.getCoin() <=0 ) {
            player.setCoin(0);
        }
    }

    public int playerAttack(){
        Random rollDamage1 = new Random();
        int myDamage = rollDamage1.nextInt(0, player.getTotalDamage()+1);
        enemy.setHealth(enemy.getHealth() - myDamage);
        return myDamage;
    }
    public int enemyAttack(){
        Random rollDamage2 = new Random();
        int enemyDamage = rollDamage2.nextInt(0, enemy.getDamage()+1);
        totalHealth -= enemyDamage;
        return enemyDamage;
    }
    public boolean isPlayerDead(){
        if(totalHealth<=0){
            player.setCoin(player.getCoin()-10);
            if(player.getCoin() <= 0){
                player.setCoin(0);
            }
            return true;
        }
        return false;
    }
    public boolean isEnemyDead(){
        if(enemy.getHealth()<=0){
            player.setCoin(player.getCoin()+enemy.getCoin());
            return true;
        }
        return false;
    }
    public void newEnemy() {
        if(this.enemy instanceof Wolf){
            enemy.setHealth(new Wolf().getHealth());
            enemy.setCoin(enemy.getCoin() + 2);
            enemy.setDamage(enemy.getDamage() +1);
        }else if(this.enemy instanceof Skeleton){
            enemy.setHealth(new Skeleton().getHealth());
            enemy.setCoin(enemy.getCoin() + 4);
            enemy.setDamage(enemy.getDamage() +1);
        }else if(this.enemy instanceof Goblin){
            enemy.setHealth(new Goblin().getHealth());
            enemy.setCoin(enemy.getCoin() + 5);
            enemy.setDamage(enemy.getDamage() +1);
        }
    }
}
