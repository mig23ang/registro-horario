package registro.samtel.horas.services.contract;

import registro.samtel.horas.models.entities.UsuarioEntity;
import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    List<UsuarioEntity> listarUsuarios();

    Optional<UsuarioEntity> obtenerUsuarioPorId(Long id);

    UsuarioEntity guardarUsuario(UsuarioEntity usuario);

    Optional<UsuarioEntity> actualizarUsuario(Long id, UsuarioEntity usuarioActualizado);

    boolean eliminarUsuario(Long id);

}

