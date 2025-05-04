package command;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PixelArtEditorApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/PixelArtEditor.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Pixel Art Editor");
        stage.setScene(scene);
        stage.show();
    }
}
