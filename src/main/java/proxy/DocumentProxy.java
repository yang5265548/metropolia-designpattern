package proxy;


public class DocumentProxy implements Documents{
    private final String id;
    private final Document realDocument;

    public DocumentProxy(Document realDocument) {
        this.id = realDocument.getDocumentId();
        this.realDocument = realDocument;
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        if(AccessControlService.getInstance().isAllowed(id,user.getUserName())){
            return realDocument.getContent(user);
        }else {
            throw new AccessDeniedException("Access denied to doucment with id: " + id);
        }

    }



    @Override
    public String getCreationDate() {
        return realDocument.getCreationDate();
    }
}
