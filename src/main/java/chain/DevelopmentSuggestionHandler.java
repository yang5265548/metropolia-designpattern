package chain;

public class DevelopmentSuggestionHandler extends FeedbackHandler{
    @Override
    protected boolean process(Message message) {
        if (message.getType() == MessageType.DEVELOPMENT_SUGGESTION) {
            System.out.println("DevelopmentSuggestionHandler: Logging suggestion from " + message.getSenderEmail());
            System.out.println("Suggestion content: " + message.getContent());
            System.out.println("Result: Logged for future review.\n");
            return true;
        }
        return false;
    }
}
