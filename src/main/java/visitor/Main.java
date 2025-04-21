package visitor;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory docs = new Directory("docs");
        Directory images = new Directory("images");

        File f1 = new File("resume.docx", 2);
        File f2 = new File("coverletter.docx", 1);
        File f3 = new File("vacation.jpg", 5);
        File f4 = new File("notes.txt", 1);

        docs.addElement(f1);
        docs.addElement(f2);
        images.addElement(f3);
        root.addElement(docs);
        root.addElement(images);
        root.addElement(f4);

        // Total size visitor
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total file size: " + sizeVisitor.getTotalSize() + " MB");

        // Search visitor
        SearchVisitor searchVisitor = new SearchVisitor("docx");
        root.accept(searchVisitor);
        System.out.println("Matched files:");
        for (File f : searchVisitor.getFoundFiles()) {
            System.out.println("- " + f.getName());
        }
    }
}
