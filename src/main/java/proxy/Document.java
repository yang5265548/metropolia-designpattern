package proxy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Document implements Documents{
    public final String documentId;
    public final Date creationDate;
    protected final String content;

    public Document(String documentId,  String content) {
        this.documentId = documentId;
        this.creationDate = new Date();
        this.content = content;
    }

    @Override
    public String getContent(User user) {
        return content;
    }
    public String getDocumentId() {
        return documentId;
    }

    @Override
    public String getCreationDate() {
        return new SimpleDateFormat("dd/MM/yyyy").format(creationDate);
    }
}
