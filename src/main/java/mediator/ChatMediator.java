package mediator;

import javafx.scene.layout.HBox;

import java.util.List;
import java.util.Set;

public interface ChatMediator {
    void registerClient(String username, ChatClientController client);
    void sendMessage(String from, String to, String message);
    Set<String> getAllUsernames();
    void updateUserLists();
    List<HBox> getChatHistory(String user1, String user2);
    HBox createMessageBox(String from, String viewer, String message);
}