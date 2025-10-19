package grow.backend.exception.handler;

public class CampagneNotFoundException extends RuntimeException {
    public CampagneNotFoundException(String id) {
        super("Campagne non trouvée avec l'id " + id);
    }
}