package chain;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FeedbackHandler compensation = new CompensationHandler();
        FeedbackHandler contact = new ContactRequestHandler();
        FeedbackHandler suggestion = new DevelopmentSuggestionHandler();
        FeedbackHandler general = new GeneralFeedbackHandler();

        compensation.setNextHandler(contact);
        contact.setNextHandler(suggestion);
        suggestion.setNextHandler(general);


        List<Message> messages = Arrays.asList(
                new Message(MessageType.COMPENSATION, "I want a refund for my last order.", "alice@example.com"),
                new Message(MessageType.CONTACT_REQUEST, "Can I speak with a manager?", "bob@example.com"),
                new Message(MessageType.DEVELOPMENT_SUGGESTION, "Please add dark mode.", "carol@example.com"),
                new Message(MessageType.GENERAL_FEEDBACK, "Great service!", "dave@example.com")
        );

        for (Message message : messages) {
            compensation.handle(message);
        }
    }
}
