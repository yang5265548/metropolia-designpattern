package mediator;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import java.util.*;

public class ChatClientController {
    private String username;
    private ChatMediator mediator;
    private String currentRecipient;

    @FXML private ListView<String> userListView;
    @FXML private VBox messageContainer;
    @FXML private TextField messageField;
    @FXML private ScrollPane scrollPane;

    private final Map<String, Boolean> unreadMap = new HashMap<>();
    private boolean initialSelectionDone = false;

    public void initializeClient(String username, ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
        mediator.registerClient(username, this);

        userListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                currentRecipient = cleanName(newVal);
                refreshChat(currentRecipient);
                unreadMap.put(currentRecipient, false);
                refreshUserList(mediator.getAllUsernames());
            }
        });

        messageField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                onSendMessage();
            }
        });

        Platform.runLater(() -> {
            if (!userListView.getItems().isEmpty() && !initialSelectionDone) {
                userListView.getSelectionModel().selectFirst();
                initialSelectionDone = true;
            }
        });
    }

    public void refreshUserList(Set<String> usernames) {
        Platform.runLater(() -> {
            String selected = userListView.getSelectionModel().getSelectedItem();
            List<String> displayList = new ArrayList<>();
            for (String name : usernames) {
                if (!name.equals(username)) {
                    if (Boolean.TRUE.equals(unreadMap.get(name))) {
                        displayList.add(name + " (new)");
                    } else {
                        displayList.add(name);
                    }
                }
            }
            userListView.getItems().setAll(displayList);
            if (selected != null && displayList.contains(selected)) {
                userListView.getSelectionModel().select(selected);
            }
        });
    }

    public void refreshChat(String withUser) {
        Platform.runLater(() -> {
            List<HBox> history = mediator.getChatHistory(username, withUser);
            messageContainer.getChildren().setAll(history);
            scrollToBottom();
        });
    }

    public void markUnread(String from) {
        if (!from.equals(currentRecipient)) {
            unreadMap.put(from, true);
            refreshUserList(mediator.getAllUsernames());
        }
    }

    @FXML
    private void onSendMessage() {
        String message = messageField.getText();
        if (currentRecipient != null && !message.isEmpty()) {
            mediator.sendMessage(username, cleanName(currentRecipient), message);
            messageField.clear();
            refreshChat(currentRecipient);
        }
    }

    private String cleanName(String name) {
        return name.replace(" (new)", "");
    }

    private void scrollToBottom() {
        Platform.runLater(() -> scrollPane.setVvalue(1.0));
    }
}