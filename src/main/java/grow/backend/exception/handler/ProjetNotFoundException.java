package grow.backend.exception.handler;

public class ProjetNotFoundException extends RuntimeException {
    public ProjetNotFoundException(String id) {
        super("Projet non trouvé avec l'id " + id);
    }
}