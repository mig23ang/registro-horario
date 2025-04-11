package registro.samtel.horas.utils.exceptions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // llamar variable de entorno
    @Value("${MI_VARIABLE}")
    String MI_VARIABLE;
    // Manejar cualquier excepción general
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex) {
        return buildErrorResponse("Error interno del servidor", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Manejar excepciones personalizadas (ejemplo: usuario no encontrado)
    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> handleUsuarioNoEncontrado(UsuarioNoEncontradoException ex) {
        return buildErrorResponse("Usuario no encontrado", ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Manejar excepciones personalizadas (registroHora no encontrado)
    @ExceptionHandler(RegistroNoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> handleRegistroNoEncontrado(RegistroNoEncontradoException ex) {
        return buildErrorResponse("RegistroHora no encontrado", ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Manejar errores de base de datos
    @ExceptionHandler(org.springframework.dao.DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, Object>> handleDataIntegrityViolation(org.springframework.dao.DataIntegrityViolationException ex) {
        return buildErrorResponse("Error de integridad de datos", "Verifica los datos enviados", HttpStatus.BAD_REQUEST);
    }

    // Construir la respuesta de error en formato JSON
    private ResponseEntity<Map<String, Object>> buildErrorResponse(String error, String detalle, HttpStatus status) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("error", error);
        response.put("detalle", detalle);
        response.put("status", status.value());
        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new HashMap<>();

        // Recorre los errores de validación y agregarlos al mapa
        //devuelve objeto con la info de la validación-lista de errores-recorre cada error
        ex.getBindingResult().getFieldErrors().forEach(error ->
                //error.getField() obtiene el campo que falló la validación
                //error.getDefaultMessage() obtiene el mensaje de error
                errores.put(error.getField(), error.getDefaultMessage())
        );

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("error", "Error de validación");
        response.put("detalle", errores); // Detalle de los errores
        response.put("status", HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }



}
