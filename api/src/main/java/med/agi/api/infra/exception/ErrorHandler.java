package med.agi.api.infra.exception;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity errorHandler404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity erroHandler400(MethodArgumentNotValidException exception){
        var error = exception.getFieldErrors();

        return ResponseEntity.badRequest().body(error.stream().map(DadosErroValidacaoDTO:: new).toList());
    }

    private record DadosErroValidacaoDTO(String campo, String mensagem) {
        public DadosErroValidacaoDTO(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
