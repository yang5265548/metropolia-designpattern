package proxy;

import java.util.HashSet;
import java.util.Set;

public class AccessControlService {
    private static final AccessControlService instance = new AccessControlService();
    private final Set<String> allowedPairs=new HashSet<>();
    private AccessControlService() {
        // Private constructor to prevent instantiation
    }
    public static AccessControlService getInstance() {
        return instance;
    }

    public void allowAccess(String userName, String documentId) {
        allowedPairs.add(userName + ":" + documentId);
    }

    public boolean isAllowed(String documentId, String userName) {
        return allowedPairs.contains(userName + ":" + documentId);
    }

}
