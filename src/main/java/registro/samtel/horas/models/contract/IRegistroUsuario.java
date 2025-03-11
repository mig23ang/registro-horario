package registro.samtel.horas.models.contract;


import org.springframework.data.jpa.repository.JpaRepository;
import registro.samtel.horas.models.entities.RegistroEntity;

import java.util.List;

public interface IRegistroUsuario extends JpaRepository<RegistroEntity, Long> {

    //crear metodos para la consulta de la base de datos

    /**
     * obtener todos los registros de la base de datos
     * */
    List<RegistroEntity> listarTodosLosRegistros();

    /**
     * obtener un registro por su id
     *
     */
    RegistroEntity obtenerRegistroPorId(Long id);

    /**
     * Crear un registro obteniendo el id del usuario
     *
     */
    RegistroEntity crearRegistro(RegistroEntity registro, Long idUsuario);
}
