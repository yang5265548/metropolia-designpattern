package chain;

public abstract class FeedbackHandler {
    protected FeedbackHandler nextHandler;

    public void setNextHandler(FeedbackHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public  void handle(Message message){
        if(!process(message)&& nextHandler!=null){
            nextHandler.handle(message);
        }
    };
    protected abstract boolean process(Message message);
}
