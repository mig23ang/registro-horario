package registro.samtel.horas.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

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
    // Manejar excepciones personalizadas (ejemplo: usuario no encontrado)

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
}
