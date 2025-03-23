package factory;

public class WildernessMap extends Map {
    public WildernessMap(int rows, int cols) {
        super(rows, cols);
    }

    public Tile createTile() {
        int num = (int)(Math.random() * 3);
        if (num == 0) {
            return new SwampTile();
        } else if (num == 1) {
            return new ForesTile();
        } else {
            return new WaterTile();
        }
    }
}
