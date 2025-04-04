package chain;

public class GeneralFeedbackHandler extends FeedbackHandler{
    @Override
    protected boolean process(Message message) {
        if (message.getType() == MessageType.GENERAL_FEEDBACK) {
            System.out.println("GeneralFeedbackHandler: Analyzing general feedback from " + message.getSenderEmail());
            System.out.println("Feedback content: " + message.getContent());
            System.out.println("Result: Thank you for your feedback.\n");
            return true;
        }
        return false;
    }
}
