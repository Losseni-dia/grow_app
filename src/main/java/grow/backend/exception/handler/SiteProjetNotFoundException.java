package grow.backend.exception.handler;

public class SiteProjetNotFoundException extends RuntimeException {
    public SiteProjetNotFoundException(String id) {
        super("SiteProjet non trouvé avec l'id " + id);
    }
}