package grow.backend.exception.handler;

public class PorteurProjetNotFoundException extends RuntimeException {
    public PorteurProjetNotFoundException(String id) {
        super("PorteurProjet non trouvé avec l'id " + id);
    }
}