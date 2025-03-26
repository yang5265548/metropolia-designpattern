package abstract__factory;

public abstract class  TextField {
    public String text;

    public void setText(String text) {
        this.text = text;
    }

    public TextField(String text) {
        this.text = text;
    }
    public abstract void display();
}
