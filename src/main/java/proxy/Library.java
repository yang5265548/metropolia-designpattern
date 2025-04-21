package proxy;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private final Map<String,Documents> documents=new HashMap<>();
    public void addUnprotectedDocument(Document document) {
        documents.put(document.getDocumentId(), document);
    }

    public void addProtectedDocument(Document document, List<User> allowedUsers) {
        for (User user: allowedUsers) {
            AccessControlService.getInstance().allowAccess(user.getUserName(),document.getDocumentId() );
        }
        DocumentProxy documentProxy = new DocumentProxy(document);
        documents.put(document.getDocumentId(), documentProxy);
    }

    public Documents getDocument(String documentId) {
        return documents.get(documentId);
    }
}
