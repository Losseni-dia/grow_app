package grow.backend.exception.handler;

public class InvestissementNotFoundException extends RuntimeException {
    public InvestissementNotFoundException(Long id) {
        super("Investissement non trouvé avec l'id " + id);
    }
}