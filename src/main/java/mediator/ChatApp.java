package mediator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChatApp extends Application {
    private final ChatMediator mediator = new ChatMediatorImpl();

    @Override
    public void start(Stage primaryStage) throws Exception {
        launchClient("Alice");
        launchClient("Bob");
        launchClient("Charlie");
    }

    private void launchClient(String username) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ChatClientView.fxml"));
        Scene scene = new Scene(loader.load());
        ChatClientController controller = loader.getController();
        controller.initializeClient(username, mediator);

        Stage stage = new Stage();
        stage.setTitle("Chat - " + username);
        stage.setScene(scene);
        stage.show();
    }

}
