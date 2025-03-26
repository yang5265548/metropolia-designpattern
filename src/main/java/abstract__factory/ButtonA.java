package abstract__factory;

public class ButtonA extends  Button{
    public ButtonA(String text) {
        super(text);
    }
    @Override
    public void display() {
        System.out.println("~~~~~~~~~~~~~~~");
        System.out.printf("|   %s   |\n", text);
        System.out.println("~~~~~~~~~~~~~~~");

    }
}
