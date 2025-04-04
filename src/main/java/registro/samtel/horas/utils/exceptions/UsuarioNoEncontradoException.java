package registro.samtel.horas.utils.exceptions;


public class UsuarioNoEncontradoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UsuarioNoEncontradoException(String message) {
        super(message);
    }

    public UsuarioNoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }
}