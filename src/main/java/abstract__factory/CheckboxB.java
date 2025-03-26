package abstract__factory;

public class CheckboxB extends Checkbox{
    public CheckboxB(String text) {
        super(text);
    }
    @Override
    public void display() {
        System.out.println("***************");
        System.out.printf("*  %s  *\n", text);
        System.out.println("***************");
    }
}
