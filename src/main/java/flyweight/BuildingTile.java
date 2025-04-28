package flyweight;

public class BuildingTile implements Tile {
    public void getDescription() {
        System.out.println("This is a building tile.");
    }

    public String getCharacter() {
        return "B";
    }

    public void action() {
        System.out.println("You have entered a building.");
    }
    public String getTileType() {
        return "Building";
    }
}
