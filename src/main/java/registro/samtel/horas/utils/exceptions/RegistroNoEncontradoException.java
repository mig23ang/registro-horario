package registro.samtel.horas.utils.exceptions;

public class RegistroNoEncontradoException extends RuntimeException {
    private static final long serieVersionUID = 1L;

    public RegistroNoEncontradoException(String message) {
        super(message);
    }
}
