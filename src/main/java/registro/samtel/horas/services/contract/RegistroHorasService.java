package registro.samtel.horas.services.contract;

import registro.samtel.horas.models.entities.RegistroHorasEntity;

import java.util.List;

public interface RegistroHorasService {

    RegistroHorasEntity crearRegistro(RegistroHorasEntity registro);

    List<RegistroHorasEntity> consultarTodosRegistros();

    RegistroHorasEntity consultarRegistroPorId(Long id);

    List<RegistroHorasEntity> consultarTodosRegistrosUsuario(Long idUsuario);

    List<RegistroHorasEntity> consultarTodosRegistrosPorFecha(String fechaStr);

    Boolean eliminarRegistro(Long id, Boolean estado);

    /*
    RegistroHorasEntity consultarEstadoUsuario(Long id);
     */
}
