package factory;

public class CityMap extends Map {
    public CityMap(int rows, int cols) {
        super(rows, cols);
    }

    @Override
    public Tile createTile() {
        int num = (int)(Math.random() * 3);
        if (num == 0) {
            return new RoadTile();
        } else if (num == 1) {
            return new ForesTile();
        } else {
            return new BuildingTile();
        }
    }


}
