package abstract__factory;

public class TextFieldB extends TextField{
    public TextFieldB(String text) {
        super(text);
    }
    @Override
    public void display() {
        System.out.println("***************");
        System.out.printf("* %s  *\n", text);
        System.out.println("***************");
    }
}
