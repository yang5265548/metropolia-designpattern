package visitor;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor{
    private String searchString;
    private List<File> foundFiles= new ArrayList<>();
    public SearchVisitor(String searchString) {
        this.searchString = searchString;
    }

    @Override
    public void visit(File file) {
      if(file.getName().contains(searchString)){
            foundFiles.add(file);
      }
    }

    @Override
    public void visit(Directory directory) {

    }

    public List<File> getFoundFiles() {
        return foundFiles;
    }
}
