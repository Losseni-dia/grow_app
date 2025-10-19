package grow.backend.exception.handler;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(String id) {
        super("Role non trouvé avec l'id " + id);
    }
    
}
