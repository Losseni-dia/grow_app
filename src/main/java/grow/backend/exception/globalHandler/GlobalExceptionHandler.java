package grow.backend.exception.globalHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.servlet.http.HttpServletRequest;

import grow.backend.exception.errorResponse.ErrorResponse;
import grow.backend.exception.handler.DividendeNotFoundException;
import grow.backend.exception.handler.InvestissementNotFoundException;
import grow.backend.exception.handler.InvestisseurNotFoundException;
import grow.backend.exception.handler.PorteurProjetNotFoundException;
import grow.backend.exception.handler.ProjetNotFoundException;
import grow.backend.exception.handler.SiteProjetNotFoundException;
import grow.backend.exception.handler.UserNotFoundException;
import grow.backend.exception.handler.CampagneNotFoundException; // <- Ajout ici

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ InvestisseurNotFoundException.class,
            InvestissementNotFoundException.class,
            DividendeNotFoundException.class,
            PorteurProjetNotFoundException.class,
            ProjetNotFoundException.class,
            SiteProjetNotFoundException.class,
            UserNotFoundException.class,
            CampagneNotFoundException.class }) // <- Ajout ici
    public ResponseEntity<ErrorResponse> handleNotFoundExceptions(RuntimeException ex, HttpServletRequest request) {
        ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException ex,
            HttpServletRequest request) {
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex, HttpServletRequest request) {
        ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Une erreur inattendue est survenue");
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
