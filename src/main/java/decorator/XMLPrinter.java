package decorator;

public class XMLPrinter extends PrintDecorator{
    public XMLPrinter(BasicPrinter printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        String xmlMessage=convertToXML(message);
        super.print(xmlMessage);
    }

    public String convertToXML(String message) {
        String xmlMessage="<message>"+message+"</message>";
        return xmlMessage;
    }
}
