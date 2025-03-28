package decorator;

public class Main {
    public static void main(String[] args) {
        BasicPrinter printer= new Printer();
        printer.print("hello world");

        BasicPrinter printer2=new XMLPrinter(new Printer());
        printer2.print("hello world");

        BasicPrinter printer1=new EncryptedPrinter(new XMLPrinter(new Printer()));

        printer1.print("hello world");

        BasicPrinter printer3=new XMLPrinter(new EncryptedPrinter(new Printer()));
        printer3.print("hello world");

        BasicPrinter printer4=new EncryptedPrinter(new XMLPrinter(new EncryptedPrinter(new Printer())));
        printer4.print("hello world");
    }
}
