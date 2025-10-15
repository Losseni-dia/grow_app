package grow.backend.exception.handler;

public class ProjetNotFoundException extends RuntimeException {
    public ProjetNotFoundException(Long id) {
        super("Projet non trouvé avec l'id " + id);
    }
}