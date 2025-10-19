package grow.backend.exception.handler;

public class InvestissementNotFoundException extends RuntimeException {
    public InvestissementNotFoundException(String id) {
        super("Investissement non trouvé avec l'id " + id);
    }
}