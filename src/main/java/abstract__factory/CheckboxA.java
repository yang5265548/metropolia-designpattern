package abstract__factory;

public class CheckboxA extends Checkbox{
    public CheckboxA(String text) {
        super(text);
    }
    @Override
    public void display() {
        System.out.println("~~~~~~~~~~~~~~~~");
        System.out.printf("|  %s   |\n", text);
        System.out.println("~~~~~~~~~~~~~~~~");
    }
}
