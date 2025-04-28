package flyweight;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Random;

public  class Map {
    private final int width;
    private final int height;
    private final Tile[][] tiles;
    private final Random random = new Random();

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];

        generateRandomMap();
    }

    private void generateRandomMap() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int r = random.nextInt(5); // 0, 1, 2
                switch (r) {
                    case 0 -> tiles[x][y] = new ForesTile();
                    case 1 -> tiles[x][y] = new WaterTile();
                    case 2 -> tiles[x][y] = new RoadTile();
                    case 3 -> tiles[x][y] = new BuildingTile();
                    case 4 -> tiles[x][y] = new SwampTile();
                }
            }
        }
    }

    public void render(GraphicsContext gc) {
        TileGraphicFactory graphicFactory = TileGraphicFactory.getInstance();
        int tileSize = 32; // 每个瓦片的大小（像素）

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Tile tile = tiles[x][y];
                Image image = graphicFactory.getTileImage(tile.getTileType());
                if (image != null) {
                    gc.drawImage(image, x * tileSize, y * tileSize, tileSize, tileSize);
                }
            }
        }
    }
}
