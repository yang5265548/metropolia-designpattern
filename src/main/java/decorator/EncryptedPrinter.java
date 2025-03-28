package decorator;

public class EncryptedPrinter extends PrintDecorator{
    public EncryptedPrinter(BasicPrinter printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
       String encryptMessage=encrypt(message);
        super.print(encryptMessage);
    }

    public String encrypt(String message) {
        message=message+" Encrypted";
        return message;
    }
}
