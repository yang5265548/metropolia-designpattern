package flyweight;

public class RoadTile implements Tile {
    public void getDescription() {
        System.out.println("You are on a road tile.");
    }

    public String getCharacter() {
        return "R";
    }

    public void action() {
        System.out.println("You are on a road tile. You can move to the next tile.");
    }
    public String getTileType() {
        return "Road";
    }
}
