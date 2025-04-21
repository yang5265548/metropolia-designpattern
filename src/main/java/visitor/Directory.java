package visitor;

import java.util.ArrayList;

public class Directory implements FileSystemElement{
    private String name;
    private int size;
    private ArrayList<FileSystemElement> elements= new ArrayList<>();

    public Directory(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public ArrayList<FileSystemElement> getElements() {
        return elements;
    }
    public void setElements(ArrayList<FileSystemElement> elements) {
        this.elements = elements;
    }
    public void addElement(FileSystemElement element) {
        elements.add(element);
    }
    public void removeElement(FileSystemElement element) {
        elements.remove(element);
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
        for (FileSystemElement element : elements) {
            element.accept(visitor);
        }
    }
}
