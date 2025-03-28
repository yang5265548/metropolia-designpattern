package decorator;

public abstract class PrintDecorator implements BasicPrinter{
    private BasicPrinter printer;

    public PrintDecorator(BasicPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void print(String message) {
        printer.print(message);
    }
}
