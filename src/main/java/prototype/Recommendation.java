package prototype;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable{
    private Audience targetAudience;
    private List<Book> recommendedBooks;
    private String description;

    public void addBook(Book book){
        recommendedBooks.add(book);
    }

    public void removeBook(Book book){
        recommendedBooks.remove(book);
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }

    public void getTargetAudience(){
        System.out.println("Target Audience: " + targetAudience);
    }

    public void setTargetAudience(Audience NewTargetAudience){
        this.targetAudience=NewTargetAudience;
    }

    public Recommendation(Audience targetAudience, String description) {
        this.targetAudience = targetAudience;
        this.description = description;
        this.recommendedBooks = new ArrayList<>();
    }

    public List<Book> getRecommendedBooks() {
        return recommendedBooks;
    }

    public Recommendation clone(){
        try {
            Recommendation clonedRecommendation = (Recommendation) super.clone();

            // Deep copy of the recommendedBooks list
            clonedRecommendation.recommendedBooks = new ArrayList<>();
            for (Book book : this.recommendedBooks) {
                clonedRecommendation.recommendedBooks.add(book.clone());
            }

            return clonedRecommendation;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }
}
