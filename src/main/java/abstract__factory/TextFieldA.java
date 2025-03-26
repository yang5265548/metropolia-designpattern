package abstract__factory;

public class TextFieldA extends TextField{
    public TextFieldA(String text) {
        super(text);
    }
    @Override
    public void display() {
        System.out.println("~~~~~~~~~~~~~~~~");
        System.out.printf("|  %s  |\n", text);
        System.out.println("~~~~~~~~~~~~~~~~");
    }
}
