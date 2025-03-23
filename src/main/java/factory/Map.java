package factory;

public abstract class Map {
    Tile[][] tiles;
    int rows;
    int cols;

    public Map(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        tiles = new Tile[rows][cols];
        generateMap();
    }

    public void generateMap() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tiles[i][j] = createTile();
            }
        }
    }

    public abstract Tile createTile();
    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(tiles[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    }
}
