package grow.backend.exception.handler;

public class DividendeNotFoundException extends RuntimeException {
    public DividendeNotFoundException(String id) {
        super("Dividende non trouvé avec l'id " + id);
    }
}
