package registro.samtel.horas.models.contract;


import org.springframework.data.jpa.repository.JpaRepository;
import registro.samtel.horas.models.entities.UsuarioEntity;

import java.util.List;

public interface IUsuarioEntity extends JpaRepository<UsuarioEntity, Long> {

    //crear metodos para la consulta de la base de datos


    /**
     * obtener todos los usarios de la base de datos
     * */
    List<UsuarioEntity> listarTodosLosUsuarios();


    /**
     * obtener un usuario por su id
     *
     */
    UsuarioEntity obtenerUsuarioPorId(Long id);


    /**
     * Crear un usuario
     *
     */
    UsuarioEntity crearUsuario(UsuarioEntity usuario);
}
