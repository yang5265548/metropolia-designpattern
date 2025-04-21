package proxy;

public interface Documents {
    String getContent(User user) throws AccessDeniedException;
    String getCreationDate();
}
