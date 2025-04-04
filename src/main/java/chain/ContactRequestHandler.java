package chain;

public class ContactRequestHandler extends FeedbackHandler {
    @Override
    protected boolean process(Message message) {
        if (message.getType() == MessageType.CONTACT_REQUEST) {
            System.out.println("ContactRequestHandler: Forwarding contact request from " + message.getSenderEmail());
            System.out.println("Request content: " + message.getContent());
            System.out.println("Result: Forwarded to customer service.\n");
            return true;
        }
        return false;
    }
}
