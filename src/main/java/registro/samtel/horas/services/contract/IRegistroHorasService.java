package registro.samtel.horas.services.contract;

import registro.samtel.horas.models.entities.RegistroEntity;

import java.util.List;
import java.util.Optional;

public interface IRegistroHorasService {
    RegistroEntity crearRegistro(RegistroEntity registro);

    RegistroEntity consultarRegistroPorId(Long id);

    List<RegistroEntity> consultarTodosRegistros();

    List<RegistroEntity> consultarTodosRegistrosUsuario(Long idUsuario);

    Optional<RegistroEntity> consultarEstadoUsuario(Long id, Long idUsuario);

}
