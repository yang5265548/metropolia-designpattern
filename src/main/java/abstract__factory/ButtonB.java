package abstract__factory;

public class ButtonB extends Button{

    public ButtonB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("***************");
        System.out.printf("*   %s   *\n", text);
        System.out.println("***************");
    }
}
