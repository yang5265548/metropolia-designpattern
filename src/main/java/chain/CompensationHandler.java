package chain;

public class CompensationHandler extends FeedbackHandler{
    @Override
    public boolean process(Message message) {
        if (message.getType()==MessageType.COMPENSATION) {
            System.out.println("Compensation Handler: Processing compensation request from " + message.getSenderEmail());
            System.out.println("Claim: " + message.getContent());
            System.out.println("Result: Compensation request processed successfully.\n");
            return true;
        }
        return false;
    }
}
