package mediator;
import java.util.*;

import javafx.scene.control.Label;
import javafx.scene.layout.*;
public class ChatMediatorImpl implements ChatMediator {
    private final Map<String, ChatClientController> clients = new HashMap<>();
    private final Map<String, List<Message>> historyMap = new HashMap<>();

    @Override
    public void registerClient(String username, ChatClientController client) {
        clients.put(username, client);
        updateUserLists();
    }

    @Override
    public void sendMessage(String from, String to, String message) {
        String key = makeKey(from, to);
        historyMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new Message(from, message));
        ChatClientController recipient = clients.get(to);
        if (recipient != null) {
            recipient.markUnread(from);
            recipient.refreshChat(from);
        }
    }

    @Override
    public List<HBox> getChatHistory(String user1, String user2) {
        String key = makeKey(user1, user2);
        List<HBox> visual = new ArrayList<>();
        List<Message> raw = historyMap.getOrDefault(key, new ArrayList<>());
        for (Message msg : raw) {
            visual.add(createMessageBox(msg.sender, user1, msg.content));
        }
        return visual;
    }

    private String makeKey(String u1, String u2) {
        return u1.compareTo(u2) < 0 ? u1 + "|" + u2 : u2 + "|" + u1;
    }

    @Override
    public HBox createMessageBox(String from, String viewer, String message) {
        boolean isSelf = from.equals(viewer);
        Label label = new Label((isSelf ? "You: " : from + ": ") + message);
        label.setStyle("-fx-background-color: " + (isSelf ? "#A0C4FF" : "#C2F5A7") + "; -fx-padding: 8px; -fx-border-radius: 5px; -fx-background-radius: 5px;");

        HBox hbox = new HBox();
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        if (isSelf) {
            hbox.getChildren().addAll(spacer, label);
        } else {
            hbox.getChildren().addAll(label, spacer);
        }
        return hbox;
    }

    @Override
    public void updateUserLists() {
        for (ChatClientController controller : clients.values()) {
            controller.refreshUserList(getAllUsernames());
        }
    }

    @Override
    public Set<String> getAllUsernames() {
        return clients.keySet();
    }

    private static class Message {
        String sender;
        String content;
        Message(String sender, String content) {
            this.sender = sender;
            this.content = content;
        }
    }
}