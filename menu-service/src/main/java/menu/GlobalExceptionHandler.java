package menu;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Map;
import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex){
    	Map<String, String> errors = new HashMap<>();
    	
    	ex.getBindingResult().getFieldErrors().forEach(error -> 
    			errors.put(error.getField(), error.getDefaultMessage())
    	);
    	
    	return ResponseEntity.badRequest().body(errors);
    }
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleJsonParseError(HttpMessageNotReadableException ex) {
        if (ex.getMessage().contains("Category")) {
            return ResponseEntity.badRequest()
                .body("Invalid category. Allowed values: FOOD, DRINK, DESERT.");
        }
        return ResponseEntity.badRequest()
            .body("Malformed JSON or invalid data format.");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleNotFound(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
