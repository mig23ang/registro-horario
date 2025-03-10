package registro.samtel.horas.repository.contract;


import org.springframework.data.jpa.repository.JpaRepository;
import registro.samtel.horas.repository.models.UsuarioEntity;

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
}
