package grow.backend.exception.handler;

public class PorteurProjetNotFoundException extends RuntimeException {
    public PorteurProjetNotFoundException(Long id) {
        super("PorteurProjet non trouvé avec l'id " + id);
    }
}