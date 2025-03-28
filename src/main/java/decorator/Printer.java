package decorator;

public class Printer implements BasicPrinter{

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
