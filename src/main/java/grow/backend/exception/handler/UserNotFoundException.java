package grow.backend.exception.handler;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String id) {
        super("User non trouvé avec l'id " + id);
    }
}