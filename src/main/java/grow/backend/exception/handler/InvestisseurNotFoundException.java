package grow.backend.exception.handler;

public class InvestisseurNotFoundException extends RuntimeException {
    public InvestisseurNotFoundException(Long id) {
        super("Investisseur non trouvé avec l'id " + id);
    }
}
