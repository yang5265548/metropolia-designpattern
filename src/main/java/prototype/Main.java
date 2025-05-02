package prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Recommendation> recommendations=new ArrayList<>();
        Recommendation clonedRecommendation=null;


        Book book1=new Book("The Great Gatsby","F. Scott Fitzgerald");
        Book book2=new Book("To Kill a Mockingbird","Harper Lee");
        Book book3=new Book("1984","George Orwell");
        Book book4=new Book("The Catcher in the Rye","J.D. Salinger");
        Book book5=new Book("The Hobbit","J.R.R. Tolkien");
        Book book6=new Book("Harry Potter and the Sorcerer's Stone","J.K. Rowling");
        Book book7=new Book("The Lord of the Rings","J.R.R. Tolkien");
        Book book8=new Book("The Alchemist","Paulo Coelho");
        Book book9=new Book("The Da Vinci Code","Dan Brown");
        Book book10=new Book("The Hunger Games","Suzanne Collins");

        Recommendation recommendation1=new Recommendation(Audience.TEEN,"for Teens");
        recommendation1.addBook(book1);
        recommendation1.addBook(book2);
        recommendation1.addBook(book3);
        recommendation1.addBook(book4);

        Recommendation recommendation2=new Recommendation(Audience.ADULT,"for Adults");
        recommendation2.addBook(book5);
        recommendation2.addBook(book6);
        recommendation2.addBook(book7);

        Recommendation recommendation3=new Recommendation(Audience.CHILDREN,"for Children");
        recommendation3.addBook(book8);
        recommendation3.addBook(book9);
        recommendation3.addBook(book10);

        recommendations.add(recommendation1);
        recommendations.add(recommendation2);
        recommendations.add(recommendation3);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the menu:");
        System.out.println("1.Show all recommendations");
        System.out.println("2.Clone a recommendation");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                int i=1;
                for (Recommendation re: recommendations) {
                    System.out.println("Recommendation"+i+": " + re.getDescription());
                    re.getTargetAudience();
                    System.out.println("Books:");
                    for (Book book : re.getRecommendedBooks()) {
                        System.out.println(book);
                    }
                    i++;
                }
                break;
            case 2:
                System.out.println("Enter the index of the recommendation to clone :");
                System.out.println("1-"+recommendations.size());
                int index = scanner.nextInt();
                if (index <1 || index > recommendations.size()) {
                    System.out.println("Invalid index");
                    return;
                } else {
                    clonedRecommendation = recommendations.get(index-1).clone();

                    System.out.println("You have cloned the recommendation");
                }
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        if (choice==2){
            boolean flag=true;
            while (flag){
                System.out.println("You can do next operation");
                System.out.println("1.Add a book to the clone recommendation");
                System.out.println("2.Remove a book from the clone recommendation");
                System.out.println("3.Change the target audience of the clone recommendation");
                System.out.println("4.Save the clone recommendation");
                int operation = 0;
                try {
                    operation = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear the invalid input
                }
                switch (operation){
                    case 1:
                        System.out.println("Enter the book name to add:");
                        String bookNameToAdd = scanner.next();
                        Book newBook = new Book(bookNameToAdd,"Unknown");
                        clonedRecommendation.addBook(newBook);
                        System.out.println("Book added to the clone recommendation");
                        break;
                    case 2:
                        System.out.println("Enter the book name to remove:");
                        String bookNameToRemove = scanner.next();
                        Book bookToRemove = null;
                        for (Book book : clonedRecommendation.getRecommendedBooks()) {
                            if (book.getTitle().equals(bookNameToRemove)) {
                                bookToRemove = book;
                                break;
                            }
                        }
                        if (bookToRemove != null) {
                            clonedRecommendation.removeBook(bookToRemove);
                            System.out.println("Book removed from the clone recommendation");
                        } else {
                            System.out.println("Book not found in the clone recommendation");
                        }
                        break;
                    case 3:
                        System.out.println("Enter the new target audience:");
                        System.out.println("1.TEEN");
                        System.out.println("2.ADULT");
                        System.out.println("3.CHILDREN");
                        System.out.println("4.FAMILY");
                        System.out.println("5.ALL");

                        int audienceChoice=scanner.nextInt();
                        switch (audienceChoice){
                            case 1:
                                clonedRecommendation.setTargetAudience(Audience.TEEN);
                                break;
                            case 2:
                                clonedRecommendation.setTargetAudience(Audience.ADULT);
                                break;
                            case 3:
                                clonedRecommendation.setTargetAudience(Audience.CHILDREN);
                                break;
                            case 4:
                                clonedRecommendation.setTargetAudience(Audience.FAMILY);
                                break;
                            case 5:
                                clonedRecommendation.setTargetAudience(Audience.ALL);
                                break;
                            default:
                                System.out.println("Invalid choice");
                        }
                        System.out.println("Target audience chang to: ");
                        clonedRecommendation.getTargetAudience();
                        break;
                    case 4:
                        recommendations.add(clonedRecommendation);
                        System.out.println("Clone recommendation saved");
                        flag=false;
                    default:
                        break;
                }
            }

        }


    }
}
