package registro.samtel.horas.utils.exceptions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Value("${MI_VARIABLE:valor_default}")
    String MI_VARIABLE;

    // Manejo general
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex) {
        return buildErrorResponse("Error interno del servidor", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Usuario no encontrado
    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> handleUsuarioNoEncontrado(UsuarioNoEncontradoException ex) {
        return buildErrorResponse("Usuario no encontrado", ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Registro no encontrado
    @ExceptionHandler(RegistroNoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> handleRegistroNoEncontrado(RegistroNoEncontradoException ex) {
        return buildErrorResponse("RegistroHora no encontrado", ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Integridad de datos (correo duplicado, etc.)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, Object>> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        String detalle = "Verifica los datos enviados";
        String mensaje = ex.getRootCause() != null ? ex.getRootCause().getMessage() : ex.getMessage();

        if (mensaje != null) {
            if (mensaje.toLowerCase().contains("correo")) {
                detalle = "El correo electrónico ya está registrado";
            } else if (mensaje.toLowerCase().contains("usuario")) {
                detalle = "Ya existe un usuario con estos datos";
            }
            // Puedes agregar más validaciones por campos si lo deseas
        }

        return buildErrorResponse("Error de integridad de datos", detalle, HttpStatus.BAD_REQUEST);
    }

    // Construcción del JSON de error
    private ResponseEntity<Map<String, Object>> buildErrorResponse(String error, String detalle, HttpStatus status) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("error", error);
        response.put("detalle", detalle);
        response.put("status", status.value());
        return new ResponseEntity<>(response, status);
    }
}
