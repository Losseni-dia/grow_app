package grow.backend.exception.handler;

public class SiteProjetNotFoundException extends RuntimeException {
    public SiteProjetNotFoundException(Long id) {
        super("SiteProjet non trouvé avec l'id " + id);
    }
}