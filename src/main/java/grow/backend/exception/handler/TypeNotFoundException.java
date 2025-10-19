package grow.backend.exception.handler;

public class TypeNotFoundException extends RuntimeException {
    public TypeNotFoundException(String id) {
        super("SiteProjet non trouvé avec l'id " + id);
    }
}
