package proxy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User kobe= new User("Kobe");
        User lebron= new User("Lebron");

        Library library = new Library();
        Document document1=new Document("doc1","This is a public document");
        Document document2=new Document("doc2","This is a private document");

        library.addUnprotectedDocument(document1);
        library.addProtectedDocument(document2, List.of(kobe));

        System.out.println("Accessing public doucment");
        System.out.println(document1.getContent(lebron));

        System.out.println("Accessing private doucment with kobe");
        try {
            System.out.println(library.getDocument("doc2").getContent(kobe));
        } catch (AccessDeniedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Accessing private doucment with lebron");
        try {
            System.out.println(library.getDocument("doc2").getContent(lebron));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}
