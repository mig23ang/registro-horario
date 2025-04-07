package registro.samtel.horas.services.contract;

import registro.samtel.horas.models.entities.UsuarioEntity;

import java.util.List;

public interface UsuarioService {

    UsuarioEntity crearUsuario(UsuarioEntity usuario);

    UsuarioEntity consultarUsuarioPorId(Long id);

    UsuarioEntity editarUsuarioPorId(Long id, UsuarioEntity usuario);

    Boolean eliminarUsuarioPorId(Long id, Boolean estado);

    List<UsuarioEntity> consultarTodosUsuarios();
}
