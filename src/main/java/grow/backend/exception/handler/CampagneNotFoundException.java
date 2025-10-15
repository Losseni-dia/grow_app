package grow.backend.exception.handler;

public class CampagneNotFoundException extends RuntimeException {
    public CampagneNotFoundException(Long id) {
        super("Campagne non trouvée avec l'id " + id);
    }
}