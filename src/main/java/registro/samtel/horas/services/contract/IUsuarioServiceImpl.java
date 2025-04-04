package registro.samtel.horas.services.contract;

import registro.samtel.horas.Models.entities.UsuarioEntity;

import java.util.List;

public interface IUsuarioServiceImpl {
    UsuarioEntity crearUsuario(UsuarioEntity usuario);

    UsuarioEntity consultarUsuarioPorId(Long id);

    UsuarioEntity editarUsuarioPorId(Long id, UsuarioEntity usuario);

    Boolean eliminarUsuarioPorId(Long id, Boolean estado);

    List<UsuarioEntity> consultarTodosUsuarios();
}
