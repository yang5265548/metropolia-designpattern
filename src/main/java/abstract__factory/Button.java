package abstract__factory;

public abstract class Button {

    public String text;

    public void setText(String text) {
        this.text = text;
    }

    public Button(String text) {
        this.text = text;
    }

    public abstract void display();
}
