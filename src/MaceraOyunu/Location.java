package MaceraOyunu;

public abstract class Location {
    Player player;
    String name;

    public Location(Player player, String name) {
        this.player = player;
        this.name = name;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
