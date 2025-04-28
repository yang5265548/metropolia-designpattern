package flyweight;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Game extends Application {
    private static final int MAP_WIDTH = 20; // 地图宽 20格
    private static final int MAP_HEIGHT = 15; // 地图高 15格
    private static final int TILE_SIZE = 32; // 每个格子32像素

    @Override
    public void start(Stage primaryStage) {
        Map map = new Map(MAP_WIDTH, MAP_HEIGHT);

        Canvas canvas = new Canvas(MAP_WIDTH * TILE_SIZE, MAP_HEIGHT * TILE_SIZE);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        map.render(gc);

        StackPane root = new StackPane();
        root.getChildren().add(canvas);

        Scene scene = new Scene(root);
        primaryStage.setTitle("RPG Map with Flyweight Rendering");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
