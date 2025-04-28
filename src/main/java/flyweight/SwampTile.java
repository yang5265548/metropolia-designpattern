package flyweight;

public class SwampTile implements Tile {
    public void getDescription() {
        System.out.println("You are in a swamp.");
    }

    public String getCharacter() {
        return "S";
    }

    public void action() {
        System.out.println("You are attacked by a swamp monster!");
    }
    public String getTileType() {
        return "Swamp";
    }
}
