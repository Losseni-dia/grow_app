package grow.backend.exception.handler;

public class LocaliteNotFoundException extends RuntimeException {
    public LocaliteNotFoundException(String id) {
        super("Localite non trouvé avec l'id " + id);
    }
    
}
