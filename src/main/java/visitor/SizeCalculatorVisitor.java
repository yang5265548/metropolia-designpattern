package visitor;

public class SizeCalculatorVisitor implements FileSystemVisitor{
    private int totalSize = 0;
    @Override
    public void visit(File file) {
        totalSize+= file.getSize();
    }
    @Override
    public void visit(Directory directory) {

    }
    public int getTotalSize() {
        return totalSize;
    }
}
