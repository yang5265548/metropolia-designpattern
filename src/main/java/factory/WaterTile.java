package factory;

public class WaterTile implements Tile {
    public void getDescription() {
        System.out.println("You are swimming in the water.");
    }

    public String getCharacter() {
        return "W";
    }

    public void action() {
        System.out.println("You are swimming.");
    }
}
