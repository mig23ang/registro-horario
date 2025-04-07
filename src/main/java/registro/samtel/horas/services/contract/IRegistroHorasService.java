package registro.samtel.horas.services.contract;

import registro.samtel.horas.models.entities.RegistroHorasEntity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IRegistroHorasService {
    RegistroHorasEntity crearRegistro(RegistroHorasEntity registro);

    RegistroHorasEntity consultarRegistroPorId(Long id);

    List<RegistroHorasEntity> consultarTodosRegistros();

    List<RegistroHorasEntity> consultarTodosRegistrosUsuario(Long idUsuario);

//    Optional<RegistroHorasEntity> consultarEstadoUsuario(Long id, Long idUsuario);
    Optional<Map<String, Boolean>> consultarEstadoUsuario(Long id, Long idUsuario);

    Boolean eliminarRegistroPorId(Long id, Boolean estado);

    List<RegistroHorasEntity> consultarRegistrosPorFecha(LocalDate fechaInicio, LocalDate fechaFin);

}

