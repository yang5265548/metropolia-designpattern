package flyweight;

import javafx.scene.image.Image;

import java.util.HashMap;

public class TileGraphicFactory {
    private static final TileGraphicFactory instance = new TileGraphicFactory();

    private HashMap<String, Image> tileImages=new HashMap<>();

    private TileGraphicFactory(){
        loadImages();
    }

    public static TileGraphicFactory getInstance() {
        return instance;
    }

    private void loadImages() {
        tileImages.put("Forest", new Image(getClass().getResourceAsStream("/images/forest.png")));
        tileImages.put("Water", new Image(getClass().getResourceAsStream("/images/water.png")));
        tileImages.put("Road", new Image(getClass().getResourceAsStream("/images/road.png")));
        tileImages.put("Building", new Image(getClass().getResourceAsStream("/images/building.png")));
        tileImages.put("Swamp", new Image(getClass().getResourceAsStream("/images/zhaoze.png")));
        // Add more images as needed
    }

    public Image getTileImage(String tileType) {
        return tileImages.get(tileType);
    }
}
