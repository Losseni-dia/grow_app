package grow.backend.exception.handler;

public class PaysNotFoundException extends RuntimeException {
    public PaysNotFoundException(String id) {
        super("Pays non trouvé avec l'id " + id);
    }
    
}
