package flyweight;

public class ForesTile implements Tile {
    public void getDescription() {
        System.out.println("You are in the forest.");
    }

    public String getCharacter() {
        return "F";
    }

    public void action() {
        System.out.println("You are attacked by a wolf.");
    }
    public String getTileType() {
        return "Forest";
    }
}
