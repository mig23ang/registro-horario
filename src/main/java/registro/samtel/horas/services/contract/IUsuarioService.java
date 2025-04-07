package registro.samtel.horas.services.contract;

import registro.samtel.horas.models.entities.UsuarioEntity;

import java.util.List;

<<<<<<<< HEAD:src/main/java/registro/samtel/horas/services/contract/UsuarioService.java
public interface UsuarioService {

========
public interface IUsuarioService {
>>>>>>>> 0e4d1e3144329c9f422ba96211a9a554e4df7d8e:src/main/java/registro/samtel/horas/services/contract/IUsuarioService.java
    UsuarioEntity crearUsuario(UsuarioEntity usuario);

    UsuarioEntity consultarUsuarioPorId(Long id);

    UsuarioEntity editarUsuarioPorId(Long id, UsuarioEntity usuario);

    Boolean eliminarUsuarioPorId(Long id, Boolean estado);

    List<UsuarioEntity> consultarTodosUsuarios();
}
